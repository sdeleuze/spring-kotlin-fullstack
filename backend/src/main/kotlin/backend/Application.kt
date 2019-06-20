package backend

import common.User
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.http.MediaType.TEXT_EVENT_STREAM
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToServerSentEvents
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Flux
import java.net.URI
import java.time.Duration

@SpringBootApplication
class Application {

	@Bean
	fun routes() = router {
		GET("/") { permanentRedirect(URI("/index.html")).build() }
		(GET("/api/users") and accept(TEXT_EVENT_STREAM)) {
			val users = Flux.just(
					User("Foo", "Foo"),
					User("Bar", "Bar"),
					User("Baz", "Baz"))

			val userStream = Flux
					.zip(Flux.interval(Duration.ofMillis(100)), users.repeat())
					.map { it.t2 }

			ok().contentType(TEXT_EVENT_STREAM).body(userStream)
		}
	}
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}