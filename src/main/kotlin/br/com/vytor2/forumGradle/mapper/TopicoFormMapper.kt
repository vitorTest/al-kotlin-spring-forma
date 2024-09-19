package br.com.vytor2.forumGradle.mapper

import br.com.vytor2.forumGradle.dto.NovoTopicoForm
import br.com.vytor2.forumGradle.model.Topico
import br.com.vytor2.forumGradle.service.CursoService
import br.com.vytor2.forumGradle.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
) : Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm) =
        Topico(
//            id = topicos.size.toLong() + 1,
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
}
