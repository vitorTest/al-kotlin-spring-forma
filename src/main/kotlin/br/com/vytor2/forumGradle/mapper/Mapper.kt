package br.com.vytor2.forumGradle.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}
