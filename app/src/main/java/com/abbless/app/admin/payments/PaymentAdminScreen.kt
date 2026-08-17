package com.abbless.app.admin.payments

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.UUID

@Composable
fun PaymentAdminScreen() {

    var planName by remember {
        mutableStateOf("")
    }

    var price by remember {
        mutableStateOf("")
    }

    var days by remember {
        mutableStateOf("")
    }

    var message by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "💳 Payment Manager",
            style =
                MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        OutlinedTextField(
            value = planName,
            onValueChange = {
                planName = it
            },
            label = {
                Text("Plan name")
            },
            modifier =
                Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = price,
            onValueChange = {
                price = it
            },
            label = {
                Text("Price (BIF)")
            },
            modifier =
                Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = days,
            onValueChange = {
                days = it
            },
            label = {
                Text("Duration (days)")
            },
            modifier =
                Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = {

                val priceValue =
                    price.toLongOrNull()

                val daysValue =
                    days.toIntOrNull()

                if (
                    planName.isNotBlank() &&
                    priceValue != null &&
                    daysValue != null
                ) {

                    PaymentRepository.addPlan(

                        SubscriptionPlan(

                            id =
                                UUID.randomUUID()
                                    .toString(),

                            name = planName,

                            priceBif =
                                priceValue,

                            durationDays =
                                daysValue
                        )
                    )

                    planName = ""
                    price = ""
                    days = ""

                    message =
                        "Plan yashizweho neza ✅"

                } else {

                    message =
                        "Uzuza neza amakuru yose."
                }
            }
        ) {

            Text("➕ Add Plan")
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = message
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "📋 Existing Plans",
            style =
                MaterialTheme.typography.titleLarge
        )

        PaymentRepository
            .getPlans()
            .forEach { plan ->

                Text(
                    "${plan.name} — " +
                    "${plan.priceBif} BIF — " +
                    "${plan.durationDays} days"
                )
            }
    }
}
