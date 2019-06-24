allprojects {
    group = "io.spring"
    version = "1.0.0-SNAPSHOT"
}

plugins {
	val kotlinVersion = "1.3.40"
    kotlin("multiplatform") version kotlinVersion apply false
    kotlin("js") version kotlinVersion apply false
    kotlin("plugin.spring") version kotlinVersion apply false
}
