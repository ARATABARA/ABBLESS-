package com.abbless.app.lessons.progress


object ProgressRepository {


    fun save(
        progress: Progress
    ){

        ProgressTracker.update(progress)

    }


}
