package br.com.vytor2.forumGradle.mapper

import br.com.vytor2.forumGradle.dto.TopicoView
import br.com.vytor2.forumGradle.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper : Mapper<Topico, TopicoView> {
    override fun map(t: Topico) =
        TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            status = t.status,
            dataCriacao = t.dataCriacao
        )
}
