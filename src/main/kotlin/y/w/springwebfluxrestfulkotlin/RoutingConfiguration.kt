package y.w.springwebfluxrestfulkotlin

import org.springframework.context.annotation.*
import org.springframework.web.reactive.function.server.*

@Configuration
class RoutingConfiguration constructor(val bookHandler: BookHandler) {
    @Bean
    fun apiRouteTree() = router {
        ("/api").nest {
            (GET("") or GET("/hello")) { _ -> ServerResponse.ok().bodyValue("Hell World") }
            GET("/math") {
                ServerResponse.ok().bodyValue("math")
            }
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