package com.example.covid19tracker.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19tracker.R
import com.example.covid19tracker.allCountries.AllCountriesActivity
import com.example.covid19tracker.dashboard.data.Global
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_all_countries_data.*
import kotlinx.android.synthetic.main.global_overview.*

class OverviewFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.global_overview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        getGlobalSummary()
        initClickListener()
    }

    private fun init(){
        initViewModel()
        initViewModelObserver()
    }

    private fun getGlobalSummary(){
        viewModel.getOverViewResponse()
    }

    private lateinit var viewModel: SharedFragmentViewModel
    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this)
            .get(SharedFragmentViewModel::class.java)
    }

    private fun initViewModelObserver(){
        viewModel.overViewGlobalResponse.observe(viewLifecycleOwner, Observer {
            initSetData(it)
        })
    }

    private fun initSetData(global: Global){
        four.text = "Total Confirmed Cases: ${global.totalConfirmed}"
        five.text = "Total Recovered Cases: ${global.totalRecovered}"
        six.text = "Total Deaths: ${global.totalDeaths}"
    }

    private fun initClickListener(){
        explore_button.setOnClickListener{
            AllCountriesActivity.start(requireContext())
        }
//        precautions.setOnClickListener {
//            //Todo start precaution activity
//        }
    }

}