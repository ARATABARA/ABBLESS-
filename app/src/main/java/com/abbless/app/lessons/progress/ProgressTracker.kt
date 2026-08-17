package com.abbless.app.lessons.progress


object ProgressTracker {


    private val progressList =
        mutableListOf<Progress>()


    fun update(progress: Progress){

        progressList.removeIf {

            it.lessonId == progress.lessonId &&
            it.userId == progress.userId

        }


        progressList.add(progress)

    }


    fun getUserProgress(
        userId: String
    ): List<Progress>{

        return progressList.filter {

            it.userId == userId

        }

    }


}
