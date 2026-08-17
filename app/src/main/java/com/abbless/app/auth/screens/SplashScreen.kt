package com.abbless.app.auth.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abbless.app.auth.manager.SessionStorage
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onLogin: () -> Unit,
    onHome: (String) -> Unit
) {

    val context =
        androidx.compose.ui.platform.LocalContext.current

    var checking by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(Unit) {

        delay(1200)

        val storage =
            SessionStorage(context)

        val userId =
            storage.getUserId()

        checking = false

        if (userId != null) {
            onHome(userId)
        } else {
            onLogin()
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            Text(
                text = "ABBLESS",
                style =
                    MaterialTheme.typography.headlineLarge
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            if (checking) {
                CircularProgressIndicator()
            }
        }
    }
}
