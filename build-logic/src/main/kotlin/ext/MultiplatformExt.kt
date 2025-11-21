package ext

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureMultiplatform(
    extension: KotlinMultiplatformExtension
) = extension.apply {
    configureAndroidTarget(extension)
    iosArm64()
    iosSimulatorArm64()
}

internal fun Project.configureMultiplatform(
    extension: KotlinMultiplatformExtension,
    iosFrameworkName: String
) = extension.apply {
    androidTarget {
        compilerOptions {
            jvmTarget.set(AndroidConfig.JAVA_TARGET)
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            this.baseName = iosFrameworkName
            isStatic = true
        }
    }
}

private fun Project.configureAndroidTarget(
    extension: KotlinMultiplatformExtension
) = extension.apply {
    androidTarget {
        compilerOptions {
            jvmTarget.set(AndroidConfig.JAVA_TARGET)
        }
    }
}