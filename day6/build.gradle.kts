plugins {
    id("java")
    kotlin("jvm") version "1.7.21"
}

group = "dof.aoc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(mapOf("path" to ":utils")))
}
