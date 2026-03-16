package org.example.cm.virtual_library

/*
* Herda de Book
*
* Atributos:
* weight (Int) -> peso em gramas
* hasHardCover (Boolean) -> (por default é true) */

class PhysicalBook(
    title: String,
    author: String,
    publicationYear: Int,
    availableCopies: Int,
    val weight: Int,
    val hasHardCover: Boolean
) : Book(title, author, publicationYear, availableCopies){  // chama super()

    override fun getStorageInfo(): String {
        val hardcover = if (hasHardCover) "Yes" else "No"
        return "Physical book: ${weight}g, Hardcover: $hardcover"
    }

    override fun toString(): String {
        return super.toString() + ", Storage: ${getStorageInfo()}"
    }
}