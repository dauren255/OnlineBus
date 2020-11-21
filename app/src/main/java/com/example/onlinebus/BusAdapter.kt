package com.example.onlinebus

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.bus_item.view.*


class BusAdapter(var context: Context, var arrayList: MutableList<Bus>,
                 private val onItemClick: (Bus) -> Unit) : RecyclerView.Adapter<BusAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.bus_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(arrayList[position])
    }

    override fun getItemCount() = arrayList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(bus: Bus){
            Glide.with(context).load(bus.busImage).into(itemView.busImage)
            itemView.arAndDestPlaces.text = bus.arrivalPlace + " -> " + bus.destinationPlace
            itemView.places.text = "Коль-во мест: " + bus.places.toString()
            itemView.freePlaces.text = "Свободные места: " + bus.freePlaces.toString()
            itemView.arrivalTime.text = "Отправление: " + bus.arrivalTime
            itemView.destinationTime.text = "Прибытие: " + bus.destinationTime
            itemView.duration.text = "Длительность: " + bus.duration.toString()
            itemView.busMark.text = "Марка автобуса: " + bus.busMark
            itemView.busMadeYear.text = "Год выпуска: " + bus.busMadeYear.toString()
            itemView.busNumber.text = "Гос. Номер: " + bus.busNumber
            itemView.setOnClickListener{
                onItemClick(bus)
            }
        }
    }
}