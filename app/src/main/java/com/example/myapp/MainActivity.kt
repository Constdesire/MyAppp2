package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.myapp.roomDB.Pessoa
import com.example.myapp.roomDB.PessoaDataBase
import com.example.myapp.ui.theme.MyAppTheme
import com.example.myapp.viewModel.PessoaViewModel
import com.example.myapp.viewModel.Repository

class MainActivity : ComponentActivity() {
    // Inicialização do banco de dados usando Room
    private  val db by lazy {
        Room.databaseBuilder(
            applicationContext, 
            PessoaDataBase::class.java,
            "pessoa.db" // Nome do banco de dados
        ).build() // Construção do banco de dados
    }

    // Inicialização do ViewModel
    private val viewModel by viewModels<PessoaViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory{
                override fun <T: ViewModel> create(modelClass: Class<T>): T{
                    return PessoaViewModel(Repository(db)) as T
                }
            }
        }
    )
}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App(viewModel)
                }
            }
        }
    }
}

@Composable
fun App(viewModel: PessoaViewModel){
    var nome by remember{
        mutableStateOf("")
    }

    var telefone by remember{
        mutableStateOf("")
    }

    val pessoa = Pessoa(
        nome,
        telefone
    )


//============Cor da pagina de fundo====================
    Column(
        Modifier
            .background(Color.White)
    ) {

//===========Inicio da pagina e titulo=====================
        Row(
            Modifier
                .background(Color.White)
                .fillMaxWidth(),
            Arrangement.Center
        ){
            Text(
                text = "App Cadastro Cliente",
                fontFamily =  FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )

        }

//===========Primeiro bloco de formulario com a variavel "nome"=====================
        Row(
            Modifier
                .padding(20.dp)
        ) {

        }
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ){
            TextField(
                value = nome,
                onValueChange ={ nome = it },
                label  = { Text(text = "Nome")}
            )
        }

//============Segundo bloco do formulario com a variavel "telefone"===================

        Row(
            Modifier
                .padding(20.dp)
        ) {

        }

        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ){
            TextField(
                value = telefone,
                onValueChange ={ telefone = it },
                label  = { Text(text = "Telefone") }
            )
        }

//=============Bloco do botão cadastrar inserindo as variaveis no banco pessoa===================

//Button
        Row(
            Modifier
                .padding(20.dp)
        ) {

        }

        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            Button(
                onClick = {
                    viewModel.upsertPessoa(pessoa)
                }
            ) {
                Text(text = "Cadastrar")
            }







        }
    }
}
/*@Preview
@Composable
fun AppPreview(){
    MyAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            App()
        }
    }
}

 */
