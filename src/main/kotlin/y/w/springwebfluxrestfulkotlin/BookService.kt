package y.w.springwebfluxrestfulkotlin

import org.springframework.stereotype.Component
import reactor.core.publisher.*

data class Book(val id: String, val name: String, val qty: Int)

val bookStore = mutableMapOf<String, Book>(
    "001" to Book("001", "Harry Porter", 3),
    "002" to Book("002", "Twin Cities", 7),
    "003" to Book("003", "Old Man and Sea", 21),
    "004" to Book("004", "War and Peace", 11),
    "005" to Book("005", "Seven Habits of Successful People", 3)
)

@Component
class BookService {
    fun getAllBooks(): Flux<Book> = Flux.fromIterable(bookStore.values.stream().toList())

    fun getBookById(id: String): Mono<Book> = when(bookStore.containsKey(id)) {
        true -> Mono.just(bookStore[id]!!)
        else -> Mono.empty()
    }
}