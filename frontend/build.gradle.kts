import com.moowork.gradle.node.npm.NpmTask
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

plugins {
    id("com.moowork.node") version "1.2.0"
    id("kotlin2js") version "1.1.51"
    id("kotlin-dce-js") version "1.1.51"
}

repositories {
    mavenCentral()
    maven("http://dl.bintray.com/kotlin/kotlin-eap-1.2")
}

node {
    download = true
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-js:1.1.51")
}

tasks.withType<Kotlin2JsCompile> {
    kotlinOptions {
        moduleKind = "umd"
    }
}

task<NpmTask>("buildBundle") {
    dependsOn("npmInstall", "runDceKotlinJs")
    inputs.dir("src/main/kotlin")
    outputs.dir("../backend/src/main/resources/static")
    setArgs(listOf("run", "bundle"))
}

tasks.getByName("assemble").dependsOn("buildBundle")
