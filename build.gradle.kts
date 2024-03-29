val kotlinVersion: String by project

plugins {
    kotlin("jvm") version "1.8.21"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.21"
}

group = "com.serega"
version = "0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("io.arrow-kt:arrow-stack:1.2.0-RC"))
    implementation("io.arrow-kt:arrow-core")
}