package com.example.dodopizza

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(var items: List<Item>, var context: Context) : RecyclerView.Adapter<ItemsAdapter.MyViewHolder>(){

    class  MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val price: TextView = view.findViewById(R.id.item_list_price)
        val image: ImageView = view.findViewById(R.id.item_list_image)
        val title: TextView = view.findViewById(R.id.item_list_title)
        val description: TextView = view.findViewById(R.id.item_list_description)
        val btn : Button = view.findViewById(R.id.item_list_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = items[position]
        holder.image.setImageResource(context.resources.getIdentifier(currentItem.image, "drawable", context.packageName))
        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
        holder.price.text = currentItem.price.toString() + " kzt"

        holder.btn.setOnClickListener {
            val intent = Intent(context, ItemActivity::class.java)

            intent.putExtra("itemImage", context.resources.getIdentifier(currentItem.image, "drawable", context.packageName))
            intent.putExtra("itemTitle", currentItem.title)
            intent.putExtra("itemText", currentItem.description)
            intent.putExtra("itemPrice", "В корзину за " +currentItem.price.toString() + " kzt")

            context.startActivity(intent)
        }
    }
}