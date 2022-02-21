package y.w.springwebfluxrestfulkotlin

import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.*
import org.springframework.boot.test.context.*
import org.springframework.test.context.junit.jupiter.*

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringWebfluxRestfulKotlinApplicationTests {
    @Test
    fun contextLoads() {
    }
}
