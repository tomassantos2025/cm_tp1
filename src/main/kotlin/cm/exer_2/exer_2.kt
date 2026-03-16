package org.example.cm.exer_2

import java.text.NumberFormat

fun Double.toHex(): String = java.lang.Double.toHexString(this)     // devolve o valor hexadecimal do Double em forma de String

fun main() {
    println("=====Calculadora em Kotlin=====")

    while (true) {

        try {
            println("Menu: ")
            println("1 -> Soma")
            println("2 -> Subtração")
            println("3 -> Multiplicação")
            println("4 -> Divisão")
            println("5 -> AND (&&)")
            println("6 -> OR (||)")
            println("7 -> NOT (!)")
            println("8 -> Left shift")
            println("9 -> Right shift")
            println("0 -> Exit")

            print("\nEscolha uma opção: ")
            var opcao = readln().toInt()        // lê o que foi escrito na linha toda e converte em int

            var resultado = when (opcao) {
                1, 2, 3, 4 -> {
                    print("Digite o primeiro número: ")
                    val a = readln().toDouble()     // pede o primeiro valor e devolve double primitivo
                    print("Digite o segundo número: ")
                    val b = readln().toDouble()     // pede o segundo valor e devolve double primitivo

                    val resultado = when(opcao) {
                        1 -> a + b      // se a opcao for 1 retorna isto
                        2 -> a - b      // se a opcao for 2 retorna isto
                        3 -> a * b      // se a opcao for 3 retorna isto
                        4 -> {      // se a opcao for 4 retorna isto
                            if (b == 0.0) throw ArithmeticException("Divisão por 0")    // caso o valor do denominador seja 0 lança exceção
                            a / b
                        }
                        else -> 0.0     // nunca chega aqui, mas por boa prática considerar a possibilidade
                    }

                    println("---Resultados---")
                    println("Decimal: ${String.format("%.2f", resultado)}")     // representa uma string e formata a String de forma a mostrar o resultado com 2 casas decimais
                    println("Hexadecimal: ${resultado.toHex()}")    // chama a função que converte Doubles em String na representação Hexadecimal
                    println("Boolean: ${resultado != 0.0}")     // caso o resultado seja 0 mostra false, senão mostra true
                }

                5, 6 -> {
                    print("Digite o primeiro booleano (true/false): ")
                    var a = readln().toBoolean()    // lê o bool

                    print("Digite o segundo booleano (true/false): ")
                    var b = readln().toBoolean()    // lê o bool

                    var resultado = when(opcao) {
                        5 -> a && b     // faz a operação AND
                        6 -> a || b     // faz a operação OR
                        else -> false   // nunca chega aqui, mas por boa prática considerar
                    }
                    println("---Resultados---")
                    println("Boolean: $resultado")  // objetivo: mostrar o booleano
                    println("Decimal: ${ if (resultado) 1.0 else 0 }")  // se for true mostra 1, se forfalse mostra 0
                    println("Hexadecimal: ${ if (resultado) 1.0 else 0}")   // mesmo conceito que decimal porque um bool não passa do 9
                }
                7 -> {
                    print("Digite o primeiro booleano (true/false): ")
                    var a = readln().toBoolean()

                    var resultado = !a

                    println("Booleano: $resultado")
                    println("Decimal: ${if (resultado) 1 else 0}")
                    println("Hexadecimal: ${if (resultado) 1 else 0}")
                }
                8, 9 -> {
                    println("Digite o número inteiro: ")
                    var a = readln().toInt()    // pede o número que vai ser empurrado os bits

                    println("Digite quantas casas quer empurrar: ")
                    var b = readln().toInt()    // lê quantas casas vai ter de empurrar

                    var resultado = when(opcao) {
                        8 -> a shl b    // pega nos bits de a e empurra para a esquerda b vezes
                        9 -> a shr b    // pega nos bits de a e empurra para a direita b vezes
                        else -> 0   // boas práticas
                    }

                    println("---Resultado---")
                    println("Decimal: ${resultado}")
                    println("Hexadecimal: ${resultado.toDouble().toHex()}")     // necessário passar para Double para usar a função de passar para hexadecimal
                    println("Booleano: ${(resultado != 0)}")
                }
                0 -> return // retorna a main e sai do programa
                else -> println("Opção inválida")
            }
        } catch (e: NumberFormatException) {    // quando o user escrever algum valor não numérico
            println("Erro: input de número inválido")
        } catch (e: ArithmeticException) {
            println("Erro: operação inválida")
        } catch (e: Exception) {
            println("Erro: ${e.message}")   // mostra o erro que deu caso não tenha sido nenhum dos acima
        }
    }
}