package com.projeto.agendaprofessor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat

class LoginActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeColorBar()
    }

    fun changeColorBar(){
        window.statusBarColor = ContextCompat.getColor(applicationContext, R.color.statusBarColor)
        window.navigationBarColor = ContextCompat.getColor(applicationContext, R.color.navigatorBarColor)
    }
}