package vi_generics

import util.TODO
import java.util.*
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver

fun task41(): Nothing = TODO(
    """
        Task41.
        Add a 'partitionTo' function that splits a collection into two collections according to a predicate.
        Uncomment the commented invocations of 'partitionTo' below and make them compile.

        There is a 'partition()' function in the standard library that always returns two newly created lists.
        You should write a function that splits the collection into two collections given as arguments.
        The signature of the 'toCollection()' function from the standard library may help you.
    """,
        references = { l: List<Int> ->
            l.partition { it > 0 }
            l.toCollection(HashSet<Int>())
        }
)

public fun <T, E:MutableCollection<T>> Collection<T>.partitionTo(first: E ,second: E, spilte: (T) -> Boolean ): Pair<E,E> {
    for (e in this){
        if (spilte(e)){
            first.add(e)
        }else
            second.add(e)
    }
    return Pair(first,second)
}

fun List<String>.partitionWordsAndLines(): Pair<List<String>, List<String>> {
    return return partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
}


fun Set<Char>.partitionLettersAndOtherSymbols(): Pair<Set<Char>, Set<Char>> {
    return partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z'}
}