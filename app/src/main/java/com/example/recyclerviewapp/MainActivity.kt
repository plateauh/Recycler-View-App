package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

lateinit var itemsRv: RecyclerView
lateinit var items: ArrayList<String>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        items = arrayListOf<String>()
        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener{
            val input = findViewById<TextView>(R.id.etInput)
            items.add(input.text.toString())
            input.text = ""
            updateRecyclerView()
        }


    }

    fun updateRecyclerView() {
        itemsRv = findViewById<RecyclerView>(R.id.rvItems)
        itemsRv.adapter = RecyclerViewAdapter(items)
        itemsRv.layoutManager = LinearLayoutManager(this)
    }
}