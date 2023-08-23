import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("kapt") version "1.9.0"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0"
    id("java")
    id("idea")
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("maven-publish")
}

group = "club.plutomc.plutoproject.common"
version = "3.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

allprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.kapt")
        plugin("org.jetbrains.kotlin.plugin.serialization")
        plugin("idea")
        plugin("java")
        plugin("com.github.johnrengelman.shadow")
    }

    repositories {
        mavenLocal()
        mavenCentral()
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
        }
        maven {
            url = uri("https://repo.papermc.io/repository/maven-public/")
        }
    }

    dependencies {
        // Kotlin language dependencies
        compileOnly(kotlin("stdlib-jdk8", "1.9.0"))
        compileOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }

    tasks.withType<org.gradle.jvm.tasks.Jar>().configureEach {
        destinationDirectory = file("$rootDir/products")
    }
}

/*tasks.named<ShadowJar>("shadowJar").configure {
    relocate("kotlin", "libs.kotlin")
    relocate("kotlinx", "libs.kotlinx")
}*/

dependencies {

}