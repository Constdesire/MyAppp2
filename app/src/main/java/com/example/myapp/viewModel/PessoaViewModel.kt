package com.example.myapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.asLiveData
import com.example.myapp.roomDB.Pessoa
import kotlinx.coroutines.launch

class PessoaViewModel(private val repository: Repository): ViewModel() {
    // obter todas as pessoas do banco de dados
    fun getPessoa() = repository.getAllPessoa().asLiveData(viewModelScope.coroutineContext)

    // inserir ou atualizar uma pessoa no banco 
    fun upsertPessoa(pessoa: Pessoa){
        viewModelScope.launch {
            repository.upsertPessoa(pessoa)
        }
    }

    // excluir uma pessoa do banco
    fun deletePessoa(pessoa: Pessoa){
        viewModelScope.launch {
            repository.deletePessoa(pessoa)
        }
    }
}
