package com.abbless.app.admin.payments

data class Subscription(

    val userId: String,

    val planId: String,

    val startDate: Long,

    val expiryDate: Long,

    val active: Boolean

)
