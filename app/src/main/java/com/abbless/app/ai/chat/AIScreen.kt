package com.abbless.app.ai.chat

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun AIScreen(){

    var message by remember {
        mutableStateOf("")
    }

    var response by remember {
        mutableStateOf("")
    }


    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)

    ){

        Text(
            text = "🤖 ABBLESS AI",
            style = MaterialTheme.typography.headlineMedium
        )


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        Text(
            text = response
        )


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        OutlinedTextField(

            value = message,

            onValueChange = {
                message = it
            },

            label = {
                Text("Andika ikibazo...")
            }

        )


        Button(

            onClick = {

                response =
                    ChatRepository.sendMessage(
                        message
                    )

            }

        ){

            Text("Send")

        }

    }

}
