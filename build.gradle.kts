import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.31"
    id("com.squareup.sqldelight")
}

sqldelight {
    database("LanguageExampleDatabase") {
        packageName = "airy.forest"
    }
}

group = "airy.forest"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val sqlDelightVersion: String by project
    implementation("com.squareup.sqldelight:sqlite-driver:$sqlDelightVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
