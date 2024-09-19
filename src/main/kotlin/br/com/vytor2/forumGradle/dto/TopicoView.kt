package br.com.vytor2.forumGradle.dto

import br.com.vytor2.forumGradle.model.StatusTopico
import java.time.LocalDateTime

data class TopicoView (
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime
)
