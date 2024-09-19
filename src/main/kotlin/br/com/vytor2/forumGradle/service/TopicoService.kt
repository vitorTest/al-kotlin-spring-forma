package br.com.vytor2.forumGradle.service

import br.com.vytor2.forumGradle.dto.AtualizacaoTopicoForm
import br.com.vytor2.forumGradle.dto.NovoTopicoForm
import br.com.vytor2.forumGradle.dto.TopicoView
import br.com.vytor2.forumGradle.mapper.TopicoFormMapper
import br.com.vytor2.forumGradle.mapper.TopicoViewMapper
import br.com.vytor2.forumGradle.model.Topico
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> =  Arrays.asList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper
) {
    fun listar(): List<TopicoView> =
        topicos.stream().map {
            topicoViewMapper.map(it)
        }.collect(Collectors.toList())


    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        return TopicoView(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
    }

    fun cadastrar(form: NovoTopicoForm) {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm) {
        val topico = topicos.stream().filter { t ->
            t.id == form.id
        }.findFirst().get()

        topicos = topicos.minus(topico).plus(
            Topico(
                id = form.id,
                titulo = form.titulo,
                mensagem = form.mensagem,
                autor = topico.autor,
                curso = topico.curso,
                respostas = topico.respostas,
                status = topico.status,
                dataCriacao = topico.dataCriacao
            )
        )
    }
}
