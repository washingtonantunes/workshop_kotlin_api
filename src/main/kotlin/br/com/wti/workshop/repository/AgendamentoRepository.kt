package br.com.wti.workshop.repository

import br.com.wti.workshop.model.Agendamento
import br.com.wti.workshop.model.Exame
import br.com.wti.workshop.model.Paciente
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class AgendamentoRepository {

    companion object {
        private val agendamentos = mutableListOf<Agendamento>()
    }

    init {
        agendamentos.add(
            Agendamento(
                LocalDate.of(2023, 7, 13),
                Paciente(nome="João Carlos", telefone = null),
                Exame(codigo = "HC1", nome = "Hemograma Completo"),
            )
        )

        agendamentos.add(
            Agendamento(
                LocalDate.of(2023, 6, 10),
                Paciente(nome="Igor Ramos", telefone = null),
                Exame(codigo = "C2", nome = "Colesterol"),
            )
        )

        agendamentos.add(
            Agendamento(
                LocalDate.of(2023, 6, 10),
                Paciente(nome="Pedro Aguiar", telefone = "1197251-6399"),
                Exame(codigo = "G2", nome = "Glicemia"),
            )
        )

        agendamentos.add(
            Agendamento(
                LocalDate.of(2023, 6, 10),
                Paciente(nome="Pedro Aguiar", telefone = "1197251-6399", endereco = "Rua do Pedro"),
                Exame(codigo = "C2", nome = "Colesterol"),
            )
        )
    }

    fun adiciona(agendamento: Agendamento):Agendamento {
        agendamentos.add(agendamento)

        return agendamento
    }

    fun buscaPorPaciente(nome: String): List<Agendamento> {
        return agendamentos.filter { it.paciente.nome == nome }
    }

    fun buscaPorData(data: LocalDate) = agendamentos.filter { it.data == data }
}