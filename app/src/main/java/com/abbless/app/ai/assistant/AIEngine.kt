package com.abbless.app.ai.assistant


object AIEngine {


    fun answer(
        question: String
    ): String {


        return when {

            question.contains("hello",
                true) ->
                "Muraho! Ndi ABBLESS AI."

            question.contains("science",
                true) ->
                "Ndagufasha kwiga Science."

            else ->
                "Reka ndagufashe kuri ico kibazo."

        }


    }


}
