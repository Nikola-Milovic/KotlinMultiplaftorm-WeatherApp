import org.jetbrains.compose.compose

plugins {
            id("com.android.application")
            kotlin("android")
            id("org.jetbrains.compose")
        }

android {
    compileSdkVersion(AndroidGradle.TARGETSDK)
    defaultConfig {
        applicationId = "com.nikolam.kmm_weather.androidApp"
        minSdkVersion(AndroidGradle.MINSDK)
        targetSdkVersion(AndroidGradle.TARGETSDK)
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    packagingOptions {
        exclude("META-INF/*")
    }
}

dependencies {
    implementation(project(":common:root"))
    implementation(project(":common:main"))
    implementation(project(":common:utils"))
    implementation(project(":common:compose-ui"))
    implementation(compose.material)
    implementation(Deps.ArkIvanov.MVIKotlin.mvikotlin)
    implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinMain)
    implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinLogging)
    implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinTimeTravel)
    implementation(Deps.ArkIvanov.Decompose.decompose)
    implementation(Deps.ArkIvanov.Decompose.extensionsCompose)
    implementation(Deps.AndroidX.AppCompat.appCompat)
    implementation(Deps.AndroidX.Activity.activityCompose)

    implementation(Deps.Utils.napier)
}
