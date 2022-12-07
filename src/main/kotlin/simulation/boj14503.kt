package simulation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class boj14503 {

    var N = 0
    var M = 0
    var cnt = 0
    lateinit var map: Array<IntArray>
    lateinit var visited: Array<BooleanArray>
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    fun sol() {

        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())

        N = st.nextToken().toInt()
        M = st.nextToken().toInt()

        map = Array(N) { IntArray(M) }
        visited = Array(N) { BooleanArray(M) }

        st = StringTokenizer(br.readLine())

        val r = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        val d = st.nextToken().toInt()

        for (i in 0 until N) {
            st = StringTokenizer(br.readLine())
            for (j in 0 until M) {
                map[i][j] = st.nextToken().toInt()
            }
        }

        clean(r, c, d)
        println(cnt)

    }

    fun clean(x: Int, y: Int, dir: Int) {

        if (!visited[x][y]) {
            visited[x][y] = true
            cnt++
            map[x][y] = 2
        }

        var d = dir
        var flag = false
        for (i in 0 until 4) {

            d--
            if (d < 0) {
                d = 3
            }

            val nx = x + dx[d]
            val ny = y + dy[d]

            if (nx in 0 until N && ny in 0 until M) {
                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    clean(nx, ny, d)
                    flag = true
                    break
                }
            }

        }

        if (!flag) {

            var tmp = dir

            tmp -= 2
            if (tmp < 0) {
                tmp += 4
            }

            val nx = x + dx[tmp]
            val ny = y + dy[tmp]

            if (nx in 0 until N && ny in 0 until M) {
                if (map[nx][ny] != 1) {
                    clean(nx, ny, d)
                }


            }

        }

    }
}

fun main() {
    boj14503().sol()
}