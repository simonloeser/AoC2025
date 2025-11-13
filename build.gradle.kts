plugins {
    kotlin("jvm") version "2.2.20"
}

group = "org.sl"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:2.2.20")
}

kotlin {
    jvmToolchain(24)
}

tasks.withType<JavaCompile> {
    javaCompiler.set(javaToolchains.compilerFor {
        languageVersion.set(JavaLanguageVersion.of(24))
    })
}

tasks.test {
    useJUnitPlatform()
}
