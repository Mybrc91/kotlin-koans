package iii_conventions

import syntax.enums.Day

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int):Comparable<MyDate>{
    override fun compareTo(other: MyDate): Int {
        if (this.year>other.year){
            return 1;
        }else if (this.year < other.year){
            return -1
        }else {
            if (this.month < other.month)
                return -1
            else if (this.month >other.month)
                return 1
            else{
                if (this.dayOfMonth < other.dayOfMonth)
                    return -1
                else if (this.dayOfMonth >other.dayOfMonth)
                    return 1
                else{
                    return 0
                }
            }

        }

    }

}

operator fun MyDate.rangeTo(other: MyDate): DateRange {
    return DateRange(this , other)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate):ClosedRange<MyDate>,Iterable<MyDate>{
    override fun iterator(): Iterator<MyDate> {
        return object :Iterator<MyDate>{
            var cursor = start.addTimeIntervals(TimeInterval.DAY ,-1)
            override fun hasNext(): Boolean = cursor <endInclusive

            override fun next(): MyDate {
                cursor = cursor.nextDay()
                return cursor
            }

        }
    }

}


