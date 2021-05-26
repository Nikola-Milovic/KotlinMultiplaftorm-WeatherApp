object Deps {

    object JetBrains {
        object Kotlin {
            // __KOTLIN_COMPOSE_VERSION__
            private const val VERSION = "1.4.32"
            const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$VERSION"
            const val testCommon = "org.jetbrains.kotlin:kotlin-test-common:$VERSION"
            const val testJunit = "org.jetbrains.kotlin:kotlin-test-junit:$VERSION"
            const val testAnnotationsCommon = "org.jetbrains.kotlin:kotlin-test-annotations-common:$VERSION"

            const val serializationGradle = "org.jetbrains.kotlin:kotlin-serialization:$VERSION"

            object Coroutines {
                const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VERSION"
                const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$VERSION"
            }
        }


        object Ktor {
            private const val VERSION = "1.5.4"
            const val core = "io.ktor:ktor-client-core:$VERSION"
            const val json = "io.ktor:ktor-client-json:$VERSION"
            const val serialization = "io.ktor:ktor-client-serialization:$VERSION"

            const val android = "io.ktor:ktor-client-android:$VERSION"
            const val jsonJVM = "io.ktor:ktor-client-json-jvm:$VERSION"
            const val serializationJVM = "io.ktor:ktor-client-serialization-jvm:$VERSION"
            const val okhttp = "io.ktor:ktor-client-okhttp:$VERSION"
            const val logging = "com.squareup.okhttp3:logging-interceptor:3.14.1"

            const val ios = "io.ktor:ktor-client-ios:$VERSION"
            const val jsonNative = "io.ktor:ktor-client-json-native:$VERSION"
            const val iosSerialization = "io.ktor:ktor-client-serialization-iosx64:$VERSION"

        }

        object Compose {
            // __LATEST_COMPOSE_RELEASE_VERSION__
            private const val VERSION = "0.4.0-build183"
            const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$VERSION"

            private const val TOOLING_VERSION = "1.0.0-beta07"
            const val tooling = "androidx.compose.ui:ui-tooling:$TOOLING_VERSION"
            const val compiler = "androidx.compose.compiler:compiler:$TOOLING_VERSION"
        }


    }

    object Utils {
        //Logger
        const val napier = "com.github.aakira:napier:1.4.1"
    }

    object Android {
        object Tools {
            object Build {
                const val gradlePlugin = "com.android.tools.build:gradle:4.0.1"
            }
        }
    }

    object AndroidX {
        object AppCompat {
            const val appCompat = "androidx.appcompat:appcompat:1.3.0-beta01"
        }

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.3.0-alpha02"
        }
    }

    object ArkIvanov {
        object MVIKotlin {
            private const val VERSION = "2.0.2"
            const val rx = "com.arkivanov.mvikotlin:rx:$VERSION"
            const val mvikotlin = "com.arkivanov.mvikotlin:mvikotlin:$VERSION"
            const val mvikotlinMain = "com.arkivanov.mvikotlin:mvikotlin-main:$VERSION"
            const val mvikotlinMainIosX64 = "com.arkivanov.mvikotlin:mvikotlin-main-iosx64:$VERSION"
            const val mvikotlinMainIosArm64 = "com.arkivanov.mvikotlin:mvikotlin-main-iosarm64:$VERSION"
            const val mvikotlinLogging = "com.arkivanov.mvikotlin:mvikotlin-logging:$VERSION"
            const val mvikotlinTimeTravel = "com.arkivanov.mvikotlin:mvikotlin-timetravel:$VERSION"
            const val mvikotlinExtensionsReaktive = "com.arkivanov.mvikotlin:mvikotlin-extensions-reaktive:$VERSION"
            const val mvikotlinExtensionsCoroutines = "com.arkivanov.mvikotlin:mvikotlin-extensions-coroutines:$VERSION"
        }

        object Decompose {
            private const val VERSION = "0.2.3"
            const val decompose = "com.arkivanov.decompose:decompose:$VERSION"
            const val decomposeIosX64 = "com.arkivanov.decompose:decompose-iosx64:$VERSION"
            const val decomposeIosArm64 = "com.arkivanov.decompose:decompose-iosarm64:$VERSION"
            const val extensionsCompose = "com.arkivanov.decompose:extensions-compose-jetbrains:$VERSION"
        }
    }

    object Badoo {
        object Reaktive {
            private const val VERSION = "1.1.22"
            const val reaktive = "com.badoo.reaktive:reaktive:$VERSION"
            const val reaktiveTesting = "com.badoo.reaktive:reaktive-testing:$VERSION"
            const val utils = "com.badoo.reaktive:utils:$VERSION"
            const val coroutinesInterop = "com.badoo.reaktive:coroutines-interop:$VERSION"
        }
    }

    object Squareup {
        object SQLDelight {
            private const val VERSION = "1.4.4"

            const val gradlePlugin = "com.squareup.sqldelight:gradle-plugin:$VERSION"
            const val androidDriver = "com.squareup.sqldelight:android-driver:$VERSION"
            const val sqliteDriver = "com.squareup.sqldelight:sqlite-driver:$VERSION"
            const val nativeDriver = "com.squareup.sqldelight:native-driver:$VERSION"
        }
    }
}
