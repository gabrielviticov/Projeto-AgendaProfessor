package com.projeto.agendaprofessor.view

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.projeto.agendaprofessor.R
import com.projeto.agendaprofessor.api.AppUtil
import com.projeto.agendaprofessor.controller.ProfessorController
import com.projeto.agendaprofessor.model.Professor
import java.util.Calendar

class CadastroActivity : AppCompatActivity() {

    lateinit var txtCadastro: TextView
    lateinit var editRegistro: EditText
    lateinit var editNome: EditText
    lateinit var editCpf: EditText
    lateinit var editDtaNascimento: EditText
    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var editTelefone: EditText
    lateinit var btnSalvar: Button
    lateinit var btnCancelar: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)


        changeColor()
        findElementsByIds()

        getCalendar()
        customizeElements()
        actionByElements()

    }




    fun changeColor(){
        window.statusBarColor = ContextCompat.getColor(applicationContext, R.color.statusBarColor)
        window.navigationBarColor = ContextCompat.getColor(applicationContext, R.color.navigatorBarColor)
    }

    fun findElementsByIds() {
        txtCadastro = findViewById(R.id.txtCadastro)
        editRegistro = findViewById(R.id.editRegistro)
        editNome = findViewById(R.id.editNome)
        editCpf = findViewById(R.id.editCpf)
        editDtaNascimento = findViewById(R.id.editDtaNascimento)
        editEmail = findViewById(R.id.editEmail)
        editSenha = findViewById(R.id.editSenha)
        editTelefone = findViewById(R.id.editTelefone)
        btnSalvar = findViewById(R.id.btnSalvar)
        btnCancelar = findViewById(R.id.btnCancelar)
    }

    fun getCalendar() {
        editDtaNascimento.setOnClickListener {
            val c: Calendar = Calendar.getInstance()
            val day = c.get(Calendar.DAY_OF_MONTH)
            val month = c.get(Calendar.MONTH)
            val year = c.get(Calendar.YEAR)

            val datePickerDialog = DatePickerDialog(
                // on below line we are passing context.
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    // on below line we are setting
                    // date to our edit text.
                    val dat = (dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year)
                    editDtaNascimento.setText(dat)
                },
                // on below line we are passing year, month
                // and day for the selected date in our date picker.
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
    }

    fun customizeElements(){
        txtCadastro.typeface = ResourcesCompat.getFont(applicationContext, R.font.secular_one_regular)
        editRegistro.typeface = ResourcesCompat.getFont(applicationContext, R.font.secular_one_regular)
        editNome.typeface = ResourcesCompat.getFont(applicationContext, R.font.secular_one_regular)
        editCpf.typeface = ResourcesCompat.getFont(applicationContext, R.font.secular_one_regular)
        editDtaNascimento.typeface = ResourcesCompat.getFont(applicationContext, R.font.secular_one_regular)
        editEmail.typeface = ResourcesCompat.getFont(applicationContext, R.font.secular_one_regular)
        editSenha.typeface = ResourcesCompat.getFont(applicationContext, R.font.secular_one_regular)
        editTelefone.typeface = ResourcesCompat.getFont(applicationContext, R.font.secular_one_regular)

        txtCadastro.textSize = 30f
        txtCadastro.setTextColor(Color.WHITE)
        txtCadastro.text = ""+resources.getString(R.string.txtCadastro)

        editRegistro.hint = ""+resources.getString(R.string.hintRegistroProfessor)
        editNome.hint = ""+resources.getString(R.string.hintNome)
        editCpf.hint = ""+resources.getString(R.string.hintCpf)
        editDtaNascimento.hint = ""+resources.getString(R.string.hintDtaNascimento)
        editEmail.hint = ""+resources.getString(R.string.hintEmail)
        editSenha.hint = ""+resources.getString(R.string.hintSenha)
        editTelefone.hint = ""+resources.getString(R.string.hintTelefone)

        btnSalvar.text = ""+resources.getString(R.string.txtBtnSalvar)
        btnCancelar.text = ""+resources.getString(R.string.txtBtnCancelar)

        btnSalvar.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.statusBarColor))
        btnCancelar.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.statusBarColor))

        btnSalvar.typeface = ResourcesCompat.getFont(applicationContext, R.font.secular_one_regular)
        btnCancelar.typeface = ResourcesCompat.getFont(applicationContext, R.font.secular_one_regular)

        btnSalvar.setTextColor(Color.WHITE)
        btnCancelar.setTextColor(Color.WHITE)
    }

    fun clearForm(){
        editRegistro.text.clear()
        editNome.text.clear()
        editCpf.text.clear()
        editDtaNascimento.text.clear()
        editEmail.text.clear()
        editSenha.text.clear()
        editTelefone.text.clear()
        editRegistro.requestFocus()
    }

    fun actionByElements(){



        btnCancelar.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.apply {
                alertDialog.setTitle("Deseja Voltar?")
                alertDialog.setMessage("Deseja voltar para a tela de Login? Caso aceite, todos os dados do formulário serão apagados")
                alertDialog.setPositiveButton(R.string.alertDialogVoltarLogin, DialogInterface.OnClickListener { dialogInterface, i ->  
                    
                    clearForm()
                    
                    startActivity(Intent(this@CadastroActivity, LoginActivity::class.java))
                    finish()
                })
                
                alertDialog.setNeutralButton(R.string.alertDialogCancelar, DialogInterface.OnClickListener { dialogInterface, i ->  })
                

            }.create().show()
        }

        btnSalvar.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.apply {
                alertDialog.setTitle("Salvar os dados")
                alertDialog.setMessage("Os dados serão salvos a partir da opção desejada. Escolha uma opção abaixo para salvar os dados")
                alertDialog.setPositiveButton(R.string.alertDialogSalvarProfessor, DialogInterface.OnClickListener { dialogInterface, i ->
                    if(btnSalvar.isClickable){
                        if(TextUtils.isEmpty(editRegistro.text.toString())){ editRegistro.error = "*" }
                        if(TextUtils.isEmpty(editNome.text.toString())){ editNome.error = "*" }
                        if(TextUtils.isEmpty(editDtaNascimento.text.toString())){ editDtaNascimento.error = "*" }
                        if(TextUtils.isEmpty(editEmail.text.toString())){ editEmail.error = "*" }
                        if(TextUtils.isEmpty(editSenha.text.toString())){ editSenha.error = "*" }
                        if(TextUtils.isEmpty(editTelefone.text.toString())){ editTelefone.error = "*" }

                        else {
                            val professor = Professor()
                            val professorController = ProfessorController(applicationContext)

                            professor.setRegistro(editRegistro.text.toString().uppercase())
                            professor.setNome(editNome.text.toString().uppercase())
                            professor.setDtaNascimento(editDtaNascimento.text.toString())
                            professor.setEmail(editEmail.text.toString().lowercase())
                            professor.setSenha(editSenha.text.toString())
                            professor.setTelefone(editTelefone.text.toString())

                            if(!TextUtils.isEmpty(editCpf.text.toString())){
                                professor.setCpf(editCpf.text.toString())
                            }

                            if(professorController.inserir(professor)){
                                clearForm()
                                Toast.makeText(applicationContext, "O professor: "+professor.getNome()+" foi inserido com sucesso!", Toast.LENGTH_LONG).show()
                            } else {
                                Toast.makeText(applicationContext, "Não foi inserido nenhum professor!", Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                })
                alertDialog.setNeutralButton(R.string.alertDialogSalvarAluno, DialogInterface.OnClickListener { dialogInterface, i ->
                    if(btnSalvar.isClickable){

                    }
                })

            }.create().show()
        }
    }


}