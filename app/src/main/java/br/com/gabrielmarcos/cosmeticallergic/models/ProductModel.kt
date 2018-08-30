package br.com.gabrielmarcos.cosmeticallergic.models

/**
 * Created by Gabriel Marcos on 29/08/2018
 */
class ProductModel(val name: String,
                   val vegan: Boolean,
                   val imageUrl: String,
                   val about: String,
                   val olfactoryNotes: String?,
                   val ingredients: ArrayList<String>)