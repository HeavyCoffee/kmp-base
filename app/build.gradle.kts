import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
//    alias(libs.plugins.kotlin.multiplatform)
//    alias(libs.plugins.android.app)
//    alias(libs.plugins.compose.multiplatform)
//    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.buildlogic.kmp.app)
    alias(libs.plugins.buildlogic.compose)
}

kotlin {
//    androidTarget {
//        compilerOptions {
//            jvmTarget.set(JvmTarget.JVM_11)
//        }
//    }
//    listOf(
//        iosArm64(),
//        iosSimulatorArm64()
//    ).forEach { iosTarget ->
//        iosTarget.binaries.framework {
//            baseName = "App"
//            isStatic = true
//        }
//    }
    
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

//android {
//    namespace = "com.heavycoffee.kmpbase"
//    compileSdk = libs.versions.android.compileSdk.get().toInt()
//
//    defaultConfig {
//        applicationId = "com.heavycoffee.kmpbase"
//        minSdk = libs.versions.android.minSdk.get().toInt()
//        targetSdk = libs.versions.android.targetSdk.get().toInt()
//        versionCode = 1
//        versionName = "1.0"
//    }
//    packaging {
//        resources {
//            excludes += "/META-INF/{AL2.0,LGPL2.1}"
//        }
//    }
//    buildTypes {
//        getByName("release") {
//            isMinifyEnabled = false
//        }
//    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_11
//        targetCompatibility = JavaVersion.VERSION_11
//    }
//}

dependencies {
    debugImplementation(libs.common.compose.uiTooling)
}

