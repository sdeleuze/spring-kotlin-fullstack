import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
        maven("https://repo.spring.io/milestone")
    }

    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.0.M6")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.2.0")
        classpath("org.jetbrains.kotlin:kotlin-allopen:1.2.0")
        classpath("io.spring.gradle:dependency-management-plugin:1.0.3.RELEASE")
    }
}

apply {
    plugin("org.springframework.boot")
    plugin("kotlin-spring")
    plugin("kotlin-platform-jvm")
    plugin("io.spring.dependency-management")
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
    "compile"("org.jetbrains.kotlin:kotlin-stdlib-jre8")
    "compile"("org.jetbrains.kotlin:kotlin-reflect")
    "compile"("org.springframework.boot:spring-boot-starter-webflux")
    "expectedBy"(project(":common"))
}

tasks.getByName("processResources").dependsOn(":frontend:build")