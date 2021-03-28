package com.example.testmicrofeature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.core.showFragment
import com.example.home.HomeFragment
import com.example.testmicrofeature.mocks.MockHomeEvent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFragment(MockHomeEvent.HOME_FRAGMENT)
    }

    fun showFragment(fragment: String, args: Bundle? = null) {
        showFragment(R.id.containerId, fragment, args)
    }
}