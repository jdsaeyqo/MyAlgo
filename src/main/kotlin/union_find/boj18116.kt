package union_find

import java.lang.StringBuilder
import java.util.StringTokenizer

class boj18116 {
    lateinit var parent: IntArray
    lateinit var size: IntArray

    fun sol() {

        val N = readLine()!!.toInt()
        var st: StringTokenizer

        parent = IntArray(1000001) { it }
        size = IntArray(1000001) { 1 }


        val sb = StringBuilder()
        repeat(N) {
            st = StringTokenizer(readLine())

            val command = st.nextToken()

            when (command) {
                "I" -> {
                    val a = st.nextToken().toInt()
                    val b = st.nextToken().toInt()
                    union(a, b)
                }

                "Q" -> {
                    val c = st.nextToken().toInt()
                    sb.append(size[find(c)]).append("\n")
                }
            }
        }

        println(sb.toString())
    }

    fun union(a: Int, b: Int) {

        val x = find(a)
        val y = find(b)

        if (x == y) {
            return
        }

        if (x < y) {
            parent[y] = x
            size[x] += size[y]

        } else {
            parent[x] = y
            size[y] += size[x]

        }
    }

    fun find(x: Int): Int {

        return if (x == parent[x]) {
            x
        } else {
            parent[x] = find(parent[x])
            parent[x]
        }

    }
}

fun main() {
    boj18116().sol()
}