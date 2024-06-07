package com.example.myapp.roomDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity 
data class Pessoa( // Define classe chamada Pessoa e abaixo esta os tipos que serão armazenados 
    val nome: String, 
    val telefone: String, 
    @PrimaryKey(autoGenerate = true) // Marca a id como a chave primária da tabela, com auto incremento
    val id: Int = 0 // Define a propriedade id como um Int
)
