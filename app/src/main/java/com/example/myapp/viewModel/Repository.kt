package com.example.myapp.viewModel

import com.example.myapp.roomDB.Pessoa
import com.example.myapp.roomDB.PessoaDataBase

class Repository(private val db: PessoaDataBase) {
    // inserir ou atualizar uma pessoa no banco de dados
    suspend fun upsertPessoa(pessoa: Pessoa){
        db.pessoaDao().upsertPessoa(pessoa)
    }

    // excluir uma pessoa do banco de dados
    suspend fun deletePessoa(pessoa: Pessoa){
        db.pessoaDao().deletePessoa(pessoa)
    }

    //  obter todas as pessoas do banco de dados
    fun getAllPessoa() = db.pessoaDao().getAllPessoa()
}
