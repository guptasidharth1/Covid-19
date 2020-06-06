package com.example.covid19tracker.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.example.covid19tracker.R
import com.example.covid19tracker.dashboard.OverviewFragment
import kotlinx.android.synthetic.main.fragment_onboarding_data.*



class OnBoardingDataFragment: Fragment() {

    companion object{
        const val TEXT = "text"
        const val ID = "animation_id"
        fun newInstance(bundle: Bundle): OnBoardingDataFragment {
            val onBoardingDataFragment =
                OnBoardingDataFragment()
            onBoardingDataFragment.arguments = bundle
            return onBoardingDataFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_onboarding_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        initBundle()
        initSetData()
    }

    private var resId = 0
    private var textView: String = ""
    private fun initBundle(){
        resId = arguments?.getInt(ID)!!
        textView = arguments?.getString(TEXT).toString()
    }

    private fun initSetData(){
        val lottieAnimationView = (animated_view) as LottieAnimationView
        lottieAnimationView.imageAssetsFolder = ("images/raw")
        lottieAnimationView.setAnimation(resId)
        lottieAnimationView.playAnimation()
        lottieAnimationView.loop(true)
        animated_tv.text = textView
    }
}