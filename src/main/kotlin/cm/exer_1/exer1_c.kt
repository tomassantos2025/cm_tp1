package org.example.cm.exer_1

fun main() {
    val quadrados_c = Array(50) { i -> (i+1)*(i+1) }    // cria um array do objeto Int de tamanho 50 em que cada elemento é o resultado do lambda da posição ao quadrado

    println(quadrados_c.contentToString())      // sem o contentToString ele só imprime o endereço de memória do Array
}