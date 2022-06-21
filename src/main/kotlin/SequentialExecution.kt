import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    println("Main program started → ${Thread.currentThread().name}")

    val time = measureTimeMillis {
        val messageOne = getMessageOne()
        val messageTwo = getMessageTwo()
        println("Return values from suspend functions →" +
                "\n\t$messageOne\n\t$messageTwo")
    }

    println("Suspended functions executed in $time ms") // approximately 2021 ms

    println("Main program ended → ${Thread.currentThread().name}")
}
// by default within runBlocking, methods are executed one after the other top to bottom

suspend fun getMessageOne(): String {
    delay(1000L)
    // ...code...
    return "Message #1"
}

suspend fun getMessageTwo(): String {
    delay(1000L)
    // ...code...
    return "Message #2"
}