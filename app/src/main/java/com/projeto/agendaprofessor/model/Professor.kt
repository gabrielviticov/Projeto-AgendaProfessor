package com.projeto.agendaprofessor.model

class Professor(id: Int?, registro: String, nome: String, cpf: Long?, dtaNascimento: String, email: String, senha: Long, telefone: Long ) {

    init {
        setId(id)
        setRegistro(registro)
        setNome(nome)
        setCpf(cpf)
        setDtaNascimento(dtaNascimento)
        setEmail(email)
        setSenha(senha)
        setTelefone(telefone)
    }

    private var id: Int? = null
    private var registro: String? = null
    private var nome: String? = null
    private var email: String? = null
    private var cpf: Long? = null
    private var dtaNascimento: String? = null
    private var senha: Long? = null
    private var telefone: Long? = null


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

    public fun getCpf(): Long? {
        return cpf
    }

    public fun getDtaNascimento(): String? {
        return dtaNascimento
    }

    public fun getSenha(): Long? {
        return senha
    }

    public fun getTelefone(): Long? {
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

    public fun setCpf(value: Long?) {
        this.cpf = value
    }

    public fun setDtaNascimento(value: String?) {
        this.dtaNascimento = value
    }

    public fun setSenha(value: Long?) {
        this.senha = value
    }

    public fun setTelefone(value: Long?) {
        this.telefone = value
    }



}