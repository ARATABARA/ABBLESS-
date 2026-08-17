package com.abbless.app.lessons.ai.generator


object SummaryAI {


    fun summarize(
        text: String
    ): String {

        return text.take(300)

    }

}
