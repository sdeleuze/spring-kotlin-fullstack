package backend

import common.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.http.MediaType.TEXT_EVENT_STREAM
import org.springframework.web.reactive.config.ResourceHandlerRegistry
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.function.server.*
import java.net.URI

@SpringBootApplication
class Application: WebFluxConfigurer {

	private val users = listOf(
			User("Foo", "Foo"),
			User("Bar", "Bar"),
			User("Baz", "Baz"))

	@Bean
	fun routes() = coRouter {
		GET("/") { permanentRedirect(URI("/index.html")).buildAndAwait() }
		(GET("/api/users") and accept(TEXT_EVENT_STREAM)) {
			ok().sse().bodyAndAwait(flow<User> {
				while(true) {
					delay(100)
					emit(users.random())
				}
			})
		}
	}

	override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
		registry.addResourceHandler("**.wasm").addResourceLocations("classpath:/static/")
			.setMediaTypes(mapOf("wasm" to MediaType.valueOf("application/wasm")))
	}
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}