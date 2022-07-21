plugins {
    val kotlinVersion: String by System.getProperties()
    kotlin("multiplatform") version kotlinVersion
    id("org.springframework.boot") version System.getProperty("springBootVersion")
}

version = "1.0.0-SNAPSHOT"
group = "com.example"

repositories {
    mavenCentral()
}

// Versions
val kotlinVersion: String by System.getProperties()
val springBootVersion: String by System.getProperties()
val coroutinesVersion: String by project

val mainClassName = "com.example.MainKt"

kotlin {
    jvm {
        withJava()
    }
    js {
        browser {
            runTask {
                outputFileName = "main.bundle.js"
            }
            webpackTask {
                outputFileName = "main.bundle.js"
            }
        }
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("org.springframework.boot:spring-boot-starter:$springBootVersion")
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(npm("marked", "4.0.18"))
            }
        }
    }
}
