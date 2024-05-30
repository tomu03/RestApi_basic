package com.example.restapiapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProductActivity : AppCompatActivity() {

    private lateinit var productViewModel: ProductViewModel
    private lateinit var productAdapter: ProductApater
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        productAdapter = ProductApater(emptyList())

        val refreshBtn: FloatingActionButton = findViewById(R.id.refresBtn)

        refreshBtn.setOnClickListener {
            startActivity(Intent(this, ProductActivity::class.java))
            finish()
        }


        val recyclerView: RecyclerView = findViewById(R.id.productRv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = productAdapter

        productViewModel.products.observe(this, Observer { products ->
            products?.let {
                productAdapter = ProductApater(it)
                recyclerView.adapter = productAdapter
            }
        })

    }
}