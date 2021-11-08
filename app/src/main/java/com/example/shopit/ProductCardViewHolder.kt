package com.example.shopit

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.NetworkImageView

class ProductCardViewHolder(itemView: View) //TODO: Find and store views from itemView
    : RecyclerView.ViewHolder(itemView){

    var productImage: NetworkImageView = itemView.findViewById(R.id.product_image)
    var productTitle: TextView = itemView.findViewById(R.id.product_title)
    var productPrice: TextView = itemView.findViewById(R.id.product_price)
    }