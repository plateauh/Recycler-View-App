package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

lateinit var itemsRv: RecyclerView
lateinit var items: ArrayList<String>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        items = arrayListOf()
        val btn = findViewById<Button>(R.id.btn)
        val input = findViewById<EditText>(R.id.etInput)

        btn.setOnClickListener {
            addItem(input.text.toString())
            input.setText("")
            updateRecyclerView()
        }

    }

    private fun addItem(text: String){
        if (text.isNotEmpty())
            items.add(text)
        else
            Snackbar.make(cl, "Please enter something", Snackbar.LENGTH_LONG).show()
    }

    private fun updateRecyclerView() {
        itemsRv = findViewById(R.id.rvItems)
        itemsRv.adapter = RecyclerViewAdapter(items)
        itemsRv.layoutManager = LinearLayoutManager(this)
    }
}