package com.testbook.tbapp.android.ui.activities.remindMeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.testbook.tbapp.R
import com.testbook.tbapp.android.xScreen.XAdapter
import com.testbook.tbapp.android.xScreen.XViewModel
import com.testbook.tbapp.android.xScreen.XViewModelFactory

class remindMeBottomSheetDialogFragment: BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.remind_me_dialog_bottom_sheet_fragment_layout,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initViewModel()
    }

    lateinit var viewModel : remindMeBottomSheetDialogFragmentViewModel
    private fun initViewModel(){

    }

}

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        init()
//        getX()
//    }
//
//    private fun init() {
//        initViewModel()
//        initViewModelObservers()
//        initRV()
//        initNetworkContainer()
//    }
//
//    lateinit var viewModel: XViewModel
//    private fun initViewModel() {
//        viewModel = ViewModelProviders.of(this, XViewModelFactory(requireContext()))
//                .get(XViewModel::class.java)
//    }
//
//    private fun getX() {
//        viewModel.getX()
//    }
//
//    private fun initViewModelObservers() {
//        viewModel.getX.observe(viewLifecycleOwner, Observer {
//            if (it != null) {
//                onGetXResponse(it)
//            }
//        })
//        viewModel.xClicked.observe(viewLifecycleOwner, Observer {
//            onXClicked(it)
//        })
//    }
//
//    private fun onXClicked(it: Any?) {
//
//    }
//
//    private fun onGetXResponse(requestResult: RequestResult<Any>) {
//        when (requestResult) {
//            is RequestResult.Loading -> onGetXLoading()
//            is RequestResult.Success -> onGetXSuccess(requestResult)
//            is RequestResult.Error -> onGetXError(requestResult)
//        }
//    }
//
//    private fun onGetXLoading() {
//        showLoading()
//    }
//
//    private fun onGetXSuccess(requestResult: RequestResult.Success<*>) {
//        val data = requestResult.data
//        initAdapter(data)
//        hideLoading()
//    }
//
//    private lateinit var adapter: XAdapter
//    private fun initAdapter(data: Any?) {
//        adapter = XAdapter(requireContext(), viewModel)
//        adapter.submitList(data as ArrayList<*>)
//        x_rv.adapter = adapter
//    }
//
//    private fun onGetXError(requestResult: RequestResult.Error<*>) {
//        val throwable = requestResult.throwable
//        if (NetworkUtils.isConnected(requireContext())) {
//            onServerError(throwable)
//        } else {
//            onNetworkError(throwable)
//        }
//    }
//
//    private fun initRV() {
//        x_rv.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
//    }
//
//    private fun initNetworkContainer() {
//        empty_state_no_network_container.findViewById<TextView>(R.id.retry)
//                .setOnClickListener {
//                    retry()
//                }
//        empty_state_error_container.findViewById<TextView>(R.id.retry)
//                .setOnClickListener {
//                    retry()
//                }
//    }
//
//    private fun retry() {
//        getX()
//    }
//
//    private fun showLoading() {
//        progress_bar_container.visibility = View.VISIBLE
//        empty_state_no_network_container.visibility = View.GONE
//        empty_state_error_container.visibility = View.GONE
//
//        x_rv.visibility = View.GONE
//    }
//
//    private fun hideLoading() {
//        progress_bar_container.visibility = View.GONE
//        empty_state_no_network_container.visibility = View.GONE
//        empty_state_error_container.visibility = View.GONE
//
//        x_rv.visibility = View.VISIBLE
//    }
//
//    private fun onServerError(throwable: Throwable) {
//        throwable.printStackTrace()
//        empty_state_error_container.visibility = View.VISIBLE
//        empty_state_no_network_container.visibility = View.GONE
//        progress_bar_container.visibility = View.GONE
//
//        AnimUtils.setFadeInAnimation(empty_state_error_container)
//        val errorMessage = NetworkUtils.getServerErrorMessage(requireContext(), throwable)
//        Common.showError(requireContext(), errorMessage)
//    }
//
//    private fun onNetworkError(throwable: Throwable) {
//        throwable.printStackTrace()
//        empty_state_no_network_container.visibility = View.VISIBLE
//        empty_state_error_container.visibility = View.GONE
//        progress_bar_container.visibility = View.GONE
//
//        AnimUtils.setFadeInAnimation(empty_state_no_network_container)
//        Common.showError(requireContext(), getString(R.string.network_not_found))
//    }
//}