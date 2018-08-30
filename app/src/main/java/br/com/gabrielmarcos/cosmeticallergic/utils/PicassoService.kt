package br.com.gabrielmarcos.cosmeticallergic.utils

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by Gabriel Marcos on 29/08/2018
 */
class PicassoService(val context: Context) {
    fun loadImage(url: String?, view: ImageView) {
        Picasso.with(context).load(url).fit().centerCrop().into(view)
    }
}