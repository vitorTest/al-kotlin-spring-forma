fun main() {


    for (i in 100 downTo 0 step 20) {

        if (i == 80) {
            continue
        }

        if (i == 40) {
            break
        }

        val titular: String = "Vitor $i"
        val numeroConta: Int = 1000 + i
        var saldo: Double = 0.0 + i

        saldo += 2.0
        saldo -= 500

        println("titular $titular")
        println("numeroConta $numeroConta")
        println("saldo $saldo")
        println()
    }

//    testaCondicoes(saldo)

}

fun testaCondicoes(saldo: Double) {
    when {
        saldo > 0.0 -> println("saldo positivo")
        saldo == 0.0 -> println("saldo neutro")
        else -> println("saldo negativo")
    }
}