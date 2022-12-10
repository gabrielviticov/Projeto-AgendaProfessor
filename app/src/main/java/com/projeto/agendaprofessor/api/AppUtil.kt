package com.projeto.agendaprofessor.api

import android.database.Cursor
import android.view.Window

class AppUtil {
    companion object {
        val TAG: String = "@AGENDA_PROFESSOR"
        val DATABASE_NAME: String = "INSTITUICAO.sqlite"
        val DATABASE_VERSION: Int = 1

        val TABELA_PROFESSOR : String = "PROFESSORES"
        val ID_PROFESSOR : String = "ID"
        val REGISTRO_PROFESSOR : String = "REGISTRO_PROFESSOR"
        val NOME_PROFESSOR : String = "NOME_COMPLETO"
        val CPF_PROFESSOR : String = "CPF"
        val DTA_NASCIMENTO_PROFESSOR : String = "DTA_NASCIMENTO"
        val EMAIL_PROFESSOR : String = "EMAIL"
        val SENHA_PROFESSOR : String = "SENHA"
        val TELEFONE_PROFESSOR : String = "TELEFONE"
        var query_professor : String = ""

    }
}