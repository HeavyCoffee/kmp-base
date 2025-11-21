plugins {
    alias(libs.plugins.kotlin.gradle.jvm)
    `kotlin-dsl`
}

dependencies {
    implementation(libs.plugin.kotlin.gradle)
    implementation(libs.plugin.android)
}

gradlePlugin {
    val pluginPrefix = "build-logic"
    val pluginPath = "plugin"

    plugins {
        register("ComposePlugin") {
            id = "$pluginPrefix.compose"
            implementationClass = "$pluginPath.ComposeConventionPlugin"
        }
        register("KmpAppPlugin") {
            id = "$pluginPrefix.kmp.app"
            implementationClass = "$pluginPath.KmpAppConventionPlugin"
        }
        register("KmpLibraryPlugin") {
            id = "$pluginPrefix.kmp.library"
            implementationClass = "$pluginPath.KmpLibraryConventionPlugin"
        }
    }
}

group = "build-logic"