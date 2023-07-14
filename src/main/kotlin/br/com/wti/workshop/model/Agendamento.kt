package br.com.wti.workshop.model

import java.time.LocalDate
import kotlin.random.Random

data class Agendamento(
    val data: LocalDate,
    val paciente: Paciente,
    val exame: Exame
    ) {
    val id: Long = Random.nextLong()
}