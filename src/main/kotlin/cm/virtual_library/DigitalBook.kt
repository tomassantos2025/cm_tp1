package org.example.cm.virtual_library

/*
 * Herda de Book
 *
 * Atributos:
 * fileSize (Double) -> tamanho em Mb
 * format (String) -> "PDF", "EPUB", "MOBI"
 */

class DigitalBook (
    title: String,
    author: String,
    publicationYear: Int,
    availableCopies: Int,
    val fileSize: Double,
    val format: String
) : Book(title, author, publicationYear, availableCopies) {     // chama o super()

    override fun getStorageInfo(): String {
        return "Stored digitally: $fileSize MB, Format: $format"
    }

    override fun toString(): String {
        return super.toString() + ", Storage: ${getStorageInfo()}"
    }
}