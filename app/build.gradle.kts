
plugins {
    alias(libs.plugins.buildlogic.kmp.app)
    alias(libs.plugins.buildlogic.compose)
}

kotlin {
    sourceSets {
        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(libs.common.compose.runtime)
            implementation(libs.common.compose.foundation)
            implementation(libs.common.compose.material3)
            implementation(libs.common.compose.ui)
            implementation(libs.common.compose.resources)
            implementation(libs.common.compose.preview)
            implementation(libs.common.androidx.lifecycle.viewmodelCompose)
            implementation(libs.common.androidx.lifecycle.runtimeCompose)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

dependencies {
    debugImplementation(libs.common.compose.uiTooling)
}