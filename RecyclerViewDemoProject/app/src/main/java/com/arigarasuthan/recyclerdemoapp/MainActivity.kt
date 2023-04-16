package com.arigarasuthan.recyclerdemoapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val fruitList = listOf<Fruit>(
        Fruit("Mango", "As"),
        Fruit("Apple", "AK"),
        Fruit("Orange", "KV"),
        Fruit("Banana", "GM"),
        Fruit("Grapes", "HL"),
        Fruit("Pomegrante", "VK")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyler_demoview)
        recyclerView.setBackgroundColor(Color.YELLOW)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerViewAdapter(fruitList) { selectedItem: Fruit ->
            listItemClicked(selectedItem)
        }
    }

    private fun listItemClicked(fruit: Fruit) {
        Toast.makeText(this, "Selected Fruit Is: ${fruit.name}", Toast.LENGTH_LONG).show()

    }
}