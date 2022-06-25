package com.example.models

import kotlinx.serialization.Serializable
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Serializable
data class Pedido(val id: Int, val data: String, val itens: List<Item>)

@Serializable
data class Item(val nome: String, val quantidade: Int, val preco: Double)

val formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

val pedidosSalvos = mutableListOf(
    Pedido(
        1, LocalDateTime.now().format(formato),
        mutableListOf(
            Item("Queijo", 3, 15.00),
            Item("Presunto", 5, 20.00),
            Item("Pão", 10, 9.25),
            Item("Manteiga", 1, 10.0),
            Item("Suco de laranja", 1, 8.50)
        )
    ),
    Pedido(
        2, "2022-06-25 12:58:23",
        mutableListOf(
            Item("Arroz", 3, 55.00),
            Item("Feijão", 2, 20.00)
        )
    )
)
