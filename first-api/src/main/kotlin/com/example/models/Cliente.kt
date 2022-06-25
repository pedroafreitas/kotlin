package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Cliente(val id: String, val nome: String, val sobrenome: String, val email: String)

val clientesSalvos = mutableListOf<Cliente>()