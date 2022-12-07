package binary_search

import java.util.StringTokenizer

class boj1637 {

    lateinit var arr: Array<LongArray>

    fun sol() {
        val N = readLine()!!.toInt()
        arr = Array(3) { LongArray(N) }

        var max = -1L
        var min = Long.MAX_VALUE
        for (i in 0 until N) {
            val st = StringTokenizer(readLine())
            arr[0][i] = st.nextToken().toLong()
            min = Math.min(arr[0][i], min)
            arr[1][i] = st.nextToken().toLong()
            max = Math.max(arr[1][i], max)
            arr[2][i] = st.nextToken().toLong()
        }
        max++

        var s = min
        var e = max

        while (s <= e) {
            val mid = (s + e) / 2

            if (check(mid) % 2 == 0L) {
                s = mid + 1
            } else {
                e = mid - 1
            }
        }

        if (s == max) {
            println("NOTHING")
        } else {
            println("$s ${check(s) - check(s - 1)}")
        }
    }

    fun check(mid: Long): Long {

        var sum = 0L
        for (i in arr.indices) {
            val a = arr[0][i]
            val c = arr[1][i]
            val b = arr[2][i]

            if (mid < a) {
                continue
            }

            sum += Math.min(mid, c - a) / b
            sum++
        }

        return sum


    }
}

fun main() {
    boj1637().sol()
}