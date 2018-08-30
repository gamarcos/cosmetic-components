package br.com.gabrielmarcos.cosmeticallergic.services

import android.content.Context
import br.com.gabrielmarcos.cosmeticallergic.models.ProductModel
import br.com.gabrielmarcos.cosmeticallergic.services.helper.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Gabriel Marcos on 29/08/2018
 */
class ProductService() {

    private val productService by lazy {
        RetrofitHelper.getRetrofit().create(ProductServiceInterface::class.java)
    }

    fun getProducts(successCallback: (products: ArrayList<ProductModel>) -> Unit,
                    errorCallback: (err: Throwable) -> Unit) {
        val call = productService.getProducts()

        call.enqueue(object : Callback<ArrayList<ProductModel>> {
            override fun onFailure(call: Call<ArrayList<ProductModel>>?, t: Throwable?) {
                errorCallback(t!!)
            }

            override fun onResponse(call: Call<ArrayList<ProductModel>>?, response: Response<ArrayList<ProductModel>>?) {
                successCallback(response!!.body()!!)
            }

        })

    }
}