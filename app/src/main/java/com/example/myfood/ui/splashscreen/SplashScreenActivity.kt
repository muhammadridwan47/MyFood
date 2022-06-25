package com.example.myfood.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfood.R
import com.example.myfood.ui.home.HomeActivity
import java.util.*
import kotlin.concurrent.timerTask


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        goToHomeActivity()
    }

    private fun goToHomeActivity(){
        Timer().schedule(timerTask {
            val intent = Intent(this@SplashScreenActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}