package com.example.myapp.roomDB

import androidx.room.Database
import androidx.room.RoomDatabase

@Database( 
    entities = [Pessoa::class], // Lista de entidades 
    version = 1 // Versão
)
// Classe que estende RoomDatabase e abaixo fornece acesso ao DAO 
abstract class PessoaDataBase: RoomDatabase() { 

    abstract fun pessoaDao(): PessoaDao 
}
