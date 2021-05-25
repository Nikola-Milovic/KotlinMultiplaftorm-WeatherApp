plugins {
    id("com.android.library")
}

android {
    compileSdkVersion(AndroidGradle.TARGETSDK)

    defaultConfig {
        minSdkVersion(AndroidGradle.MINSDK)
        targetSdkVersion(AndroidGradle.TARGETSDK)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res")
        }
    }
}
