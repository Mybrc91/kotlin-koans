package iv_properties

import util.TODO
import util.doc34
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class LazyPropertyUsingDelegates(val initializer: () -> Int) {
//    val lazyValue: Int by lazy(initializer)
    val lazyValue :Int by MyDelegate{ initializer() }
}
class MyDelegate<R>(private val initializer: () -> Int):ReadWriteProperty<R,Int> {
    var isFirst = true
    var value :Int? = null
    override operator fun getValue(thisRef: R, property: KProperty<*>): Int {
        if (isFirst) {
            isFirst= false
            value = initializer()
        }
        return value!!
    }

    override operator fun setValue(thisRef: R, property: KProperty<*>, value: Int) {

    }
}

fun todoTask34(): Lazy<Int> = TODO(
    """
        Task 34.
        Read about delegated properties and make the property lazy by using delegates.
    """,
    documentation = doc34()
)
