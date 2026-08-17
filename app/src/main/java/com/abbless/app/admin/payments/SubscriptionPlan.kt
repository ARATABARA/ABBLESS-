package com.abbless.app.admin.payments

data class SubscriptionPlan(

    val id: String,

    val name: String,

    val priceBif: Long,

    val durationDays: Int,

    val active: Boolean = true

)
