import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    println("Main program started → ${Thread.currentThread().name}")

    val time = measureTimeMillis {
        val messageOne: Deferred<String> = async { getMessageOne() } // Deferred<String> generates String
        val messageTwo: Deferred<String> = async { getMessageTwo() }
        println("Return values from suspend functions →" +
                "\n\t${messageOne.await()}\n\t${messageTwo.await()}") // .await() to get deferred string
    }

    println("Suspended functions executed in $time ms") // approximately 1041 ms

    println("Main program ended → ${Thread.currentThread().name}")
}
// with async suspend functions will be executed concurrently or in parallel

