package com.kelompok6.penjadwalan.ui.activity.ruang

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelompok6.penjadwalan.R
import com.kelompok6.penjadwalan.model.DataClass
import com.kelompok6.penjadwalan.model.DataRoom

class RoomAdapter(private val context: Context,
                   private val dataRoom: List<DataRoom>): RecyclerView.Adapter<RoomAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.class_item,parent,false)
        )
    }

    class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){
        val nameRoom = itemView.findViewById<TextView>(R.id.class_name)
        val codeRoom = itemView.findViewById<TextView>(R.id.class_code)
        fun bindView(dataRoom: DataRoom){
            nameRoom.text = dataRoom.nama_ruang
            codeRoom.text = dataRoom.kode_ruang

        }
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(dataRoom[position])
    }

    override fun getItemCount(): Int = dataRoom.size
}