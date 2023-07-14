package br.com.wti.workshop.service

import br.com.wti.workshop.exceptions.InvalidAgendamentoException
import br.com.wti.workshop.model.Agendamento
import br.com.wti.workshop.repository.AgendamentoRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class AgendamentoService(
    val repository: AgendamentoRepository
) {
    fun criAgendamento(agendamento: Agendamento): Agendamento {
        val data = agendamento.data
        val datas = this.buscarPorData(data)

        if(datas.any()) {
            throw InvalidAgendamentoException("Data já possue agendamento")
        }


        return repository.adiciona(agendamento)
    }

    fun buscarPorPaciente(nome: String): List<Agendamento> {
        return repository.buscaPorPaciente(nome)
    }

    fun buscarPorData(data: LocalDate) = repository.buscaPorData(data)
}