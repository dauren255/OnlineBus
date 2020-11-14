package com.example.onlinebus

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
    }

    private fun setupViews() {
        val fromPlace = findViewById<EditText>(R.id.fromPlace)
        val toPlace = findViewById<EditText>(R.id.toPlace)
        val datePick = findViewById<Button>(R.id.datePick)
        val searchPick = findViewById<Button>(R.id.search)
        datePick.setOnClickListener {
            val cal = Calendar.getInstance()
            val dateSetListener =
                DatePickerDialog.OnDateSetListener() { datePicker, year, month, day ->
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, month)
                    cal.set(Calendar.DAY_OF_MONTH, day)
                    datePick.text = SimpleDateFormat("dd.MM.yyyy").format(cal.time)
                }
            DatePickerDialog(
                this,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        searchPick.setOnClickListener{
            if(fromPlace.text.toString()!="" && toPlace.text.toString()!=""){
                val intent = Intent(this, BusActivity::class.java)
                startActivity(intent)
            }
        }
    }
}