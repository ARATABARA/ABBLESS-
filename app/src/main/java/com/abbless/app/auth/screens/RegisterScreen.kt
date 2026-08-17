package com.abbless.app.auth.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abbless.app.auth.data.AuthRepository
import com.abbless.app.auth.model.UserAccount
import java.util.UUID


@Composable
fun RegisterScreen(){


    var name by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }


    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)

    ){


        Text(

            text = "Create ABBLESS Account",

            style = MaterialTheme.typography.headlineMedium

        )


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        OutlinedTextField(

            value = name,

            onValueChange = {
                name = it
            },

            label = {
                Text("Name")
            }

        )


        OutlinedTextField(

            value = email,

            onValueChange = {
                email = it
            },

            label = {
                Text("Email")
            }

        )


        OutlinedTextField(

            value = password,

            onValueChange = {
                password = it
            },

            label = {
                Text("Password")
            }

        )


        Button(

            onClick = {


                AuthRepository.register(

                    UserAccount(

                        id = UUID.randomUUID().toString(),

                        name = name,

                        email = email,

                        password = password

                    )

                )


            }

        ){

            Text("Register")

        }


    }

}
