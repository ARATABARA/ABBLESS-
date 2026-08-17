package com.abbless.app.ai.security


object ApiKeyManager {


    private var key = ""


    fun setKey(
        apiKey: String
    ){

        key = apiKey

    }


    fun getKey(): String {

        return key

    }


}
