package com.abbless.app.admin.payments

object PaymentAccess {

    fun hasActiveSubscription(
        userId: String
    ): Boolean {

        val subscription =
            PaymentRepository.getUserSubscription(userId)
                ?: return false

        return subscription.active &&
                subscription.expiryDate > System.currentTimeMillis()
    }
}
