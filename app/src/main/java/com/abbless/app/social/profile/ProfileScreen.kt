package com.abbless.app.social.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abbless.app.auth.model.UserAccount

@Composable
fun ProfileScreen(
    user: UserAccount?,
    onBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "👤 ABBLESS Profile",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Name: ${user?.name ?: "Unknown"}"
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Phone Number: ${user?.phoneNumber ?: "Unknown"}"
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Date of Birth: ${user?.dateOfBirth ?: "Unknown"}"
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Subscription: Free"
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Button(
            onClick = {
                // Edit Profile will be connected later
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("✏️ Edit Profile")
        }

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("⬅️ Back")
        }
    }
}
