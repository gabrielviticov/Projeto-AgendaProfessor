package com.projeto.agendaprofessor

import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class LoginActivity : AppCompatActivity() {

    lateinit var txtLogin: TextView
    lateinit var txtEsqueceuSenha: TextView
    lateinit var editRP: EditText
    lateinit var editSenha: EditText
    lateinit var btnEntrar: Button
    lateinit var btnCadastrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeColorBar()
        findElementsByIds()
        customizeElements()
    }

    fun changeColorBar(){
        window.statusBarColor = ContextCompat.getColor(applicationContext, R.color.statusBarColor)
        window.navigationBarColor = ContextCompat.getColor(applicationContext, R.color.navigatorBarColor)
    }

    fun findElementsByIds(){
        txtLogin = findViewById(R.id.txtLogin)
        txtEsqueceuSenha = findViewById(R.id.txtEsqueceuSenha)
        editRP = findViewById(R.id.editRP)
        editSenha = findViewById(R.id.editSenha)
        btnEntrar = findViewById(R.id.btnEntrar)
        btnCadastrar = findViewById(R.id.btnCadastrar)
    }

    fun customizeElements(){
        txtLogin.text = ""+resources.getString(R.string.txtLogin)
        txtLogin.typeface = ResourcesCompat.getFont(applicationContext, R.font.secular_one_regular)
        txtLogin.textSize = 30f
        txtLogin.setTextColor(Color.WHITE)
        editRP.typeface = ResourcesCompat.getFont(applicationContext, R.font.secular_one_regular)
        editRP.hint = "Seu Registro Professor: "
        editRP.setHintTextColor(Color.WHITE)
        editSenha.typeface = ResourcesCompat.getFont(applicationContext, R.font.secular_one_regular)
        editSenha.hint = "Sua Senha: "
        editSenha.setHintTextColor(Color.WHITE)
        txtEsqueceuSenha.typeface = ResourcesCompat.getFont(applicationContext, R.font.secular_one_regular)
        txtEsqueceuSenha.textSize = 14f
        txtEsqueceuSenha.setTextColor(Color.WHITE)
        txtEsqueceuSenha.text = ""+resources.getString(R.string.txtEsqueceuSenha)
        txtEsqueceuSenha.isClickable = true
        txtEsqueceuSenha.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        btnEntrar.text = ""+resources.getString(R.string.txtBtnEntrar)
        btnEntrar.setTextColor(Color.WHITE)
        btnEntrar.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.statusBarColor))
        btnCadastrar.text = ""+resources.getString(R.string.txtBtnCadastrar)
        btnEntrar.typeface = ResourcesCompat.getFont(applicationContext, R.font.secular_one_regular)
        btnCadastrar.setTextColor(Color.WHITE)
        btnCadastrar.typeface = ResourcesCompat.getFont(applicationContext, R.font.secular_one_regular)
        btnCadastrar.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.statusBarColor))

    }
}