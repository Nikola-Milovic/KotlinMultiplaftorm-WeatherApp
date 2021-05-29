import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("multiplatform-setup")
    id("android-setup")
    id("kotlinx-serialization")
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(project(":common:utils"))
//                implementation(project(":common:database"))
                implementation(Deps.ArkIvanov.Decompose.decompose)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlin)
             //   implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinExtensionsReaktive)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinExtensionsCoroutines)
                implementation(Deps.Badoo.Reaktive.reaktive)

                implementation(Deps.Utils.napier)

                implementation(Deps.JetBrains.Ktor.core)
                implementation(Deps.JetBrains.Ktor.json)
                implementation(Deps.JetBrains.Ktor.serialization)
            }
        }

        named("androidMain") {
            dependencies {
                implementation(Deps.Utils.napier)

                implementation(Deps.JetBrains.Ktor.android)
                implementation(Deps.JetBrains.Ktor.jsonJVM)
                implementation(Deps.JetBrains.Ktor.serializationJVM)
                //implementation(Deps.JetBrains.Ktor.logging)
            }
        }

//        named("iosMain") {
//            dependencies {
//                implementation(Deps.JetBrains.Ktor.ios)
//                implementation(Deps.JetBrains.Ktor.iosSerialization)
//                //       implementation(Deps.JetBrains.Ktor.jsonNative)
//            }
//        }

        named("commonTest") {
            dependencies {
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinMain)
                implementation(Deps.Badoo.Reaktive.reaktiveTesting)
                implementation(Deps.Badoo.Reaktive.utils)
            }
        }
    }

    targets.getByName<KotlinNativeTarget>("iosX64").compilations.forEach {
        it.kotlinOptions.freeCompilerArgs += arrayOf("-linker-options", "-lsqlite3")
    }
}