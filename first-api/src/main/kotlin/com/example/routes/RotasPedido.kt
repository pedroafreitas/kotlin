package com.example.routes

import com.example.models.Pedido
import com.example.models.pedidosSalvos
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.listarPedidosRota() {
    get("/pedido") {
        if (pedidosSalvos.isNotEmpty()) {
            call.respond(pedidosSalvos)
        }
    }
}

fun Route.getPedidoRoute() {
    get("/pedido/{id?}") {
        val id = call.parameters["id"] ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)
        val pedido = pedidosSalvos.find { it.id == id.toIntOrNull() } ?: return@get call.respondText(
            "Not Found",
            status = HttpStatusCode.NotFound
        )
        call.respond(pedido)
    }
}

fun Route.getValorTotalPedidoRoute() {
    get("/pedido/{id?}/valor-total") {
        val id = call.parameters["id"] ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)
        val pedido = pedidosSalvos.find { it.id == id.toIntOrNull() } ?: return@get call.respondText(
            "Not Found",
            status = HttpStatusCode.NotFound
        )
        val total = pedido.itens.sumOf { it.preco * it.quantidade }
        call.respond(total)
    }
}

fun Route.postCriarPedido() {
    post("/pedido/criar-pedido") {
        val pedido = call.receive<Pedido>()
        pedidosSalvos.add(pedido)
        call.respondText("Pedido adicionado", status = HttpStatusCode.Created)
    }
}

