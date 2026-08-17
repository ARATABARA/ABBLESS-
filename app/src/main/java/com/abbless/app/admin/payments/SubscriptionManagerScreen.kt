package com.abbless.app.admin.payments

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.*
@Composable
fun SubscriptionManagerScreen() {

    var subscriptions by remember {
        mutableStateOf(
            getSubscriptions()
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "👤 Subscriptions",
            style =
                MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        LazyColumn {

            items(subscriptions) { subscription ->

                SubscriptionCard(
                    subscription = subscription
                )
            }
        }
    }
}
