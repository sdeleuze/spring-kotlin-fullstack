Spring WebFlux Kotlin fullstack example with Kotlin2js for frontend instead of JavaScript or TypeScript.

Usage of [Kotlin JavaScript Dead Code Elimination tool](https://kotlinlang.org/docs/reference/javascript-dce.html)
allows to have lightweight JavaScript code generated. For this simple example, `bundle.js`
containing both application and Kotlin stdlib is 36 Kbytes uncompressed and 9 KBytes compressed.

This project leverages [Kotlin multiplatform support](http://kotlinlang.org/docs/reference/multiplatform.html)
to share code between JS and JVM using a common module.

* To run the application, use `./gradlew bootRun` or run `Application.kt` in IDEA and go to `http://localhost:8080`
* To allow live generation and reload of Kotlin frontend files while running the application run `./gradlew :frontend:build -t`
* To build application with minified JavaScript files run `./gradlew build -Pprod`

See related pending Kotlin issues (vote for them ;-):
* [KT-20156](https://youtrack.jetbrains.com/issue/KT-20156): Publish the Kotlin Javascript Gradle plugin to the Gradle Plugins Portal (in order to be able to use Gradle new plugin mechanism required for Kotlin DSL without using the workaround in `settings.gradle`)
* [KT-22635](https://youtrack.jetbrains.com/issue/KT-22635): Consider coercion to target type dynamic like our COERCION_TO_UNIT 
