plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.winditesttask"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.winditesttask"
        minSdk = 24
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.room.compiler)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.dagger.hilt)
    kapt(libs.hilt.compiler)

    implementation(libs.hilt.viewmodel)
    kapt(libs.androidx.compiler)

    implementation(libs.navigation.compose)

    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)

    implementation(libs.androidx.core.ktx.v1120)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.material)
    implementation(libs.androidx.ui.tooling.preview)

    implementation(libs.retrofit)
    implementation(libs.converter.gson)

}