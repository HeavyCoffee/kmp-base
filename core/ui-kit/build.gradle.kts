plugins {
    alias(libs.plugins.buildlogic.kmp.library)
    alias(libs.plugins.buildlogic.compose)
}
kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.compose.runtime)
            api(libs.compose.foundation)
            implementation(libs.compose.material3)
            //implementation(libs.common.compose.ui)
            api(libs.compose.resources)
            api(libs.compose.preview)
        }
    }
}

dependencies {
    debugApi(libs.compose.uiTooling)
}