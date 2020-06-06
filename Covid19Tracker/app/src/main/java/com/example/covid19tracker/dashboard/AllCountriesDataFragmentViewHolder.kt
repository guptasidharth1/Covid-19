package com.example.covid19tracker.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19tracker.R
import com.example.covid19tracker.dashboard.data.Country
import com.example.covid19tracker.dashboard.data.Global
import com.example.covid19tracker.databinding.CountriesOverviewBinding
import com.example.covid19tracker.databinding.GlobalOverviewBinding
import kotlinx.android.synthetic.main.countries_overview.view.*
import kotlinx.android.synthetic.main.include_country_layout.view.*
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class AllCountriesDataFragmentViewHolder (val binding: CountriesOverviewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
            inflater: LayoutInflater,
            viewGroup: ViewGroup
        ): AllCountriesDataFragmentViewHolder {
            val binding = DataBindingUtil.inflate<CountriesOverviewBinding>(
                inflater, R.layout.countries_overview, viewGroup, false
            )
            return AllCountriesDataFragmentViewHolder(
                binding
            )
        }
    }

    var isFirst = false
    fun bind(country: Country) {

        country.run {
            binding.textView.text = "Country Code: ${country.countryCode}"
            binding.textView2.text = "Country Name: ${country.country}"
            if(!isFirst) {
                bindMainContent(country)
                isFirst = true
            }
        }

        binding.navBt.setOnClickListener {
            if (itemView.include_layout.visibility == View.GONE) {
                itemView.nav_bt.rotation = 270f
                itemView.include_layout.visibility = View.VISIBLE
            } else {
                itemView.nav_bt.rotation = 90f
                itemView.include_layout.visibility = View.GONE
            }
        }
    }

    private fun bindMainContent(country: Country){
         LayoutInflater.from(itemView.context)
            .inflate(R.layout.include_country_layout, itemView.include_layout,
                false).run {
                textView5.text = "New Confirmed Cases: ${country.newConfirmed}"
                textView6.text = "Deaths: ${country.totalDeaths}"
                textView7.text = "Recovered: ${country.totalRecovered}"
                textView8.text = "Total Confirmed: ${country.totalConfirmed}"
                itemView.include_layout.addView(this)
            }
    }
}

