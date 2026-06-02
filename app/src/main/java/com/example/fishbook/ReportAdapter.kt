package com.example.fishbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fishbook.R

class ReportAdapter(private val reports: List<Report>) : RecyclerView.Adapter<ReportAdapter.ReportViewHolder>() {

    class ReportViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvReportTitle)
        val tvStatus: TextView = view.findViewById(R.id.tvReportStatus)
        val tvDesc: TextView = view.findViewById(R.id.tvReportDesc)
        val tvDate: TextView = view.findViewById(R.id.tvReportDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_report, parent, false)
        return ReportViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {
        val report = reports[position]
        holder.tvTitle.text = report.title
        holder.tvStatus.text = report.status
        holder.tvDesc.text = report.description
        holder.tvDate.text = report.date
    }

    override fun getItemCount(): Int = reports.size
}