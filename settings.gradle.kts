pluginManagement {
    val sqlDelightVersion: String by settings

    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "com.squareup.sqldelight") {
                useModule("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")
            }
        }
    }
}
