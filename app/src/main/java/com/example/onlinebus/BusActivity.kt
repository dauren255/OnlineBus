package com.example.onlinebus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus)
        setupViews()
    }

    private fun setupViews() {
        val recyclerViewForSearch = findViewById<RecyclerView>(R.id.bus_recycler_view)
        recyclerViewForSearch.setHasFixedSize(true)
        recyclerViewForSearch.layoutManager = LinearLayoutManager(this)
        val arrs = mutableListOf(
            Bus(R.drawable.ic_launcher_foreground, "Almaty","Nur-sultan",50,25,"12:50","20:30",460,"Mercedes",2012, "02AZA211"),
            Bus(R.drawable.ic_launcher_foreground, "Almaty","Nur-sultan",50,25,"12:50","20:30",460,"Mercedes",2012, "02AZA211")
        )
        recyclerViewForSearch.adapter = BusAdapter(applicationContext, arrs, onItemClick = {
            val intent = Intent(this, OrderActivity::class.java)
            intent.putExtra(OrderActivity.EXTRA_DATA, it)
            startActivity(intent)
        })
    }

}