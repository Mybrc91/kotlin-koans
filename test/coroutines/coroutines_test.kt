package coroutines

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

/**
 * Created by w on 2017/5/27.
 */

fun main(args: Array<String>) {
    println("main")
    launch(CommonPool){
        delay(1000)
        println("hello")
    }
    Thread.sleep(2000)
}