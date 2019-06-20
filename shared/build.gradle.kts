plugins {
    kotlin("multiplatform")
}

repositories {
    mavenCentral()
}

kotlin {
    jvm()
    js {
        browser()
        nodejs()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        getByName("jvmMain").apply {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
            }
        }
        getByName("jvmTest").apply {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
            }
        }
        getByName("jsMain").apply {
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }
        getByName("jsTest").apply {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}