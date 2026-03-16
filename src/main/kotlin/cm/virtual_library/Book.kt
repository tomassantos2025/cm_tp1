package org.example.cm.virtual_library

/*
* Atributos:
* title (String)
* author (String)
* publicationYear (Int)
* availabre copies (Int)
*
* Construtores:
* Básico
*
* Getters:
* ano < 1980 -> "Classic"
* 1980 <= ano <= 2010 -> "Modern"
* ano > 2010 -> "Contempoorary"
*
* Setters:
* para availableCopies:
* impede negativos
* se for 0: "Warning: Book is now out of stock!"
*
* init:
* Quando um livro for criado deve mostrar uma frase: "Book 'title' by author has been added to the library."
*
* */


abstract class Book (
    val title: String,
    val author: String,
    val publicationYear: Int,
    availableCopies: Int    // parametros do construtor
) {
    private var _availableCopies: Int = availableCopies // variável que representa as cópias que existem de um livro

    val epoca: String
        get() = when {
            publicationYear < 1980 -> "Classic"
            publicationYear in 1980..2010 -> "Modern"
            else -> "Contemporary"
        }

    var availableCopies: Int
        get() = _availableCopies
        set(value) {
            if (value < 0) {
                println("Error: Cannot set negative copies!")
                return
            }
            if (value == 0) {
                println("Warning: Book is now out of stock!")
            }
            _availableCopies = value
        }

    // bloco que é executado cada vez que um objeto desta classe é criado
    init {
        println("Book '$title' by $author has been created.")
    }

    // cria um metodo abstrato que deve ser implementado pelas subclasses
    abstract fun getStorageInfo(): String

    // override da função implícita toString()
    override fun toString(): String {
        return "Title: $title, Author: $author, Epoca: $epoca, Available: $_availableCopies copies, Storage: ${getStorageInfo()}"
    }
}