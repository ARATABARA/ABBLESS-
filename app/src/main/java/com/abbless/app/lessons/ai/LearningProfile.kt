package com.abbless.app.lessons.ai

data class LearningProfile(

    val userId: String,

    val favoriteCategories: List<String>,

    val level: String,

    val completedLessons: Int,

    val weakAreas: List<String>

)
