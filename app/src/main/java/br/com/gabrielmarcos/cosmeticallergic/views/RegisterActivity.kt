package br.com.gabrielmarcos.cosmeticallergic.views

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import br.com.gabrielmarcos.cosmeticallergic.R
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register_components.*

/**
 * Created by Gabriel Marcos on 29/08/2018
 */
class RegisterActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerButtonNext.setOnClickListener {
            val intent = Intent(this, RegisterComponentsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}