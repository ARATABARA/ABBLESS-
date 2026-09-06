package com.abbless.app.admin.payments

object PaymentManager {

    fun activateCode(
        code: String,
        userId: String
    ): Boolean {

        val activationCode =
            PaymentRepository
                .getCodes()
                .find {
                    it.code == code &&
                    !it.used
                }
                ?: return false

        val plan =
            PaymentRepository
                .getPlans()
                .find {
                    it.id == activationCode.planId
                }
                ?: return false

        val now = System.currentTimeMillis()

        val subscription =
            Subscription(
                userId = userId,
                planId = plan.id,
                startDate = now,
                expiryDate =
                    now +
                    plan.durationDays * 24L * 60L * 60L * 1000L,
                active = true
            )

        PaymentRepository.addSubscription(
            subscription
        )

        return true
    }
}
