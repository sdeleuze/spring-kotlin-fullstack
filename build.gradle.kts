allprojects {
    group = "io.spring"
    version = "1.0.0-SNAPSHOT"
}

plugins {
    base
}

dependencies {
    // Make the root project archives configuration depend on every subproject
    subprojects.forEach {
        archives(it)
    }
}