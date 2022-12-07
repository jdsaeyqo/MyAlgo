package greedy

class boj14916 {
    fun sol() {

        val N = readLine()!!.toInt()

        val money = IntArray(100001) { Integer.MAX_VALUE }

        money[0] = 0


        for (i in 1 until money.size) {


            if (i - 5 >= 0 && money[i - 5] != Integer.MAX_VALUE) {
                money[i] = money[i].coerceAtMost(money[i - 5] + 1)
            }

            if (i - 2 >= 0 && money[i - 2] != Integer.MAX_VALUE) {
                money[i] = money[i].coerceAtMost(money[i - 2] + 1)
            }


        }

        println(if (money[N] == Integer.MAX_VALUE) -1 else money[N])
    }
}

fun main() {
    boj14916().sol()
}