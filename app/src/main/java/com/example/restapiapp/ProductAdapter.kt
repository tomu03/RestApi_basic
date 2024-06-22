package com.example.restapiapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter(private val products:List<Product>): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val productImage: ImageView = itemView.findViewById(R.id.profileImg)
        private val productName: TextView = itemView.findViewById(R.id.nameTxt)
        private val productPrice: TextView = itemView.findViewById(R.id.pricetxt)
        private val productDescription: TextView = itemView.findViewById(R.id.derictxt)

        fun bind(product: Product) {
            Glide.with(itemView)
                .load(product.images[0])
                .into(productImage)
            productName.text = product.title
            productPrice.text = "$${product.price}"
            productDescription.text= product.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list,parent,false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }
}