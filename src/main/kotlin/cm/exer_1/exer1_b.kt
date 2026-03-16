package org.example.cm.exer_1

fun main() {
    var quadrados_b = (1..50).map{it -> it * it}.toIntArray()// cria um range de 1 a 50 (basicamente como um for), o map pega em cada um dos valores e substitui pelo seu quadrado; no fim em vez de devolver como Lista devolve como Array de Inteiros

    println(quadrados_b.contentToString())  // sem o contentToString ele só imprime o ponteiro para o primeiro valor do Array

}