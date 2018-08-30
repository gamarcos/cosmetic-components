package br.com.gabrielmarcos.cosmeticallergic.views

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.util.SparseArray
import android.widget.Toast
import br.com.gabrielmarcos.cosmeticallergic.R
import com.google.android.gms.samples.vision.barcodereader.BarcodeGraphic
import com.google.android.gms.vision.barcode.Barcode
import xyz.belvi.mobilevisionbarcodescanner.BarcodeRetriever
import com.google.android.gms.samples.vision.barcodereader.BarcodeCapture



/**
 * Created by Gabriel Marcos on 29/08/2018
 */
class ScannerQrCode: AppCompatActivity(), BarcodeRetriever {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scanner_qr_code)

        val barcodeCapture = supportFragmentManager.findFragmentById(R.id.findComponent) as BarcodeCapture
        barcodeCapture.setRetrieval(this)
    }


    override fun onRetrieved(barcode: Barcode?) {
        startActivity(Intent(this, MainActivity::class.java).putExtra(MainActivity.QR_CODE_RESULT, barcode))
        finish()
    }

    override fun onRetrievedMultiple(closetToClick: Barcode?, barcode: MutableList<BarcodeGraphic>?) {
        runOnUiThread {
            var message = "Code selected : " + closetToClick!!.displayValue + "\n\nother " +
                    "codes in frame include : \n"
            for (index in 0 until barcode!!.size) {
                val barcodeVal = barcode[index].barcode
                message += (index + 1).toString() + ". " + barcodeVal.displayValue + "\n"
            }
            val builder = AlertDialog.Builder(this)
                    .setTitle("code retrieved")
                    .setMessage(message)
            builder.show()
        }
    }

    override fun onBitmapScanned(sparseArray: SparseArray<Barcode>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRetrievedFailed(reason: String?) {
        Toast.makeText(this, reason, Toast.LENGTH_LONG).show()
    }

    override fun onPermissionRequestDenied() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}