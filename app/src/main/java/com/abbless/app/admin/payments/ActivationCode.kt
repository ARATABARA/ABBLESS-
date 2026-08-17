package com.abbless.app.admin.payments

data class ActivationCode(

    val code: String,

    val planId: String,

    val used: Boolean = false,

    val userId: String? = null

)
