android {
    namespace = "com.abbless.app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.abbless.app"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        jvmToolchain(17)
    }

    // izindi settings...
}

