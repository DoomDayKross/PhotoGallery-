buildscript {
    repositories {
        google()  // Needed for Compose and Android tools
        mavenCentral()  // For other dependencies
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0")
        classpath("com.android.tools.build:gradle:8.0.0")
        classpath("org.jetbrains.compose:compose-gradle-plugin:1.4.0")  // Use a valid version if needed
    }
}
