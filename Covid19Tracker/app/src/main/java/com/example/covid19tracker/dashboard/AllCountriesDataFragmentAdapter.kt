package com.example.covid19tracker.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19tracker.dashboard.data.Country
import com.example.covid19tracker.dashboard.data.Global

class AllCountriesDataFragmentAdapter(var context: Context) : ListAdapter<Any, RecyclerView.ViewHolder>(
    AllCountriesDataFragmentDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AllCountriesDataFragmentViewHolder.create(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as AllCountriesDataFragmentViewHolder).bind(item as Country)
    }
}