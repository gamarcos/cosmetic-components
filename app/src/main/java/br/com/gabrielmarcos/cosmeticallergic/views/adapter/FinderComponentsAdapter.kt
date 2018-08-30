package br.com.gabrielmarcos.cosmeticallergic.views.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.gabrielmarcos.cosmeticallergic.R
import br.com.gabrielmarcos.cosmeticallergic.models.ProductModel
import kotlinx.android.synthetic.main.adapter_finder_components.view.*

/**
 * Created by Gabriel Marcos on 30/08/2018
 */
class FinderComponentsAdapter(private val context: Context,
                              private val products: ArrayList<ProductModel>,
                              private val listener: FinderComponentsAdapterListener): RecyclerView.Adapter<FinderComponentsAdapter.ViewHolder>() {

    interface FinderComponentsAdapterListener {
        fun onCardClicked(product: ProductModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_finder_components, parent, false)
        return ViewHolder(view, listener, context)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(products[position])
    }

    class ViewHolder(itemView: View, val listener: FinderComponentsAdapterListener, val context: Context) : RecyclerView.ViewHolder(itemView) {
        fun bindView(product: ProductModel) {

            itemView.productName.text = product.name

            itemView.productCard.setOnClickListener {
                listener.onCardClicked(product)
            }
        }
    }
}