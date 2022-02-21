package y.w.springwebfluxrestfulkotlin

import org.springframework.context.annotation.*
import org.springframework.http.*
import org.springframework.web.reactive.function.server.*

@Configuration
class RoutingConfiguration constructor(val bookHandler: BookHandler) {
    @Bean
    fun apiRouteTree() = router {
        ("/api").nest {
            (GET("") or GET("/hello")) { _ -> ServerResponse.ok().bodyValue("Hello World") }

            accept(MediaType.APPLICATION_JSON).nest {
                GET("/math") {
                    ServerResponse.ok().bodyValue("math")
                }
            }

            accept(MediaType.APPLICATION_JSON).nest {
                ("/book").nest {
                    GET("") { bookHandler.getAllBooks() }
                    GET("/{id}") {
                        val id = it.pathVariable("id")
                        bookHandler.getBookById(id)
                    }
                }
            }
        }
    }
}