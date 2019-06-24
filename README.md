Spring WebFlux Kotlin fullstack example with Kotlin/JS for frontend instead of JavaScript or TypeScript.

This project leverages [Kotlin multiplatform support](http://kotlinlang.org/docs/reference/multiplatform.html)
to share code between JS and JVM using a shared module.

To run the application, use `./gradlew bootRun` and go to `http://localhost:8080`

TBD:
- Windows compat (will be available in Kotlin 1.3.50 see https://youtrack.jetbrains.com/issue/KT-31985)
- Usage of [Kotlin JavaScript Dead Code Elimination tool](https://kotlinlang.org/docs/reference/javascript-dce.html)
- Dev mode via `./gradlew :frontend:run -t`
- Update nstruction for running from the IDE when https://youtrack.jetbrains.com/issue/KT-24463 will be fixed 
