plugins {
    alias(libs.plugins.buildlogic.kmp.library)
}

kotlin {
    sourceSets {
        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
        commonMain.dependencies {
            api(libs.ktor.core)
            implementation(libs.ktor.client.serialization)
            implementation(libs.ktor.client.contentNegotiation)
            implementation(libs.ktor.client.kotlinxJson)
        }
    }
}

dependencies {
    debugApi(libs.compose.uiTooling)
}