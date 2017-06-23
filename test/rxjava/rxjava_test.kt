package rxjava

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.toObservable
import kotlin.concurrent.thread

/**
 * Created by w on 2017/6/23.
 */

fun main(args: Array<String>) {
    println("rxjava test")
    val a :IntArray = kotlin.IntArray(10 ,{it+1})
    val b :IntArray = kotlin.IntArray(100 ,{it+1})
    val intObservable = a.toObservable()
    val subject1: (Int) -> Unit = { it -> println("onNext => $it") }
    val subjectLong: (Long) -> Unit = { it -> println("onNext => $it") }
    val subject2: (Boolean) -> Unit = { it -> println("onNext => $it") }
    val subjectList :(List<Int>) -> Unit ={ list -> for ((index,value) in list.withIndex()) println("onNext =>$index $value")  }
    val subjectError :(Throwable) -> Int = { throwable -> 100 }

    val subject = object  : Observer<Int> {
        override fun onError(p0: Throwable?) {
            println("onError "+p0!!.message)
        }

        override fun onComplete() {
            println("onComplete")
        }

        override fun onNext(repo: Int?) {
            println("onNext = >"+repo)
        }

        override fun onSubscribe(p0: Disposable?) {
            println("onSubscribe")
        }

    }
    val result = intObservable.skip(3).take(5).map { it*2 }
//    result.subscribe(subject1)

//    result.all { it>10 }.subscribe(subject2)
//    b.toObservable().ambWith(result).subscribe(subject1)
//    result.buffer(2).subscribe(subjectList)
//    result.concatWith(b.toObservable()).subscribe(subject)
//    result.contains(7).subscribe(subject2)
//    result.isEmpty.subscribe(subject2)
//    result.any { it>1 }.subscribe(subject2)
//    result.count().subscribe(subjectLong)

}
