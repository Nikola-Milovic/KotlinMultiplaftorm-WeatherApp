import org.jetbrains.compose.compose

plugins {
    id("com.android.library")
    id("kotlin-multiplatform")
    id("org.jetbrains.compose")
}

////workaround for https://youtrack.jetbrains.com/issue/KT-43944
//android {
//    configurations {
//        create("androidTestApi")
//        create("androidTestDebugApi")
//        create("androidTestReleaseApi")
//        create("testApi")
//        create("testDebugApi")
//        create("testReleaseApi")
//    }
//}

android {
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.0-beta07"
                kotlinCompilerVersion = "1.4.32"
    }
}

kotlin {
    jvm("desktop")
    android()

    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(Deps.JetBrains.Compose.tooling)
                implementation(Deps.JetBrains.Compose.compiler)
            }
        }

        named("androidMain") {
            dependencies {
                implementation("androidx.appcompat:appcompat:1.4.0-alpha01")
                implementation("androidx.core:core-ktx:1.5.0")
            }
        }

        named("desktopMain") {
            dependencies {
                implementation(compose.desktop.common)
            }
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}
