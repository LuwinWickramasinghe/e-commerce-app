//Recycler View

package com.example.shoppingapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso


class MyAdapter(val context: Activity, val productList: List<Product>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    //if Layout manager fails to create view for some data then this method is used for ask to create view for the data
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.each_item, parent, false)
        return MyViewHolder(itemView)

    }

    //populate data in the view
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productList[position]

        holder.title.text = currentItem.title

        //picasso is used for get images from link and then cache it and put into image view
        Picasso.get().load(currentItem.thumbnail).into(holder.image)
    }

    override fun getItemCount(): Int {
        return productList.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ShapeableImageView = itemView.findViewById(R.id.productImage)
        var title: TextView = itemView.findViewById(R.id.productName)

    }

}