package br.com.gabrielmarcos.cosmeticallergic.views

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.com.gabrielmarcos.cosmeticallergic.R
import br.com.gabrielmarcos.cosmeticallergic.views.adapter.SelectedComponentsAdapter
import com.jaredrummler.materialspinner.MaterialSpinner
import kotlinx.android.synthetic.main.activity_register_components.*

/**
 * Created by Gabriel Marcos on 29/08/2018
 */
class RegisterComponentsActivity: Activity(), SelectedComponentsAdapter.SelectedComponentsAdapterListener {

    private var componentsSelected = ArrayList<String?>()
    private var listComponents = arrayListOf("lcohol", "parfum", "aqua", "polyglyceryl-3 caprylate",
            "bht", "denatonium benzoate", "benzyl salicylate", "hydroxycitronellal", "butylphenyl methylpropional",
            "alpha-isomethyl ionone", "limonene", "hydroxyisohexyl", "Vegan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_components)

        setupSpinner()

        registerSpinner.setOnItemSelectedListener(object : MaterialSpinner.OnItemSelectedListener<String> {
            override fun onItemSelected(view: MaterialSpinner?, position: Int, id: Long, item: String?) {
                componentsSelected.add(item)
                listComponents.remove(item)
                registerSelectedComponents.adapter.notifyDataSetChanged()
                setupSpinner()
            }
        })

        setupAdapter()

        registerButtonFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(MainActivity.SELECTED_COMPONENTS, componentsSelected)
            startActivity(intent)
        }
    }

    private fun setupSpinner() {
        registerSpinner.setItems(listComponents)
    }

    private fun setupAdapter() {
        registerSelectedComponents.adapter = SelectedComponentsAdapter(this, componentsSelected,this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        registerSelectedComponents.layoutManager = layoutManager
    }

    override fun onRemoveItem(component: String) {
        componentsSelected.remove(component)
        listComponents.add(component)
        registerSelectedComponents.adapter.notifyDataSetChanged()
        setupSpinner()
    }
}