package org.example.cm.exer_1

fun main() {
    val quadrados_a = IntArray(50) { i -> (i+1)*(i+1) }   // cria um array de ints de tamanho 50 em que cada elemento é o resultado do lambda da posição ao quadrado

    println(quadrados_a.contentToString())  // gera uma string do array e imprime
}