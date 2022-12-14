package com.projeto.agendaprofessor.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.projeto.agendaprofessor.R

class SplashActivity : AppCompatActivity() {

    lateinit var txtNomeApp: TextView
    lateinit var progress_bar: ProgressBar
    var i: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        changeColors()
        customizeElements()
        progressingBar()

    }

    fun changeColors() {
        window.statusBarColor = ContextCompat.getColor(this, R.color.statusBarColor)
        window.navigationBarColor = ContextCompat.getColor(this, R.color.navigatorBarColor)
    }


    fun customizeElements(){
        txtNomeApp = findViewById(R.id.txtNomeApp)
        progress_bar = findViewById(R.id.progress_bar)
        progress_bar.max = 10
        txtNomeApp.setTextColor(Color.WHITE)
        txtNomeApp.text = ""+resources.getString(R.string.app_name)
        txtNomeApp.typeface = ResourcesCompat.getFont(applicationContext,
            R.font.secular_one_regular
        )
        txtNomeApp.textSize = 34f
    }

    fun progressingBar(){
        Thread(Runnable{
            while(i < 10){
                i += 1

                Handler(Looper.getMainLooper()).post(Runnable{
                    progress_bar.progress = i
                })

                try {
                    Thread.sleep(100)
                } catch(e: InterruptedException){
                    e.printStackTrace()
                }
            }

            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()
        }).start()
    }
}