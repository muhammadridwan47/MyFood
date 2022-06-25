package com.example.myfood.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myfood.R

class ProfileActivity : AppCompatActivity() {
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        toolbar = findViewById(R.id.toolbar)
         toolbarBack()
    }

    private fun toolbarBack() {
        toolbar.visibility = View.VISIBLE
        toolbar.setNavigationOnClickListener {onBackPressed()}
    }
}