package com.abbless.app.admin.settings

object SystemSettingsRepository {

    private var settings =
        SystemSettings()

    fun getSettings(): SystemSettings {
        return settings
    }

    fun updateSettings(
        newSettings: SystemSettings
    ) {
        settings = newSettings
    }
}
