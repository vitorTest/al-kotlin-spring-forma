package br.com.vytor2.forumGradle.dto

data class NovoTopicoForm (
    val titulo: String,
    val mensagem: String,
    val idCurso: Long,
    val idAutor: Long,
    val commitTest: String
    )
