package com.projeto.agendaprofessor.view

import android.app.DatePickerDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.projeto.agendaprofessor.R
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
    lateinit var loginActivity: LoginActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        findElementsByIds()
        getCalendar()
        customizeElements()
        referencesActivity()
    }

    fun referencesActivity(){
        loginActivity = LoginActivity(applicationContext)
        //loginActivity.changeColorBar()
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


}