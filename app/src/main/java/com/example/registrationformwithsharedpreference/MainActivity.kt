package com.example.registrationformwithsharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var age: EditText
    private lateinit var isAdult: CheckBox
    private lateinit var buttonClick: Button
    override fun onCreate(savedInstanceState: Bundle?) {
    //    var ggb  = window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// this is for the animation
        val ttb = AnimationUtils.loadAnimation(this, R.anim.first_animation)
        val ssb = AnimationUtils.loadAnimation(this, R.anim.second_animation)




 // this is to initialise the variables
         name =findViewById(R.id.etName)
         age = findViewById(R.id.etAge)
         isAdult= findViewById(R.id.etAdult)
         buttonClick = findViewById(R.id.btnClick)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnLoad = findViewById<Button>(R.id.btnLoad)

  // to set the annimation
        name.startAnimation(ttb)
        age.startAnimation(ttb)
        btnLoad.startAnimation(ssb)
        btnSave.startAnimation(ssb)
        buttonClick.startAnimation(ttb)

        //SecondActivity


 // to create an instance of sharedPreference
        val sharedPref = getSharedPreferences("mySharedPref", MODE_PRIVATE)
        val editor = sharedPref.edit()


   // to save the to the preference
        btnSave.setOnClickListener {
             editor.apply {
                 putString("name", name.text.toString())
                 putInt("age", age.text.toString().toInt())
                 putBoolean("isAdult", isAdult.isChecked)
                 apply()
             }
        }


  // to load the data save to the sharedPreference
        btnLoad.setOnClickListener {

                val names = sharedPref.getString("name", null)
                val ages = sharedPref. getInt("age", 0)
                val isAdults = sharedPref.getBoolean("isAdult", false)

            name.setText(names)
            age.setText(ages.toString())
            isAdult.isChecked = isAdults


        }



  // button to go to the next activity
        buttonClick.setOnClickListener {
            Intent(this, SecondActivity::class.java).also {
              //  buttonClick.startAnimation(ttb)
                startActivity(it)
                overridePendingTransition(R.anim.slide_in, R.anim.no_animation)


            }
        }

    }

//    fun sharedTransitionElement(){
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setTitle("Shared element transition")
//    }


}