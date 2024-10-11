import com.android.build.api.dsl.ViewBinding

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.kotlin.parcelize)
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
    //hilt
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")

}

android {
    namespace = "com.mohamed.news_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mohamed.news_app"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures{
        viewBinding=true
        dataBinding=true
        buildConfig= true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation (libs.androidx.core.splashscreen)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation (libs.gson)
    implementation (libs.retrofit)
//    implementation (libs.converter.gson)
    implementation (libs.retrofit2.converter.gson)
    implementation(libs.logging.interceptor)
    //glide
    implementation (libs.glide)
    //view modlel


    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // LiveData
    implementation(libs.androidx.lifecycle.livedata.ktx)
    //hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

}
kapt {
    correctErrorTypes = true
}