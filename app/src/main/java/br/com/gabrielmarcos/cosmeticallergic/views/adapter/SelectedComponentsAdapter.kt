package br.com.gabrielmarcos.cosmeticallergic.views.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.gabrielmarcos.cosmeticallergic.R
import kotlinx.android.synthetic.main.adapter_card_selected_components.view.*

/**
 * Created by Gabriel Marcos on 30/08/2018
 */
class SelectedComponentsAdapter(private val context: Context,
                                private val components: ArrayList<String?>,
                                private val listener: SelectedComponentsAdapterListener): RecyclerView.Adapter<SelectedComponentsAdapter.ViewHolder>() {

    interface SelectedComponentsAdapterListener {
        fun onRemoveItem(component: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_card_selected_components, parent, false)
        return ViewHolder(view, listener, context)
    }

    override fun getItemCount(): Int {
        return components.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(components[position])
    }

    class ViewHolder(itemView: View, val listener: SelectedComponentsAdapterListener, val context: Context): RecyclerView.ViewHolder(itemView){
        fun bindView(component: String?) {

            itemView.registerCardComponentTitle.text = component

            itemView.registerRemoveComponent.setOnClickListener {
                listener.onRemoveItem(component!!)
            }
        }
    }
}