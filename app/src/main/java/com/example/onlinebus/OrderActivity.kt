package com.example.onlinebus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog;

class OrderActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        setupViews()
    }

    private fun setupViews() {
        val data = intent.getParcelableExtra<Bus>(EXTRA_DATA)

        val orderBusImage = findViewById<ImageView>(R.id.orderBusImage)
        val orderArAndDestPlaces = findViewById<TextView>(R.id.orderArAndDestPlaces)
        val orderFreePlaces = findViewById<TextView>(R.id.orderFreePlaces)
        val orderPlaces = findViewById<TextView>(R.id.orderPlaces)
        val orderArrivalTime = findViewById<TextView>(R.id.orderArrivalTime)
        val orderDestinationTime = findViewById<TextView>(R.id.orderDestinationTime)
        val orderDuration = findViewById<TextView>(R.id.orderDuration)
        val orderBusMark = findViewById<TextView>(R.id.orderBusMark)
        val orderBusMadeYear = findViewById<TextView>(R.id.orderBusMadeYear)
        val orderBusNumber = findViewById<TextView>(R.id.orderBusNumber)

        Glide.with(applicationContext).load(data?.busImage).into(orderBusImage)
        orderArAndDestPlaces.text = data?.arrivalPlace + " -> " + data?.destinationPlace
        orderPlaces.text = "Коль-во мест: " + data?.places.toString()
        orderFreePlaces.text = "Свободные места: " + data?.freePlaces.toString()
        orderArrivalTime.text = "Отправление: " + data?.arrivalTime
        orderDestinationTime.text = "Прибытие: " + data?.destinationTime
        orderDuration.text = "Длительность: " + data?.duration.toString()
        orderBusMark.text = "Марка автобуса: " + data?.busMark
        orderBusMadeYear.text = "Год выпуска: " + data?.busMadeYear.toString()
        orderBusNumber.text = "Гос. Номер: " + data?.busNumber

        val orderButton = findViewById<Button>(R.id.orderButton)

        orderButton.setOnClickListener{
            val dialog = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.layout_bottom_sheet, null)
            val sheetOrderButton = view.findViewById<Button>(R.id.sheetOrderButton)
            sheetOrderButton.setOnClickListener(View.OnClickListener { view ->
                dialog.dismiss()
                finish();
                startActivity(getIntent());
            })
            dialog.setContentView(view)
            dialog.show()
        }






    }
}