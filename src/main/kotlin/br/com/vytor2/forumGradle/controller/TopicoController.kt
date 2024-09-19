package br.com.vytor2.forumGradle.controller

import br.com.vytor2.forumGradle.dto.AtualizacaoTopicoForm
import br.com.vytor2.forumGradle.dto.NovoTopicoForm
import br.com.vytor2.forumGradle.dto.TopicoView
import br.com.vytor2.forumGradle.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(
    private val service: TopicoService
) {

    @GetMapping
    fun listar(): List<TopicoView> = service.listar()

    @GetMapping("/{id}")
    fun buscarPorId(
        @PathVariable id: Long
    ): TopicoView = service.buscarPorId(id)

    @PostMapping
    fun cadastrar(
        @RequestBody @Valid dto: NovoTopicoForm
    ) = service.cadastrar(dto)

    @PutMapping
    fun atualizar(
        @RequestBody @Valid dto: AtualizacaoTopicoForm
    ) = service.atualizar(dto)
}
