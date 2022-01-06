plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
}
group = "com.jetbrains"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    gradlePluginPortal()
    google()
    mavenCentral()
}
dependencies {
    //implementation(project(":shared"))    // works as expected when referencing this way.
    implementation("KmmSample:shared-android:0.0.1")    // using maven local.
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
}
android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.jetbrains.androidApp"
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}