package com.example.covid19tracker.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.covid19tracker.R
import com.example.covid19tracker.dashboard.OverviewFragment
import com.example.covid19tracker.onBoarding.OnBoardingFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        OnBoardingFragment.start(supportFragmentManager)

        val fragment = OverviewFragment()
        supportFragmentManager.beginTransaction().add(R.id.frag_container, fragment, "Overview Fragment").commit()
    }


}

