package y.w.springwebfluxrestfulkotlin

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.*
import org.springframework.boot.test.context.SpringBootTest.*
import org.springframework.http.MediaType.*
import org.springframework.test.context.junit.jupiter.*
import org.springframework.test.web.reactive.server.*

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class IntegrationTest {
    @Autowired
    private lateinit var webTestClient: WebTestClient

    @Test
    fun `Test Hello World Service`() {
        val expectBody = webTestClient.get()
            .uri("/api/hello")
            .accept(APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk()
            .expectBody(String::class.java)
            .value {
                assertThat(it).contains("Hello World")
            }
    }
}