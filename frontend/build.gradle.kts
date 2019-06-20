plugins {
    kotlin("js")
}

repositories {
    mavenCentral()
}

kotlin {
    target {
        browser()

        sourceSets {
            main {
                dependencies {
                    implementation(kotlin("stdlib-js"))
                    implementation(project(":shared"))
                }
            }
        }
    }
}
