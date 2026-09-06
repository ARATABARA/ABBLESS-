package com.abbless.app.admin.payments

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

object PaymentMethodRepository {

    private const val PREFS_NAME = "abbless_payment_methods"
    private const val KEY_METHODS = "methods"

    fun getMethods(context: Context): List<PaymentMethod> {

        val prefs = context.getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE
        )

        val json = prefs.getString(KEY_METHODS, null)

        if (json == null) {
            val defaults = defaultMethods()
            saveMethods(context, defaults)
            return defaults
        }

        return try {

            val array = JSONArray(json)
            val methods = mutableListOf<PaymentMethod>()

            for (i in 0 until array.length()) {

                val item = array.getJSONObject(i)

                methods.add(
                    PaymentMethod(
                        id = item.optString("id"),
                        name = item.optString("name"),
                        accountNumber = item.optString("accountNumber"),
                        active = item.optBoolean("active", true)
                    )
                )
            }

            methods

        } catch (e: Exception) {

            val defaults = defaultMethods()
            saveMethods(context, defaults)
            defaults
        }
    }

    fun addMethod(
        context: Context,
        method: PaymentMethod
    ) {

        val methods =
            getMethods(context).toMutableList()

        methods.add(method)

        saveMethods(
            context,
            methods
        )
    }

    fun updateMethod(
        context: Context,
        method: PaymentMethod
    ) {

        val methods =
            getMethods(context).toMutableList()

        val index =
            methods.indexOfFirst {
                it.id == method.id
            }

        if (index != -1) {

            methods[index] = method

            saveMethods(
                context,
                methods
            )
        }
    }

    fun deleteMethod(
        context: Context,
        id: String
    ) {

        val methods =
            getMethods(context)
                .filterNot {
                    it.id == id
                }

        saveMethods(
            context,
            methods
        )
    }

    fun toggleMethod(
        context: Context,
        id: String
    ) {

        val methods =
            getMethods(context).toMutableList()

        val index =
            methods.indexOfFirst {
                it.id == id
            }

        if (index != -1) {

            val method = methods[index]

            methods[index] =
                method.copy(
                    active = !method.active
                )

            saveMethods(
                context,
                methods
            )
        }
    }

    private fun saveMethods(
        context: Context,
        methods: List<PaymentMethod>
    ) {

        val array = JSONArray()

        methods.forEach { method ->

            val item = JSONObject()

            item.put(
                "id",
                method.id
            )

            item.put(
                "name",
                method.name
            )

            item.put(
                "accountNumber",
                method.accountNumber
            )

            item.put(
                "active",
                method.active
            )

            array.put(item)
        }

        context
            .getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
            )
            .edit()
            .putString(
                KEY_METHODS,
                array.toString()
            )
            .apply()
    }

    private fun defaultMethods(): List<PaymentMethod> {

        return listOf(

            PaymentMethod(
                id = "mvola",
                name = "Mvola",
                accountNumber = "",
                active = true
            ),

            PaymentMethod(
                id = "ecocash",
                name = "EcoCash",
                accountNumber = "",
                active = true
            ),

            PaymentMethod(
                id = "airtel_money",
                name = "Airtel Money",
                accountNumber = "",
                active = true
            ),

            PaymentMethod(
                id = "lumicash",
                name = "Lumicash",
                accountNumber = "",
                active = true
            )
        )
    }
}
