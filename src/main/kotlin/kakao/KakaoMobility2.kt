package kakao

import java.util.*

class KakaoMobility2 {

    lateinit var hs: HashSet<String>
    val hm = HashMap<String, Int>()
    fun solution(id_list: Array<String>, k: Int): Int {

        id_list.forEach { ids ->

            getSet(ids)

            for (item in hs) {
                hm[item] = hm.getOrDefault(item, 0) + 1
            }

        }

        var count = 0

        for (customer in hm) {

            if (customer.value >= k) {
                count += k
            } else {
                count += customer.value
            }
        }

        return count
    }

    fun getSet(ids: String) {

        val idList = ids.split(" ")
        hs = HashSet<String>()

        idList.forEach {
            hs.add(it)
        }


    }

}