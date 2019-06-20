Spring WebFlux Kotlin fullstack example with Kotlin/JS for frontend instead of JavaScript or TypeScript.

This project leverages [Kotlin multiplatform support](http://kotlinlang.org/docs/reference/multiplatform.html)
to share code between JS and JVM using a shared module.

To run the application, use `./gradlew bootRun` or run `Application.kt` in IDEA and go to `http://localhost:8080`

TBD: 
- Usage of [Kotlin JavaScript Dead Code Elimination tool](https://kotlinlang.org/docs/reference/javascript-dce.html)
- Dev mode via `./gradlew :frontend:run -t`
