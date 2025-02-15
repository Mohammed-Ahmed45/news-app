// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false

}
buildscript {
    repositories {
        google()
    }
    dependencies {
        val nav_version = "2.8.0"
        classpath(libs.androidx.navigation.safe.args.gradle.plugin)
    }
}