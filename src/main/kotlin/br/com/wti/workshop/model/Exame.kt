package br.com.wti.workshop.model

import kotlin.random.Random

data class Exame(
    val codigo: String,
    val nome: String,
) {
    val id: Long? = Random.nextLong()
}