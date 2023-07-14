package br.com.wti.workshop.model

import kotlin.random.Random

data class Paciente(
    val nome: String,
    val telefone: String?,
    val endereco: String? = ""
){
    val id: Long? = Random.nextLong()
}