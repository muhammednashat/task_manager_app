package com.example.taskmanager2.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taskmanager2.R

class MainAuthenticationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_authentication)
        supportActionBar?.hide()

    }
}