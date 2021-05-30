plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(project(":common:main"))
                implementation(project(":common:root"))
                implementation(Deps.ArkIvanov.Decompose.decompose)
                implementation(Deps.ArkIvanov.Decompose.extensionsCompose)
                implementation(Deps.JetBrains.Compose.material)
                implementation(Deps.JetBrains.Compose.compiler)
                implementation(Deps.JetBrains.Compose.ui)
            }
        }
    }
}
