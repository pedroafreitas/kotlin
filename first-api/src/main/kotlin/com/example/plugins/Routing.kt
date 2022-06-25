package com.example.plugins

import com.example.routes.getPedidoRoute
import com.example.routes.getValorTotalPedidoRoute
import com.example.routes.listarPedidosRota
import com.example.routes.postCriarPedido
import io.ktor.server.application.*
import io.ktor.server.routing.*
import rotasCliente

fun Application.configureRouting() {
    routing {
        rotasCliente()
        listarPedidosRota()
        getPedidoRoute()
        getValorTotalPedidoRoute()
        postCriarPedido()
    }
}
