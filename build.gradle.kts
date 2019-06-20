allprojects {
    group = "io.spring"
    version = "1.0.0-SNAPSHOT"
}

plugins {
    kotlin("multiplatform") version "1.3.40" apply false
    kotlin("js") version "1.3.40" apply false
    kotlin("plugin.allopen") version "1.3.40" apply false
}

repositories {

}