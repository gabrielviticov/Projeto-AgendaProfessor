package com.projeto.agendaprofessor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun changeColorStatusBar(): SplashActivity {
        var splashActivity: SplashActivity = changeColorStatusBar()
        return splashActivity
    }
}