package com.kelompok6.penjadwalan.ui.activity.dosen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelompok6.penjadwalan.R
import com.kelompok6.penjadwalan.model.DataLecturer

class LecturerAdapter(private val context: Context,
private val dataLecturer: List<DataLecturer>,val listener: (DataLecturer)-> Unit): RecyclerView.Adapter<LecturerAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.lecture_item,parent,false)
        )
    }

    class ViewHolder(itemView: View)
        :RecyclerView.ViewHolder(itemView){
        val nameLecturer = itemView.findViewById<TextView>(R.id.nama_dosen)
        val nipLecturer = itemView.findViewById<TextView>(R.id.nip_dosen)
        fun bindView(dataLecturer: DataLecturer, listener: (DataLecturer) -> Unit){
            nameLecturer.text = dataLecturer.nama_dosen
            nipLecturer.text = dataLecturer.nip
            itemView.setOnClickListener{
            listener(dataLecturer)
            }
        }
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(dataLecturer[position],listener)
    }

    override fun getItemCount(): Int = dataLecturer.size
}