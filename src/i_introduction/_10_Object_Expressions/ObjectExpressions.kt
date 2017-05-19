package i_introduction._10_Object_Expressions

import util.TODO
import util.doc10
import java.util.*
import kotlin.Comparator

fun todoTask10(): Nothing = TODO(
    """
        Task 10.
        Read about object expressions that play the same role in Kotlin as anonymous classes do in Java.

        Add an object expression that provides a comparator to sort a list in a descending order using java.util.Collections class.
        In Kotlin you use Kotlin library extensions instead of java.util.Collections,
        but this example is still a good demonstration of mixing Kotlin and Java code.
    """,
    documentation = doc10()
)

fun List<Int>.sort() :List<Int>{
    val mlist :MutableList<Int> = MutableList(this.size,{x -> this[x]})
    for(x in mlist.indices){
       for (y in mlist.size-1 downTo x+1){
           if (mlist[y] >mlist[y-1]) {
               val temp = mlist[y]
               mlist.set(y, mlist.get(y - 1))
               mlist.set(y - 1, temp)
           }
       }
    }
    return mlist.toList()
}

fun task10(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2).toMutableList()
    Collections.sort(arrayList , object : Comparator<Int>{
        override fun compare(x: Int?, y: Int?): Int {
            if(x?:0 >y?:0)
                return -1
            else if (x ==y)
                return 0
            else
                return 1
        }


    })
    return arrayList.toList()
}