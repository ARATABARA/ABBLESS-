package com.abbless.app.admin.payments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class AdminSubscription(
    val id: String,
    val userName: String,
    val plan: String,
    val active: Boolean = true
)

@Composable
fun SubscriptionCard(
    subscription: AdminSubscription
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("👤 ${subscription.userName}")
            Text("📦 Plan: ${subscription.plan}")
            Text(
                if (subscription.active)
                    "Status: Active ✅"
                else
                    "Status: Inactive ❌"
            )
        }
    }
}
