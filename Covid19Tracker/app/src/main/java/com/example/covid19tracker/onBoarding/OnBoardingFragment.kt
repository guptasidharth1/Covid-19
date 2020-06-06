package com.example.covid19tracker.onBoarding

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.example.covid19tracker.R
import kotlinx.android.synthetic.main.fragment_onboarding.*
import kotlin.math.abs

class OnBoardingFragment: DialogFragment() {

    companion object {
        fun start(fm: FragmentManager) {
            val fragment =
                OnBoardingFragment()
            fragment.show(fm, "OnBoardingActivity")
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.let {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            it.window?.setLayout(width, height)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListener()
        init()
        initAdapter()
    }

    private fun init(){
        initLoadFragmentData()
        setViewPager()
        initSetFragments()
    }

    private var fragmentData = mutableListOf<Pair<Int, String>>()
    private fun initLoadFragmentData(){
        fragmentData.add(Pair(R.raw.wear_mask, "Cover mouth and nose with mask and make sure there are no gaps between your face and the mask."))
        fragmentData.add(Pair(R.raw.stay_safe_stay_home, "Stay Home Stay Safe, Let's Stop COVID-19, stay home in COVID-19 coronavirus outbreak, stay in the house to prevent virus infection."))
        fragmentData.add(Pair(R.raw.wash_your_hands, "Wash your hands with soap and water, and dry them thoroughly."))
    }

    private fun setViewPager(){
        onBoarding_tb.setupWithViewPager(onBoarding_vp)
        onBoarding_vp.offscreenPageLimit = fragmentData.size
    }

    private fun initClickListener(){
        start_bt.setOnClickListener{
            onDestroyView()
        }
    }

    private var fragments = mutableListOf<Fragment>()
    private var titles = mutableListOf<String>()
    private fun initSetFragments(){
        fragmentData.forEach {
            val bundle = Bundle()
            bundle.putInt(OnBoardingDataFragment.ID, it.first)
            bundle.putString(OnBoardingDataFragment.TEXT, it.second)
            fragments.add(OnBoardingDataFragment.newInstance(bundle))
            titles.add("sddasd")
        }
    }

    private fun initAdapter(){
        onBoarding_vp.adapter =
            OnBoardingAdapter(
                childFragmentManager,
                fragments,
                titles
            )
    }
}