package com.example.test_pizza

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test_pizza.databinding.PizzaItemBinding
import java.io.IOException
import java.io.InputStream

class PizzaAdapter: RecyclerView.Adapter<PizzaAdapter.PizzaHolder>() {

    val pizzaList = ArrayList <Pizza>()

    class PizzaHolder (item: View): RecyclerView.ViewHolder(item) {
        val binding = PizzaItemBinding.bind(item)
        fun bind (pizza: Pizza) = with(binding){

            titilePizza.text=pizza.name
            imageView6.setImageResource(pizza.image)



            /*var json : String ? = null

            try {
                val inputStream : InputStream = assets.open("pizza_data.json")
                json = inputStream.bufferedReader().use {it.readText()}

                title_pizza.json = json
            }
            catch (e: IOException){}
        }

*/


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pizza_item, parent, false)
        return PizzaHolder(view)
    }
    override fun onBindViewHolder(holder: PizzaHolder, position: Int) {
        holder.bind(pizzaList[position])
    }
    override fun getItemCount(): Int {
       return pizzaList.size
    }


    fun addPizza(pizza: Pizza){
        pizzaList.add(pizza)
        notifyDataSetChanged()
    }


}