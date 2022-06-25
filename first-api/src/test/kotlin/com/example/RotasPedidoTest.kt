import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.Test
import kotlin.test.assertEquals

class RotasPedidoTest {
    @Test
    fun deveGetPedido() = testApplication {
        val response = client.get("/pedido/2")
        assertEquals(
            """{"id":2,"data":"2022-06-25 12:58:23","itens":[{"nome":"Arroz","quantidade":3,"preco":55.0},{"nome":"Feijão","quantidade":2,"preco":20.0}]}""",
            response.bodyAsText()
        )
        assertEquals(HttpStatusCode.OK, response.status)
    }
}
