package com.abbless.app.social.profile


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ProfileScreen(){

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)

    ){

        Text(

            text = "👤 ABBLESS Profile",

            style = MaterialTheme.typography.headlineMedium

        )


        Spacer(

            modifier = Modifier.height(20.dp)

        )


        Text("Name: New User")

        Text("Level: Beginner")

        Text("Subscription: Free")


        Spacer(

            modifier = Modifier.height(20.dp)

        )


        Button(
            onClick = {}
        ){

            Text("Edit Profile")

        }

    }

}
