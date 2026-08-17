package com.abbless.app.lessons.progress


object Statistics {


    fun calculateCompletion(

        progress: List<Progress>

    ): Int {


        if(progress.isEmpty())
            return 0


        val completed =
            progress.count {

                it.completed

            }


        return (completed * 100) / progress.size

    }

}
