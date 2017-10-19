buildscript {
    repositories {
        maven("http://dl.bintray.com/kotlin/kotlin-eap-1.2")
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.2.0-beta-88")
    }
}

apply {
    plugin("kotlin-platform-common")
}


repositories {
    maven("http://dl.bintray.com/kotlin/kotlin-eap-1.2")
}

dependencies {
    "compile"("org.jetbrains.kotlin:kotlin-stdlib-common")
}
