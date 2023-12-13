package com.kelompok6.penjadwalan.ui.activity.penjadwalan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kelompok6.penjadwalan.databinding.SchedulingItemBinding
import com.kelompok6.penjadwalan.model.GetScheduleResponse
import com.kelompok6.penjadwalan.model.GetScheduleResponseItem

class ScheduleAdapter: RecyclerView.Adapter<ScheduleAdapter.UserViewHolder>(){

    private val list = ArrayList<GetScheduleResponseItem>()

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback (onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    fun setList(schedule: ArrayList<GetScheduleResponseItem>){
        list.clear()
        list.addAll(schedule)
        notifyDataSetChanged()
    }

    inner class UserViewHolder(val binding: SchedulingItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(schedule: GetScheduleResponseItem){
            binding.apply{
                root.setOnClickListener {
                    onItemClickCallback?.onItemClicked(schedule)
                }
                namaPelajaran.text = schedule.kode_mata_pelajaran
                hari.text = schedule.hari
                kodeRuang.text = schedule.kode_ruang
                dosen.text = "With ${schedule.nip}"
                jam.text = "${schedule.jam_awal} - ${schedule.jam_selesai}"

            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = SchedulingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder((view))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickCallback{
        fun onItemClicked(data: GetScheduleResponseItem)
    }

}