package com.abbless.app.admin.payments

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.UUID

@Composable
fun ActivationCodeManagerScreen() {

    var selectedPlan by remember {
        mutableStateOf("")
    }

    var generatedCode by remember {
        mutableStateOf("")
    }

    var codes by remember {
        mutableStateOf(
            PaymentRepository.getCodes()
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "🎟️ Activation Codes",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        OutlinedTextField(
            value = selectedPlan,
            onValueChange = {
                selectedPlan = it
            },
            label = {
                Text("Plan ID")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Button(
            onClick = {

                if (selectedPlan.isNotBlank()) {

                    val code =
                        "ABB-" +
                        UUID.randomUUID()
                            .toString()
                            .take(8)
                            .uppercase()

                    PaymentRepository.addCode(
                        ActivationCode(
                            code = code,
                            planId = selectedPlan
                        )
                    )

                    generatedCode = code

                    codes =
                        PaymentRepository.getCodes()
                }
            }
        ) {
            Text("🎟️ Generate Code")
        }

        if (generatedCode.isNotEmpty()) {

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = "New Code: $generatedCode",
                style = MaterialTheme.typography.titleMedium
            )
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Codes",
            style = MaterialTheme.typography.titleLarge
        )

        LazyColumn {

            items(codes) { code ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(12.dp)
                    ) {

                        Text("🎟️ ${code.code}")

                        Text("Plan: ${code.planId}")

                        Text(
                            if (code.used)
                                "🔴 Used"
                            else
                                "🟢 Available"
                        )
                    }
                }
            }
        }
    }
}
