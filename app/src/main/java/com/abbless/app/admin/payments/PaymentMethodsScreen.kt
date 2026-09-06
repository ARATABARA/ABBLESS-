package com.abbless.app.admin.payments

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.util.UUID

@Composable
fun PaymentMethodsScreen(
    onBack: () -> Unit
) {
    val context = LocalContext.current

    var methods by remember {
        mutableStateOf(
            PaymentMethodRepository.getMethods(context)
        )
    }

    var name by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    var editingMethod by remember {
        mutableStateOf<PaymentMethod?>(null)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "💳 Payment Methods",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Admin ashobora kwongeramwo no guhindura uburyo bwo kwishura."
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text("Method name")
            },
            placeholder = {
                Text("Mvola, EcoCash, Lumicash...")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = number,
            onValueChange = {
                number = it
            },
            label = {
                Text("Numero / Account")
            },
            placeholder = {
                Text("+257...")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {

                if (
                    name.isBlank() ||
                    number.isBlank()
                ) {

                    message =
                        "Uzuza izina na numero."

                } else {

                    if (editingMethod == null) {

                        PaymentMethodRepository.addMethod(
                            context,
                            PaymentMethod(
                                id = UUID.randomUUID().toString(),
                                name = name.trim(),
                                accountNumber = number.trim(),
                                active = true
                            )
                        )

                        message =
                            "Payment method yongewemwo neza ✅"

                    } else {

                        val old =
                            editingMethod!!

                        PaymentMethodRepository.updateMethod(
                            context,
                            old.copy(
                                name = name.trim(),
                                accountNumber = number.trim()
                            )
                        )

                        message =
                            "Payment method yahinduwe neza ✅"

                        editingMethod = null
                    }

                    methods =
                        PaymentMethodRepository.getMethods(
                            context
                        )

                    name = ""
                    number = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                if (editingMethod == null)
                    "➕ Add Payment Method"
                else
                    "💾 Save Changes"
            )
        }

        if (editingMethod != null) {

            Spacer(modifier = Modifier.height(6.dp))

            TextButton(
                onClick = {
                    editingMethod = null
                    name = ""
                    number = ""
                    message = ""
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cancel Edit")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        if (message.isNotEmpty()) {

            Text(message)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "📋 Payment Methods",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

            items(
                items = methods,
                key = { it.id }
            ) { method ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = method.name,
                            style =
                                MaterialTheme.typography.titleMedium
                        )

                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )

                        Text(
                            text =
                                "📱 ${method.accountNumber}"
                        )

                        Text(
                            text =
                                if (method.active)
                                    "Status: Active ✅"
                                else
                                    "Status: Inactive ❌"
                        )

                        Spacer(
                            modifier = Modifier.height(10.dp)
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement =
                                Arrangement.spacedBy(8.dp)
                        ) {

                            Button(
                                onClick = {

                                    editingMethod =
                                        method

                                    name =
                                        method.name

                                    number =
                                        method.accountNumber

                                    message = ""

                                },
                                modifier =
                                    Modifier.weight(1f)
                            ) {
                                Text("✏️ Edit")
                            }

                            Button(
                                onClick = {

                                    PaymentMethodRepository
                                        .toggleMethod(
                                            context,
                                            method.id
                                        )

                                    methods =
                                        PaymentMethodRepository
                                            .getMethods(
                                                context
                                            )

                                },
                                modifier =
                                    Modifier.weight(1f)
                            ) {
                                Text(
                                    if (method.active)
                                        "Disable"
                                    else
                                        "Enable"
                                )
                            }
                        }

                        Spacer(
                            modifier = Modifier.height(6.dp)
                        )

                        OutlinedButton(
                            onClick = {

                                PaymentMethodRepository
                                    .deleteMethod(
                                        context,
                                        method.id
                                    )

                                methods =
                                    PaymentMethodRepository
                                        .getMethods(
                                            context
                                        )

                                if (
                                    editingMethod?.id ==
                                    method.id
                                ) {
                                    editingMethod = null
                                    name = ""
                                    number = ""
                                }

                            },
                            modifier =
                                Modifier.fillMaxWidth()
                        ) {
                            Text("🗑️ Delete")
                        }
                    }
                }
            }
        }

        TextButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("← Back")
        }
    }
}
