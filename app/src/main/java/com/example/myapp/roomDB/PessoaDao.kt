package com.example.myapp.roomDB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao // Esta interface é marcada como um Data Access Object (DAO), que fornece métodos para acessar e manipular dados na base de dados Room
interface PessoaDao {
// atualiza ou insere uma entidade no banco de dados
    @Upsert 
    suspend fun upsertPessoa(pessoa: Pessoa) 
//  exclui uma entidade da base de dados
    @Delete 
    suspend fun deletePessoa(pessoa: Pessoa) 
// seleciona todas as entidades Pessoa da tabela
    @Query("SELECT * FROM pessoa") 
    fun getAllPessoa():

}
