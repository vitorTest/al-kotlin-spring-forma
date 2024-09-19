package br.com.vytor2.forumGradle.service

import br.com.vytor2.forumGradle.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(var usuarios: List<Usuario>) {
    init{
        val usuario = Usuario(
            id = 1,
            nome = "Ana da Silva",
            email = "ana@email.com"
        )

        usuarios = Arrays.asList(usuario)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream().filter{
                u -> u.id == id
        }.findFirst().get()
    }
}
