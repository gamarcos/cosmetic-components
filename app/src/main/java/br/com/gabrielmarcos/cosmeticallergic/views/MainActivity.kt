package br.com.gabrielmarcos.cosmeticallergic.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.com.gabrielmarcos.cosmeticallergic.R
import br.com.gabrielmarcos.cosmeticallergic.models.ProductModel
import br.com.gabrielmarcos.cosmeticallergic.services.ProductService
import br.com.gabrielmarcos.cosmeticallergic.views.adapter.FinderComponentsAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), FinderComponentsAdapter.FinderComponentsAdapterListener {

    companion object {
        const val SELECTED_COMPONENTS = "components"
        const val QR_CODE_RESULT = "qrCodeResult"
    }

    private var productService: ProductService? = null
    private var components = ArrayList<String>()
    private var qrCode: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        components = intent.extras.getStringArrayList(SELECTED_COMPONENTS)
        qrCode = intent.extras.getString(QR_CODE_RESULT)

        setupRequest()
        findReadQrCode.setOnClickListener {
            startActivity(Intent(this, ScannerQrCode::class.java))
        }
    }

    private fun setupRequest() {
        productService = ProductService()

        productService!!.getProducts({ it ->
            setupAdapterProducts(it)
        },{})
    }

    private fun findProductsComponents(products: ArrayList<ProductModel>) {
        var productsApproved = ArrayList<ProductModel>()

    }

    private fun setupAdapterProducts(products: ArrayList<ProductModel>) {
        recyclerView.adapter = FinderComponentsAdapter(this, products,this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

    }

    override fun onCardClicked(product: ProductModel) {

    }
}