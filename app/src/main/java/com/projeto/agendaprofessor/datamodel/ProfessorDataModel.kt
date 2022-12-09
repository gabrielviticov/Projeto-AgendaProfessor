package com.projeto.agendaprofessor.datamodel

import com.projeto.agendaprofessor.api.AppUtil

open class ProfessorDataModel {
    companion object {
        @JvmStatic
        fun queryCreateTable(): String {
            AppUtil.query_professor += "CREATE TABLE IF NOT EXISTS " + AppUtil.TABELA_PROFESSOR + " ( " +
            AppUtil.ID_PROFESSOR + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            AppUtil.REGISTRO_PROFESSOR + " TEXT NOT NULL UNIQUE, " +
            AppUtil.NOME_PROFESSOR + " TEXT NOT NULL, " +
            AppUtil.CPF_PROFESSOR + " INTEGER DEFAULT 00000000000, " +
            AppUtil.DTA_NASCIMENTO_PROFESSOR + " TEXT NOT NULL, " +
            AppUtil.EMAIL_PROFESSOR + " TEXT NOT NULL UNIQUE, " +
            AppUtil.SENHA_PROFESSOR + " TEXT NOT NULL, " +
            AppUtil.TELEFONE_PROFESSOR + " TEXT NOT NULL " +
            " ) "
            return AppUtil.query_professor
        }

        fun queryDescribeTable(): String {
            AppUtil.query_professor += "PRAGMA TABLE_INFO(\"${AppUtil.TABELA_PROFESSOR}\")"
            return AppUtil.query_professor
        }
    }
}