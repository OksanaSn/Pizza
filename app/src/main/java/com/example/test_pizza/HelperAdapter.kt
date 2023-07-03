package com.example.test_pizza


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class HelperAdapter : RecyclerView.Adapter<HelperAdapter.PizzaHolder>() {


    private val itemTitles = arrayOf("text 1", "text 2", "text 3", "text 4")
    private val itemDess = arrayOf("textDes 1", "textDes 2", "textDes 3", "textDes 4")
    private val itemImages = arrayOf(
        R.drawable.pizza1,
        R.drawable.pizza2,
        R.drawable.pizza3,
        R.drawable.pizza4
    )

    inner class PizzaHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        var image : ImageView
        var textTitle : TextView
        var textDes : TextView

        init {
            image = itemView.findViewById(R.id.imageView6)
            textTitle = itemView.findViewById(R.id.titile_pizza)
            textDes = itemView.findViewById(R.id.textView4)
        }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HelperAdapter.PizzaHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pizza_item, parent, false)
        return PizzaHolder(view)
    }
    override fun onBindViewHolder(holder: HelperAdapter.PizzaHolder, position: Int) {
        holder.textTitle.text = itemTitles [position]
        holder.textDes.text = itemDess [position]
        holder.image.setImageResource(itemImages[position])

        holder.itemView.setOnClickListener {view: View->
            Toast.makeText(view.context, "Clicked on the item", Toast.LENGTH_SHORT).show()
        }
    }
    override fun getItemCount(): Int {
        return itemTitles.size
    }

}

