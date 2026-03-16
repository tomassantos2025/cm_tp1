package org.example.cm.virtual_library

data class LibraryMember(   // auto gera toString(), equals(), copy()
    val name: String,   // nome
    val membershipId: String,   // id
    val borrowedBooks: MutableList<String> = mutableListOf()    // lista com titulos dos livros que tem
) {
    fun addBorrowedBook(title: String) {    // função para adicionar o livro que levou
        borrowedBooks.add(title)    // adiciona à sua lista o titulo do livro
        println("$name borrowed '$title'")
    }

    fun removeBorrowedBook(title: String) { // função para devolver o livro que tinha levado
        if (borrowedBooks.remove(title)) {  // se conseguir devolver o livro
            println("$name returned '$title'")
        }
    }

    fun showBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {  // caso não tenha nenhum livro
            println("$name has no borrowed books.")
        } else {    // caso tenha algum livro
            println("$name's borrowed books:")
            borrowedBooks.forEach { println("  - $it") }    // imprime uma lista desordenada
        }
    }
}