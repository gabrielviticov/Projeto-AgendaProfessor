package com.projeto.agendaprofessor.dataclass

interface AppAccess<T> {
    abstract fun inserir(obj: T): Boolean
    abstract fun alterar(obj: T): Boolean
    abstract fun deletar(obj: T): Boolean
    abstract fun listar(obj: T): List<T>
}