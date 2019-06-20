import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    kotlin("jvm")
    kotlin("plugin.allopen")

    id("org.springframework.boot") version "2.1.6.RELEASE"
}

apply(plugin = "io.spring.dependency-management")

repositories {
    mavenCentral()
}

dependencies {
    "compile"("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    "compile"("org.jetbrains.kotlin:kotlin-reflect")
    "compile"("org.springframework.boot:spring-boot-starter-webflux")
    "compile"(project(":shared"))
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
}

allOpen {
    annotation("org.springframework.boot.autoconfigure.SpringBootApplication")
}

//tasks {
//    processResources {
//        dependsOn(":frontend:browserWebpack")
//        from(project(":frontend").projectDir.resolve("src/main/resources"))
//        from(project(":frontend").buildDir.resolve("libs/spring-kotlin-fullstack-frontend.js"))
//    }
//}