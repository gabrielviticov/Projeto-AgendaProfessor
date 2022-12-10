package com.projeto.agendaprofessor.model

import android.text.Editable

class Professor() {



    private var id: Int? = null
    private var registro: String? = null
    private var nome: String? = null
    private var email: String? = null
    private var cpf: String? = null
    private var dtaNascimento: String? = null
    private var senha: String? = null
    private var telefone: String? = null


    public fun getId(): Int? {
        return id
    }

    public fun getRegistro(): String? {
        return registro
    }

    public fun getNome(): String? {
        return nome
    }

    public fun getEmail(): String? {
        return email
    }

    public fun getCpf(): String? {
        return cpf
    }

    public fun getDtaNascimento(): String? {
        return dtaNascimento
    }

    public fun getSenha(): String? {
        return senha
    }

    public fun getTelefone(): String? {
        return telefone
    }

    public fun setId(value: Int?) {
        this.id = value
    }

    public fun setRegistro(value: String?) {
        this.registro = value
    }

    public fun setNome(value: String?) {
        this.nome = value
    }

    public fun setEmail(value: String?) {
        this.email = value
    }

    public fun setCpf(value: String?) {
        this.cpf = value
    }

    public fun setDtaNascimento(value: String?) {
        this.dtaNascimento = value
    }

    public fun setSenha(value: String?) {
        this.senha = value
    }

    public fun setTelefone(value: String?) {
        this.telefone = value
    }



}