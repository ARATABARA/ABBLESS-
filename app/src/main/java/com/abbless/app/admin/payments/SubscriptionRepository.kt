package com.abbless.app.admin.payments

fun getSubscriptions(): List<AdminSubscription> {
    return listOf(
        AdminSubscription(
            id = "1",
            userName = "Demo User",
            plan = "Monthly",
            active = true
        )
    )
}
