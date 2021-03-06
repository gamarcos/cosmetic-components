package br.com.gabrielmarcos.cosmeticallergic.services.helper

import br.com.gabrielmarcos.cosmeticallergic.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Gabriel Marcos on 29/08/2018
 */
class RetrofitHelper {

    companion object {
        fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                    .addCallAdapterFactory(
                            RxJava2CallAdapterFactory.create())
                    .addConverterFactory(
                            GsonConverterFactory.create())
                    .baseUrl(BuildConfig.BASE_URL)
                    .build()
        }
    }
}