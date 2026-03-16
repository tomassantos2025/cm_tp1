package org.example.cm.exer_3

// Bola começa nos 100 metros
// A cada salto alcança 60% da altura anterior
// usar generateSequence para modelar os saltos
// pegar nos 15 primeiros saltos e ordenar numa lista; apenas saltos com pelo menos 1 metro de altura

fun main() {
    val listaSaltos = generateSequence(100.0) { anterior -> anterior * 0.6 }
        .take(15)   // pega apenas os primeiros 15 saltos
        .filter { it >= 1.0 }   // filtra apenas saltos com mais de 1 metro
        .toList()   // devolve em forma de Lista

    listaSaltos.forEach { println(String.format("%.2f", it)) }
}