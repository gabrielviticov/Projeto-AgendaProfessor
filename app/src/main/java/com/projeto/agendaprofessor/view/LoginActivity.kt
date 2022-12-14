package com.projeto.agendaprofessor.view

import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.projeto.agendaprofessor.R
import com.projeto.agendaprofessor.controller.ProfessorController
import com.projeto.agendaprofessor.datasource.AppDataBase

open class LoginActivity : AppCompatActivity() {

    lateinit var txtLogin: TextView
    lateinit var txtEsqueceuSenha: TextView
    lateinit var editRP: EditText
    lateinit var editSenha: EditText
    lateinit var btnEntrar: Button
    lateinit var btnCadastrar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        changeColorBar()
        findElementsByIds()
        customizeElements()
        eventsOnClick()
        var professorController = ProfessorController(applicationContext)
    }

    fun changeColorBar(){
        window.statusBarColor = ContextCompat.getColor(applicationContext, R.color.statusBarColor)
        window.navigationBarColor = ContextCompat.getColor(applicationContext,
            R.color.navigatorBarColor
        )
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
        editSenha.typeface = ResourcesCompat.getFont(applicationContext, R.font.secular_one_regular)
        editSenha.hint = "Sua Senha: "
        txtEsqueceuSenha.typeface = ResourcesCompat.getFont(applicationContext,
            R.font.secular_one_regular
        )
        txtEsqueceuSenha.textSize = 14f
        txtEsqueceuSenha.setTextColor(Color.WHITE)
        txtEsqueceuSenha.text = ""+resources.getString(R.string.txtEsqueceuSenha)
        txtEsqueceuSenha.isClickable = true
        txtEsqueceuSenha.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        btnEntrar.text = ""+resources.getString(R.string.txtBtnEntrar)
        btnEntrar.setTextColor(Color.WHITE)
        btnEntrar.setBackgroundColor(ContextCompat.getColor(applicationContext,
            R.color.statusBarColor
        ))
        btnCadastrar.text = ""+resources.getString(R.string.txtBtnCadastrar)
        btnEntrar.typeface = ResourcesCompat.getFont(applicationContext, R.font.secular_one_regular)
        btnCadastrar.setTextColor(Color.WHITE)
        btnCadastrar.typeface = ResourcesCompat.getFont(applicationContext,
            R.font.secular_one_regular
        )
        btnCadastrar.setBackgroundColor(ContextCompat.getColor(applicationContext,
            R.color.statusBarColor
        ))

    }

    fun eventsOnClick(){

        btnEntrar.setOnClickListener {
            if(TextUtils.isEmpty(editRP.text.toString())){ editRP.error = "*" }
            if(TextUtils.isEmpty(editSenha.text.toString())){ editSenha.error = "*" }
            else {
                val rp = editRP.text.toString().uppercase()
                val senha = editSenha.text.toString().uppercase()
                val validarLogin = AppDataBase.validationLogin(rp, senha)
                val nomeProfessor = AppDataBase.welcomeTeacher(rp)

                if(validarLogin){
                    Toast.makeText(applicationContext, "Seja bem vindo(a): "+nomeProfessor+"!", Toast.LENGTH_LONG).show()
                } else {
                    editRP.error = "Professor n??o encontrado! Por favor, informe as credenciais corretamente!"
                    editSenha.error = "Professor n??o encontrado! Por favor, informe as credenciais corretamente!"
                }
            }
        }

        btnCadastrar.setOnClickListener {
            startActivity(Intent(this@LoginActivity, CadastroActivity::class.java))
            finish()
        }
    }
}