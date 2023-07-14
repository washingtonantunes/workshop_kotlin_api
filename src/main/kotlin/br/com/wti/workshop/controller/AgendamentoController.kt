package br.com.wti.workshop.controller

import br.com.wti.workshop.service.AgendamentoService
import br.com.wti.workshop.exceptions.InvalidAgendamentoException
import br.com.wti.workshop.model.Agendamento
import br.com.wti.workshop.model.Paciente
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/agendamento")
class AgendamentoController(
    private val service: AgendamentoService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criaAgendamento(@RequestBody agendamento: Agendamento): ResponseEntity<Any> {
        try {
            val agendamento = service.criAgendamento(agendamento)
            return ResponseEntity.ok(agendamento)
        } catch (ex: InvalidAgendamentoException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.message)
        }
    }

    @GetMapping("/buscar-data/{data}")
    @ResponseStatus(HttpStatus.OK)
    fun buscarAgendamentoPorData(@PathVariable data: String): List<Agendamento?> {
        return service.buscarPorData(LocalDate.parse(data))
    }

    @GetMapping("/buscar-paciente/{nome}")
    @ResponseStatus(HttpStatus.OK)
    fun buscarAgendamentoPorPaciente(@PathVariable nome: String): List<Agendamento?> {
        return service.buscarPorPaciente(nome)
    }

    @GetMapping("/teste-if/{teste}")
    @ResponseStatus(HttpStatus.OK)
    fun buscarAgendamento(@PathVariable teste: String): List<Agendamento?> {
        val testeIf = if(teste == "data") {
            service.buscarPorData(LocalDate.now())
        } else {
            service.buscarPorPaciente("Washington Antunes")
        }
        return testeIf
    }

    @GetMapping("/teste-referencia")
    @ResponseStatus(HttpStatus.OK)
    fun buscarReferencia() {
        val a = Paciente(nome="Pedro Aguiar", telefone = "1197251-6399")
        val b = a

        if (a === b) {
            println("São iguais")
        }
    }
}