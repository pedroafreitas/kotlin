import com.example.models.Cliente
import com.example.models.clientesSalvos
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.rotasCliente() {
    route("/cliente") {
        get {
            if (clientesSalvos.isNotEmpty()) {
                call.respond(clientesSalvos)
            } else {
                call.respondText("Sem clientes cadastrados", status = HttpStatusCode.NotFound)
            }
        }

        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Erro no parâmetro da chamada",
                status = HttpStatusCode.NotFound
            )
            val cliente =
                clientesSalvos.find { it.id == id } ?: return@get call.respondText(
                    "Cliente não encontrado com id $id",
                    status = HttpStatusCode.NotFound
                )
            call.respond(cliente)
        }

        post {
            val cliente = call.receive<Cliente>()
            clientesSalvos.add(cliente)
            call.respondText("Cliente cadastrado", status = HttpStatusCode.Created)
        }

        delete("{id?}")
        {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            if (clientesSalvos.removeIf { it.id == id }) {
                call.respondText("Cliente removido", status = HttpStatusCode.Accepted)
            } else {
                call.respondText(
                    "Cliente não encontrado com id $id",
                    status = HttpStatusCode.NotFound
                )
            }
        }
    }
}