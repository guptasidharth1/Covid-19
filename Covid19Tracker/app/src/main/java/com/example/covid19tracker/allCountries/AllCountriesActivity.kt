package com.example.covid19tracker.allCountries

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.covid19tracker.R
import com.example.covid19tracker.dashboard.AllCountriesDataFragment

class AllCountriesActivity: AppCompatActivity() {

    companion object{
        fun start(context: Context) {
            val intent = Intent(context, AllCountriesActivity::class.java)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_countries)

        val fragment = AllCountriesDataFragment()
        supportFragmentManager.beginTransaction().add(R.id.all_countries_frag, fragment, "AllCountriesData Fragment").commit()
    }
}