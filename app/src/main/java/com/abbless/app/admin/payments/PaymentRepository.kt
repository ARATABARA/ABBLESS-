package com.abbless.app.admin.payments

object PaymentRepository {

    private val plans =
        mutableListOf<SubscriptionPlan>()

    private val subscriptions =
        mutableListOf<Subscription>()

    private val codes =
        mutableListOf<ActivationCode>()

    fun addPlan(
        plan: SubscriptionPlan
    ) {
        plans.add(plan)
    }

    fun getPlans(): List<SubscriptionPlan> {
        return plans.toList()
    }

    fun addCode(
        code: ActivationCode
    ) {
        codes.add(code)
    }

    fun getCodes(): List<ActivationCode> {
        return codes.toList()
    }

    fun addSubscription(
        subscription: Subscription
    ) {
        subscriptions.add(subscription)
    }

    fun getUserSubscription(
        userId: String
    ): Subscription? {

        return subscriptions.find {
            it.userId == userId &&
            it.active
        }
    }
}
