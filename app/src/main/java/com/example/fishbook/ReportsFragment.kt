package com.example.fishbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fishbook.databinding.FragmentReportsBinding
import com.google.android.material.tabs.TabLayout

class ReportsFragment : Fragment() {

    private var _binding: FragmentReportsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ReportAdapter
    private val allReports = mutableListOf<Report>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReportsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupData()
        setupRecyclerView(allReports)
        setupTabLayout()
    }

    private fun setupData() {
        allReports.add(Report("Jalan Rusak di Dusun A", "Diproses", "Ada lubang besar di tengah jalan utama yang membahayakan pengendara.", "12 Okt 2023"))
        allReports.add(Report("Lampu Jalan Padam", "Selesai", "Lampu jalan di area taman desa sudah 3 hari tidak menyala.", "15 Okt 2023"))
        allReports.add(Report("Sampah Menumpuk", "Diproses", "Tempat pembuangan sementara penuh dan mulai berbau tidak sedap.", "18 Okt 2023"))
        allReports.add(Report("Saluran Air Tersumbat", "Diproses", "Drainase depan pasar tersumbat sampah, air meluap saat hujan.", "20 Okt 2023"))
        allReports.add(Report("Pohon Tumbang", "Selesai", "Pohon peneduh di pinggir jalan roboh menutupi sebagian akses.", "22 Okt 2023"))
    }

    private fun setupRecyclerView(reports: List<Report>) {
        adapter = ReportAdapter(reports)
        binding.rvReports.layoutManager = LinearLayoutManager(requireContext())
        binding.rvReports.adapter = adapter
    }

    private fun setupTabLayout() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> filterReports("Semua")
                    1 -> filterReports("Diproses")
                    2 -> filterReports("Selesai")
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun filterReports(status: String) {
        val filteredList = if (status == "Semua") {
            allReports
        } else {
            allReports.filter { it.status == status }
        }
        setupRecyclerView(filteredList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}