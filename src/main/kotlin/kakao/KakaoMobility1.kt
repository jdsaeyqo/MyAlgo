package kakao


class KakaoMobility1 {
    fun solution(flowers: Array<IntArray>): Int {

        val dayArr = IntArray(366)

        flowers.forEach { flower ->

            val startDate = flower[0]
            val finishDate = flower[1]

            for (i in startDate until finishDate) {
                dayArr[i]++
            }
        }

        var count = 0

        dayArr.forEach {
            if (it > 0) {
                count++
            }
        }

        return count
    }
}
