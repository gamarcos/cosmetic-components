package br.com.gabrielmarcos.cosmeticallergic.services

import br.com.gabrielmarcos.cosmeticallergic.BuildConfig
import br.com.gabrielmarcos.cosmeticallergic.models.ProductModel
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Gabriel Marcos on 29/08/2018
 */
interface ProductServiceInterface {
    @GET(BuildConfig.URL_PRODUCTS)
    fun getProducts(): Call<ArrayList<ProductModel>>
}