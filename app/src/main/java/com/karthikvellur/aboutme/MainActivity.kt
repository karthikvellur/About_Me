package com.karthikvellur.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 'R' means resource which is a 'layout' and the name of the file is 'activity_main'
        // Hence R.layout.activity_main
    }
}