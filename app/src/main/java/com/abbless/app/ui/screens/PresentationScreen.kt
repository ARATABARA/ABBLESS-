package com.abbless.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PresentationScreen(
    onContinue: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Welcome to ABBLESS",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Learn Without Limits",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "ABBLESS ni application y'ubumenyi ifasha abantu kwiga ibintu bitandukanye, gukoresha ABBLESS AI, gukora Quiz, kwiga amasomo no gukorana n'abandi."
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = onContinue,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continue")
        }
    }
}

