package iii_conventions

import util.TODO
import iii_conventions.TimeInterval.*

fun todoTask29(): Nothing = TODO(
    """
        Task 29.
        Implement a kind of date arithmetic. Support adding years, weeks and days to a date.
        Use classes MyDate and TimeInterval.
        Use a utility function MyDate.addTimeIntervals.
        Uncomment the commented line and make it compile.

        (1). Add an extension function 'plus()' to MyDate, taking a TimeInterval as an argument.
        (2). Support adding several time intervals to a date. Add an extra class.
        If you have any problems, see the iii_conventions/_29_Tips.kt file.
    """,
    references = { date: MyDate, timeInterval: TimeInterval ->
        date.addTimeIntervals(timeInterval, 1)
    })

operator fun MyDate.plus( interval:TimeInterval):MyDate{
    if (interval == YEAR)
        return this.addTimeIntervals(YEAR,1)
    else if (interval == WEEK) {
        return this.addTimeIntervals(WEEK,1)
    }else if (interval == DAY){
        return this.addTimeIntervals(DAY,1)
    }
    return this

}
operator fun MyDate.plus( rti:RepeatedTimeInterval):MyDate{
    if (rti.ti == YEAR)
        return this.addTimeIntervals(YEAR,rti.n)
    else if (rti.ti == WEEK) {
        return this.addTimeIntervals(WEEK,rti.n)
    }else if (rti.ti == DAY){
        return this.addTimeIntervals(DAY,rti.n)
    }
    return this

}

operator fun TimeInterval.times(n :Int)=RepeatedTimeInterval(this , n)

fun task29_1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task29_2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
class RepeatedTimeInterval(val ti: TimeInterval, val n: Int)



