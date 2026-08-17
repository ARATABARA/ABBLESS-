package com.abbless.app.lessons.ai

import com.abbless.app.lessons.model.Lesson


object RecommendationEngine {


    fun recommend(

        profile: LearningProfile,

        lessons: List<Lesson>

    ): List<Lesson>{


        return lessons.filter { lesson ->


            profile.favoriteCategories.contains(
                lesson.category
            )


        }

    }


}
