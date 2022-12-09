package com.projeto.agendaprofessor.controller

import android.content.ContentValues
import android.content.Context
import com.projeto.agendaprofessor.api.AppUtil
import com.projeto.agendaprofessor.dataclass.AppAccess
import com.projeto.agendaprofessor.datasource.AppDataSource
import com.projeto.agendaprofessor.model.Professor

class ProfessorController(context: Context) : AppDataSource(context), AppAccess<Professor> {

    lateinit var values: ContentValues

    override fun inserir(obj: Professor): Boolean {
        TODO("Not yet implemented")
        
        values.put(AppUtil.REGISTRO_PROFESSOR, obj.getRegistro())
        values.put(AppUtil.NOME_PROFESSOR, obj.getNome())
        values.put(AppUtil.EMAIL_PROFESSOR, obj.getEmail())
        values.put(AppUtil.CPF_PROFESSOR, obj.getCpf())
        values.put(AppUtil.DTA_NASCIMENTO_PROFESSOR, obj.getDtaNascimento())
        values.put(AppUtil.SENHA_PROFESSOR, obj.getSenha())
        values.put(AppUtil.TELEFONE_PROFESSOR, obj.getTelefone())
        
        return AppDataSource.incluir(null, AppUtil.TABELA_PROFESSOR, values)
    }

    override fun alterar(obj: Professor): Boolean {
        TODO("Not yet implemented")
    }

    override fun deletar(obj: Professor): Boolean {
        TODO("Not yet implemented")
    }

    override fun listar(obj: Professor): List<Professor> {
        TODO("Not yet implemented")
    }
}