package binary_search

class boj1300 {
    var N = 0L
    var k = 0L
    fun sol() {
        N = readLine()!!.toLong()
        k = readLine()!!.toLong()

        var s : Long = 1
        var e  : Long = N * N
        var ans = 0L
        while (s <= e) {
            val mid = (s + e) / 2

            if (check(mid)) {
                ans = mid
                e = mid - 1
            } else {
                s = mid + 1
            }
        }
        println(ans)
    }

    fun check(mid: Long): Boolean {
        var total = 0L
        for (i in 1..N) {
            total += Math.min(N, mid / i)
        }
        return total >= k
    }
}

fun main() {
    boj1300().sol()
}