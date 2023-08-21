package com.example.taskmanager2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import com.example.taskmanager2.authentication.AuthenticationState
import com.example.taskmanager2.authentication.MainAuthenticationActivity
import com.example.taskmanager2.authentication.authenticationStatee

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        supportActionBar?.hide()
        Handler().postDelayed({
            observeAuthenticationState()
            finish()
        },3000)
    }

    private fun observeAuthenticationState() {

        authenticationStatee.observe(this, Observer { authenticationState ->

            when (authenticationState) {

                AuthenticationState.AUTHENTICATED -> sendUserToMainScreen()

                else -> sendUserToAuthentication()
            }
        })
    }

    private fun sendUserToMainScreen() {
        startActivity(Intent(this@WelcomeActivity,MainActivity::class.java))

    }

    private fun sendUserToAuthentication() {
        startActivity(Intent(this@WelcomeActivity, MainAuthenticationActivity::class.java))
    }

}