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

        if (activationCode == null) {
            return false
        }

        return true
    }
}
