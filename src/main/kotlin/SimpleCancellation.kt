import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main program starts → ${Thread.currentThread().name}")

    val job: Job = launch {
        for (i in 0..500) {
            print("$i. ")
            delay(50)
        }
    }

    delay(500) // Will print a few number before coroutine gets cancelled
    // job.cancel()
    // job.join()
    job.cancelAndJoin() // better

    println("\nMain program ends → ${Thread.currentThread().name}")
}