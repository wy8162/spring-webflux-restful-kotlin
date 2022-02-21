package y.w.springwebfluxrestfulkotlin

import org.springframework.http.*
import org.springframework.stereotype.*
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.*

@Component
class BookHandler constructor(val bookService: BookService) {
    fun getAllBooks(): Mono<ServerResponse> = ServerResponse
        .ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromPublisher(bookService.getAllBooks(), Book::class.java))

    fun getBookById(id: String): Mono<ServerResponse> = ServerResponse
        .ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromPublisher(bookService.getBookById(id), Book::class.java))
}