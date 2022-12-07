package kakao
import java.util.*
class KakaoMobility3 {
        lateinit var formatDateArr : Array<String>
        var startDate = listOf<String>()
        lateinit var days : TreeSet<Int>
        fun solution(s: String, times: Array<String>): IntArray {

            days = TreeSet()

            formatDateArr = Array<String>(times.size){""}

            startDate = s.split(":")
            days.add(startDate[2].toInt())

            for(i in 1..times.size){
                formatDate(times[i-1],i)
            }

            var serial = 1
            var preDay = 0
            val dayArr = days.toIntArray()
            for(curDay in dayArr){
                if(preDay == 0){
                    preDay = curDay
                    continue
                }

                if(curDay != preDay+1){
                    serial = 0
                    break
                }

                preDay = curDay

            }
            var answer = intArrayOf(serial,dayArr[dayArr.size-1] - dayArr[0] + 1)
            return answer
        }

        fun formatDate(time : String,index : Int){

            var startYear = startDate[0].toInt()
            var startMonth = startDate[1].toInt()
            var startDay = startDate[2].toInt()
            var startHour = startDate[3].toInt()
            var startMinute = startDate[4].toInt()
            var startSecond = startDate[5].toInt()

            val timeDate = time.split(":")
            val timeDay = timeDate[0].toInt()
            val timeHour = timeDate[1].toInt()
            val timeMinute = timeDate[2].toInt()
            val timeSecond = timeDate[3].toInt()


            //초
            val sumSecond = startSecond + timeSecond
            if( sumSecond >= 60){
                startMinute++
                startSecond = sumSecond - 60
            }else{
                startSecond = sumSecond
            }

            //분
            val sumMinute = startMinute + timeMinute

            if( sumMinute >= 60){
                startHour++
                startMinute = sumMinute - 60
            }else{
                startMinute = sumMinute
            }

            //시
            val sumHour = startHour + timeHour

            if( sumHour >= 24){
                startDay++
                startHour = sumHour - 24
            }else{
                startHour = sumHour
            }

            //날
            val sumDay = startDay + timeDay

            if( sumDay > 30){
                startMonth += sumDay/30
                startDay = sumDay % 30
            }else{
                startDay = sumDay
            }

            //월
            if(startMonth > 12){
                startYear++
                startMonth - 12
            }
            startDate = "$startYear $startMonth $startDay $startHour $startMinute $startSecond".split(" ")
            days.add(startDay)
        }

}