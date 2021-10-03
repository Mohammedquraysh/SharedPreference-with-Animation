package com.example.registrationformwithsharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    private lateinit var backButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        backButton = findViewById(R.id.btnBack)

//        finish()
//        overridePendingTransition(R.anim.no_animation, R.anim.slide_in)
        backButton.setOnClickListener {
          //  onBackPressed()

        }
    }
}