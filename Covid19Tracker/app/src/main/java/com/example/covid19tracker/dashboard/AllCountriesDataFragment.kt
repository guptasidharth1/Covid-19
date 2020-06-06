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
import com.example.covid19tracker.dashboard.data.Country
import kotlinx.android.synthetic.main.fragment_all_countries_data.*

class AllCountriesDataFragment: Fragment() {

    companion object{
        fun newInstance() = AllCountriesDataFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_all_countries_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        getSummary()
    }

    private fun init(){
        initRV()
        initViewModel()
        initViewModelObserver()
    }

    private fun getSummary(){
        viewModel.getOverViewResponse()
    }

    private lateinit var viewModel: SharedFragmentViewModel
    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this)
            .get(SharedFragmentViewModel::class.java)
    }

    private fun initRV(){
        val layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        all_countries_rv.layoutManager = layoutManager
    }

    private fun initViewModelObserver(){
        viewModel.countryResponse.observe(viewLifecycleOwner, Observer {
            onGetResponse(it)
        })
    }

    private fun onGetResponse(it: MutableList<Country>){
        initAdapter(it)
    }

    private lateinit var adapter: AllCountriesDataFragmentAdapter
    private fun initAdapter(data: MutableList<Country>){
        adapter = AllCountriesDataFragmentAdapter(requireContext())
        all_countries_rv.adapter = adapter
        adapter.submitList(data as MutableList<Any>)
    }

}