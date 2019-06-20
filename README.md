Spring WebFlux Kotlin fullstack example with Kotlin/JS for frontend instead of JavaScript or TypeScript.

This project leverages [Kotlin multiplatform support](http://kotlinlang.org/docs/reference/multiplatform.html)
to share code between JS and JVM using a common module.

* To run the application, use `./gradlew bootRun` or run `Application.kt` in IDEA and go to `http://localhost:8080`
* To allow live generation and reload of Kotlin frontend files while running the application run `./gradlew :frontend:run -t`

TBD: 
Usage of [Kotlin JavaScript Dead Code Elimination tool](https://kotlinlang.org/docs/reference/javascript-dce.html)
allows to have lightweight JavaScript code generated. For this simple example, `bundle.js`
containing both application and Kotlin stdlib is 36 Kbytes uncompressed and 9 KBytes compressed.

* To build application with minified JavaScript files run `./gradlew build -Pprod`

See related pending Kotlin issues (vote for them ;-):
* TBD 
