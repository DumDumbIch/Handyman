package com.dumdumbich.proto.handyman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dumdumbich.proto.handyman.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var ui: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
    }

}