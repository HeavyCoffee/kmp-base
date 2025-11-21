package plugin

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import ext.configureAndroid
import ext.configureMultiplatform
import ext.getAndroidSdkVer
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.gradle.kotlin.dsl.apply

class KmpAppConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        apply(plugin = "org.jetbrains.kotlin.multiplatform")
        apply(plugin = "com.android.application")

        extensions.configure<KotlinMultiplatformExtension> {
            configureMultiplatform(this, "App")
        }

        extensions.configure<BaseAppModuleExtension> {
            val androidSdk = getAndroidSdkVer()

            configureAndroid(extension = this, androidSdk = androidSdk)

            defaultConfig {
                applicationId = AndroidConfig.APP_ID
                targetSdk = androidSdk.target
                versionCode = 1
                versionName = AndroidConfig.VERSION_NAME+"($versionCode)"
            }

            packaging {
                resources {
                    excludes += "/META-INF/{AL2.0,LGPL2.1}"
                }
            }

            buildTypes {
                getByName("release") {
                    isMinifyEnabled = false
                }
            }
        }
    }
}