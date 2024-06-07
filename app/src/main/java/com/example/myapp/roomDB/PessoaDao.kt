package com.example.myapp.roomDB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao // acessar e manipular dados na Room
interface PessoaDao {
// atualiza ou insere uma entidade no banco de dados
    @Upsert 
    suspend fun upsertPessoa(pessoa: Pessoa) 
//  exclui uma entidade 
    @Delete 
    suspend fun deletePessoa(pessoa: Pessoa) 
// seleciona todas as entidades Pessoa da tabela
    @Query("SELECT * FROM pessoa") 
    fun getAllPessoa():

}
