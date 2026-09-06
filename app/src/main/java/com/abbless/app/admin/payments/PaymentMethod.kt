package com.abbless.app.admin.payments

data class PaymentMethod(
    val id: String,
    val name: String,
    val accountNumber: String,
    val active: Boolean = true
)
