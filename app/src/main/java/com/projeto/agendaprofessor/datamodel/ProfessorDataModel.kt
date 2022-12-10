package com.projeto.agendaprofessor.datamodel

import com.projeto.agendaprofessor.api.AppUtil

open class ProfessorDataModel {
    companion object {
        @JvmStatic
        fun queryCreateTable(): String {
            AppUtil.query_professor += "CREATE TABLE IF NOT EXISTS " + AppUtil.TABELA_PROFESSOR + " ( "
            AppUtil.query_professor += AppUtil.ID_PROFESSOR + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            AppUtil.query_professor += AppUtil.REGISTRO_PROFESSOR + " TEXT NOT NULL UNIQUE, "
            AppUtil.query_professor += AppUtil.NOME_PROFESSOR + " TEXT NOT NULL, "
            AppUtil.query_professor += AppUtil.CPF_PROFESSOR + " TEXT DEFAULT '00000000000', "
            AppUtil.query_professor += AppUtil.DTA_NASCIMENTO_PROFESSOR + " TEXT NOT NULL, "
            AppUtil.query_professor += AppUtil.EMAIL_PROFESSOR + " TEXT NOT NULL, "
            AppUtil.query_professor += AppUtil.SENHA_PROFESSOR + " TEXT NOT NULL, "
            AppUtil.query_professor += AppUtil.TELEFONE_PROFESSOR + " TEXT NOT NULL "
            AppUtil.query_professor += " ) "
            return AppUtil.query_professor
        }

        fun queryDescribeTable(): String {
            AppUtil.query_professor += "PRAGMA TABLE_INFO(\"${AppUtil.TABELA_PROFESSOR}\")"
            return AppUtil.query_professor
        }
    }
}