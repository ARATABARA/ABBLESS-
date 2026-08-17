package com.abbless.app.auth.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abbless.app.auth.data.AuthRepository


@Composable
fun LoginScreen(){


    var email by remember {

        mutableStateOf("")

    }


    var password by remember {

        mutableStateOf("")

    }


    var message by remember {

        mutableStateOf("")

    }


    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)

    ){


        Text(

            text = "Login to ABBLESS",

            style = MaterialTheme.typography.headlineMedium

        )


        Spacer(

            modifier = Modifier.height(20.dp)

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


                val user =
                    AuthRepository.login(

                        email,

                        password

                    )


                message = if(user != null){

                    "Welcome ${user.name}"

                }else{

                    "Login failed"

                }


            }

        ){

            Text("Login")

        }


        Text(message)


    }

}
