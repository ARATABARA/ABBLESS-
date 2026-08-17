package com.abbless.app.admin.settings

data class SystemSettings(

    val appName: String = "ABBLESS",

    val maintenanceMode: Boolean = false,

    val registrationEnabled: Boolean = true,

    val messagingEnabled: Boolean = true,

    val aiEnabled: Boolean = true,

    val quizEnabled: Boolean = true,

    val notificationsEnabled: Boolean = true,

    val lessonsEnabled: Boolean = true,

    val defaultLanguage: String = "Kirundi",

    val minimumAppVersion: String = "1.0.0"
)
