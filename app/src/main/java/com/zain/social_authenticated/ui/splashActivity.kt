package com.zain.social_authenticated.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.zain.social_authenticated.R
import com.zain.social_authenticated.ui.auth.LoginActivity

@SuppressLint("CustomSplashScreen")
class splashActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT = 2000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(
            {
                val _intent = Intent(this@splashActivity, LoginActivity::class.java)
                startActivity(_intent)
                finish()
            }, SPLASH_TIME_OUT)
    }
}