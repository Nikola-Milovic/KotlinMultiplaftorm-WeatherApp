plugins {
    id("multiplatform-setup")
    id("android-setup")
    id("kotlinx-serialization")
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(Deps.ArkIvanov.MVIKotlin.rx)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlin)
                implementation(Deps.ArkIvanov.Decompose.decompose)
                implementation(Deps.Badoo.Reaktive.reaktive)

                implementation(Deps.JetBrains.Ktor.core)
            }
        }

        named("androidMain") {
            dependencies {
                implementation(Deps.JetBrains.Ktor.android)
                implementation(Deps.JetBrains.Ktor.jsonJVM)
                implementation(Deps.JetBrains.Ktor.serializationJVM)
               // implementation(Deps.JetBrains.Ktor.logging)
                implementation(Deps.JetBrains.Ktor.okhttp)
            }
        }


        named("iosMain") {
            dependencies {
                implementation(Deps.JetBrains.Ktor.ios)
            }
        }

        named("desktopMain"){
            dependencies{
                implementation(Deps.JetBrains.Ktor.core)
                implementation(Deps.JetBrains.Ktor.javaClient)
          //    implementation(Deps.JetBrains.Ktor.curlClient)
            }
        }

    }
}
