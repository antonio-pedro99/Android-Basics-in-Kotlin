package com.antdev99.affirmations.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.antdev99.affirmations.R
import com.antdev99.affirmations.model.Affirmation

class ItemAdapter(private val context: Context, private val dataset:List<Affirmation>):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutAdapter = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return  ItemViewHolder(layoutAdapter)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: Affirmation = dataset[position];
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    override fun getItemCount(): Int = dataset.size
}