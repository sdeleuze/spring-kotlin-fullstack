import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot") version "2.2.0.M4"
	id("io.spring.dependency-management") version "1.0.7.RELEASE"
}

repositories {
    mavenCentral()
	maven("https://repo.spring.io/milestone")
}

dependencies {
	val coroutinesVersion = "1.2.1"
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:$coroutinesVersion")
	implementation(project(":shared"))
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
	processResources {
		dependsOn(":frontend:browserWebpack")
		from(project(":frontend").projectDir.resolve("src/main/resources")) {
			into("static")
		}
		from(project(":frontend").buildDir.resolve("libs/spring-kotlin-fullstack-frontend.js"))  {
			into("static")
		}
	}
}
