import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.1.51"
    id("org.jetbrains.kotlin.plugin.spring") version "1.1.51"
    id("org.springframework.boot") version "2.0.0.M5"
    id("io.spring.dependency-management") version "1.0.3.RELEASE"
}

repositories {
    mavenCentral()
    maven("https://repo.spring.io/milestone")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jre8")
    compile("org.jetbrains.kotlin:kotlin-reflect")
    compile("org.springframework.boot:spring-boot-starter-webflux")
}

tasks.getByName("processResources").dependsOn(":frontend:build")