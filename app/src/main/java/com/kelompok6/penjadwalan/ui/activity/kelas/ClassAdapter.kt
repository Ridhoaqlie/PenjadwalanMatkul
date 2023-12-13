package com.kelompok6.penjadwalan.ui.activity.kelas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelompok6.penjadwalan.R
import com.kelompok6.penjadwalan.model.DataClass


class ClassAdapter(private val context: Context,
                   private val dataClass: List<DataClass>): RecyclerView.Adapter<ClassAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.class_item,parent,false)
        )
    }

    class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){
        val nameClass = itemView.findViewById<TextView>(R.id.class_name)
        val codeClass = itemView.findViewById<TextView>(R.id.class_code)
        fun bindView(dataClass: DataClass){
            nameClass.text = dataClass.nama_kelas
            codeClass.text = dataClass.kode_kelas

        }
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(dataClass[position])
    }

    override fun getItemCount(): Int = dataClass.size
}