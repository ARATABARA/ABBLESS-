package com.abbless.app.ai.dashboard


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun AIDashboardScreen(){


    var memory by remember {
        mutableStateOf(true)
    }


    var voice by remember {
        mutableStateOf(true)
    }


    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)

    ){


        Text(

            text = "🤖 ABBLESS AI Settings",

            style = MaterialTheme.typography.headlineMedium

        )


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        Row(

            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement =
            Arrangement.SpaceBetween

        ){

            Text("AI Memory")

            Switch(

                checked = memory,

                onCheckedChange = {
                    memory = it
                }

            )

        }


        Row(

            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement =
            Arrangement.SpaceBetween

        ){

            Text("Voice Assistant")


            Switch(

                checked = voice,

                onCheckedChange = {
                    voice = it
                }

            )

        }


    }

}
