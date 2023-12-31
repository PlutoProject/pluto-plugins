pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "pluto-plugins"
include("pluto-connector")
include("pluto-runtime")
include("pluto-messaging")
include("pluto-api-utils")