package swea

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class swea1767{
    var N = 0
    var M = 0
    lateinit var map : Array<IntArray>
    fun sol(){
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())

        N = st.nextToken().toInt()
        map = Array(N){IntArray(N)}

        st = StringTokenizer(br.readLine())
        M = st.nextToken().toInt()


    }
}
fun main(){

    swea1767().sol()


}