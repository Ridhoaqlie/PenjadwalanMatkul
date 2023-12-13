package com.kelompok6.penjadwalan.ui.activity.pelajaran

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelompok6.penjadwalan.R
import com.kelompok6.penjadwalan.model.DataClass
import com.kelompok6.penjadwalan.model.DataCourse


class CourseAdapter(private val context: Context,
                   private val dataCourse: List<DataCourse>): RecyclerView.Adapter<CourseAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.course_item,parent,false)
        )
    }

    class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){
        val nameCourse = itemView.findViewById<TextView>(R.id.nama_mapel)
        val codeCourse = itemView.findViewById<TextView>(R.id.kode_mapel)
        val yearCourse = itemView.findViewById<TextView>(R.id.tahun_mapel)
        fun bindView(dataCourse: DataCourse){
            nameCourse.text = dataCourse.nama_pelajaran
            codeCourse.text = dataCourse.kode_pelajaran
            yearCourse.text = dataCourse.tahun_ajar

        }
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(dataCourse[position])
    }

    override fun getItemCount(): Int = dataCourse.size
}