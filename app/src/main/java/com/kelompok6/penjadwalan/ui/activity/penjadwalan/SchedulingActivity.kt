package com.kelompok6.penjadwalan.ui.activity.penjadwalan

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kelompok6.penjadwalan.databinding.ActivitySchedulingBinding
import com.kelompok6.penjadwalan.model.GetScheduleResponse
import com.kelompok6.penjadwalan.model.GetScheduleResponseItem
import com.kelompok6.penjadwalan.other.UserPreferences
import com.kelompok6.penjadwalan.ui.activity.penjadwalan.AddScheduleActivity.Companion.CHECK_COME
import com.kelompok6.penjadwalan.ui.activity.penjadwalan.ScheduleDetailActivity.Companion.EXTRA_CLASS_CODE
import com.kelompok6.penjadwalan.ui.activity.penjadwalan.ScheduleDetailActivity.Companion.EXTRA_COURSE_CODE
import com.kelompok6.penjadwalan.ui.activity.penjadwalan.ScheduleDetailActivity.Companion.EXTRA_DAY
import com.kelompok6.penjadwalan.ui.activity.penjadwalan.ScheduleDetailActivity.Companion.EXTRA_ID_JADWAL
import com.kelompok6.penjadwalan.ui.activity.penjadwalan.ScheduleDetailActivity.Companion.EXTRA_NIP
import com.kelompok6.penjadwalan.ui.activity.penjadwalan.ScheduleDetailActivity.Companion.EXTRA_ROOM_CODE
import com.kelompok6.penjadwalan.ui.activity.penjadwalan.ScheduleDetailActivity.Companion.EXTRA_TIME
import com.kelompok6.penjadwalan.ui.viewmodel.ViewModelFactory

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("settings")
class SchedulingActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySchedulingBinding
    private lateinit var schedulingViewModel: SchedulingViewModel
    private lateinit var adapter: ScheduleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySchedulingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            progressBar2.visibility = View.VISIBLE

            adapter = ScheduleAdapter()
            adapter.notifyDataSetChanged()
            rvScheduling.layoutManager = LinearLayoutManager(this@SchedulingActivity)
            rvScheduling.setHasFixedSize(true)
            rvScheduling.adapter = adapter
            addSchedule.setOnClickListener {
                val intent = Intent(this@SchedulingActivity, AddScheduleActivity::class.java)
                intent.putExtra(CHECK_COME,"2")
                startActivity(intent)
            }
        }

        schedulingViewModel = ViewModelProvider(
            this,
            ViewModelFactory(UserPreferences.getInstance(dataStore))
        )[SchedulingViewModel::class.java]

        schedulingViewModel.setSchedule{
            schedulingViewModel.getSchedule().observe(this){
                adapter.setList(it)
            }
            binding.progressBar2.visibility = View.GONE
        }
        adapter.setOnItemClickCallback(object : ScheduleAdapter.OnItemClickCallback{
            override fun onItemClicked(data: GetScheduleResponseItem) {
                Intent(this@SchedulingActivity, ScheduleDetailActivity::class.java).also{
                    it.putExtra(EXTRA_ID_JADWAL, data.id_jadwal)
                    it.putExtra(EXTRA_CLASS_CODE, data.kode_kelas)
                    it.putExtra(EXTRA_DAY, data.hari)
                    it.putExtra(EXTRA_TIME, "${data.jam_awal} - ${data.jam_selesai}")
                    it.putExtra(EXTRA_NIP, data.nip)
                    it.putExtra(EXTRA_COURSE_CODE, data.kode_mata_pelajaran)
                    it.putExtra(EXTRA_ROOM_CODE, data.kode_ruang)
                    startActivity(it)
                }
            }

        })

    }

    override fun onResume() {
        // After a pause OR at startup
        super.onResume()
        schedulingViewModel.setSchedule{
            schedulingViewModel.getSchedule().observe(this){
                adapter.setList(it)
            }
            binding.progressBar2.visibility = View.GONE
        }
    }
}