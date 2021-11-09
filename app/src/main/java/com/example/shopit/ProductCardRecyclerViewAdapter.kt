package com.example.shopit

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle





/**
 * Adapter used to show a simple grid of products.
 */
class ProductCardRecyclerViewAdapter(private val productList: List<ProductEntry>) : RecyclerView.Adapter<ProductCardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCardViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.shr_product_card, parent, false)
        return ProductCardViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: ProductCardViewHolder, position: Int) {
        if (position < productList.size) {
            val product = productList[position]
            holder.productTitle.text = product.title
            holder.productPrice.text = product.price
            ImageRequester.setImageFromUrl(holder.productImage, product.url)

            holder.productCard.setOnClickListener {
                val context= holder.itemView.context
                val bundle = Bundle()
                val fragmentB = DetailFragment()

                bundle.putString("Title", product.title)
                bundle.putString("Price", product.price)

                fragmentB.arguments = bundle
                (context as NavigationHost).navigateTo(fragmentB, true)
            }

        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}