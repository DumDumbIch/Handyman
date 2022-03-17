package com.dumdumbich.proto.handyman.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.dumdumbich.proto.handyman.R
import com.dumdumbich.proto.handyman.databinding.ActivityMainBinding
import com.dumdumbich.proto.handyman.ui.screen.home.HomeFragment
import com.dumdumbich.proto.handyman.ui.screen.scheduler.SchedulerFragment
import com.dumdumbich.proto.handyman.ui.screen.setting.SettingFragment


class MainActivity : AppCompatActivity() {

    private val TAG = "@@@  ${this::class.java.simpleName} : ${this.hashCode()}"
    private lateinit var ui: ActivityMainBinding
    private lateinit var fragmentManager: FragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate() called with: savedInstanceState = $savedInstanceState")
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)

        fragmentManager = supportFragmentManager

        ui.mainBottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_item_navigation_home -> {
                    showFragment(HomeFragment())
                    true
                }
                R.id.menu_item_navigation_scheduler -> {
                    showFragment(SchedulerFragment())
                    true
                }
                R.id.menu_item_navigation_setting -> {
                    showFragment(SettingFragment())
                    true
                }
                else -> false
            }
        }

        if (savedInstanceState == null) setDefaultMainMenuItem()

    }

    private fun showFragment(fragment: Fragment) {
        ui.mainFragmentContainer.let { container ->
            fragmentManager.beginTransaction()
                .replace(container.id, fragment)
                .commit()
        }
    }

    private fun setDefaultMainMenuItem() {
        ui.mainBottomNavigationView.selectedItemId = R.id.menu_item_navigation_home
    }

}