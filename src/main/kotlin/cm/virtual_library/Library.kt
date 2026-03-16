package org.example.cm.virtual_library

/*
* Tem como objetivo gerir a coleção de livros
* Métodos:
* addBook(book: Book) -> adiciona um livro à lista
* borrowBook(title: String) -> empresta um livro
* procura pelo título, se encontrar cópias disponíveis -> diminui available copies 1 vez, imprime sucesso ou falha
* returnBook(title: String) -> devolve um livro
* procura pelo título, se encontrar -> aumenta availableCopies 1 vez
* Imprime se correr tudo bem
* showBooks() -> lista todos os livros com as suas informações
* searchByAuthor(author: String) -> lista os livros de um determinado author
*
*
* */

class Library (
    val name: String    // recebe parametro
){
    private val books: MutableList<Book> = mutableListOf()  // cria uma lista que apenas s epode alterar o conteúdo da lista

    // como static em Java
    companion object {
        private var totalBooksAdded = 0

        fun getTotalBooksCreated(): Int {   // getter do total de livros
            return totalBooksAdded
        }
    }

    init {  // bloco executado quando se cria um objeto
        println("Library '$name' has been created.")
    }

    fun addBook(book: Book) {   // função de adicionar um livro à biblioteca
        books.add(book)     // adiciona o livro à lista
        Library.totalBooksAdded++   // aumenta o total de livros
        println("Book'${book.title}' has been added to the library.")
    }

    fun borrowBook(title: String) {
        val book = books.find { it.title == title }     // procura um livro na biblioteca pelo titulo

        if (book == null) { // se o titulo não for encontrado
            println("Book '$title' not found in the library.")
            return
        }

        if (book.availableCopies <= 0) {    // caso não haja esse livro disponível de momento
            println("Sorry, '$title' is not available for borrowing.")
            return
        }

        book.availableCopies--  // se foi encontrado e existe cópia para emprestar
        println("Successfully borrowed '$title'. Copies remaining: ${book.availableCopies}")
    }

    fun returnBook(title: String) {     // devolver um livro à biblioteca
        val book = books.find { it.title == title }     // procura se esse livro existe na biblioteca

        if (book == null) { // se esse livro não for encontrado na lista
            println("Book '$title' not found in the library.")
            return
        }

        book.availableCopies++  // caso o livro exista na coleção, adiciona mais uma cópia
        println("Book '$title' returned successfully. Copies available: ${book.availableCopies}")
    }

    fun showBooks() {
        if (books.isEmpty()) {  // se a lista de livros estiver vazia
            println("No books in the library.")
            return
        }

        println("--- Library Catalog ---")
        books.forEach { book ->     // para cada livro na lista,
            println(book.toString())    // imprime as informações do livro
        }
    }

    fun searchByAuthor(author: String) {    // procura os livros de um autor
        val authorBooks = books.filter { it.author == author }  // da lista de livros vai pegar apenas os que forem do autor

        if (authorBooks.isEmpty()) {    // se não encontrar nenhum livro desse autor
            println("No books by $author found in the library.")
            return
        }

        println("Books by $author:")
        authorBooks.forEach { book ->   // para cada livro encontrado do autor, imprime as informações de cada livro
            println("- ${book.title} (${book.epoca}, ${book.availableCopies} copy/copies available)")
        }
    }

}