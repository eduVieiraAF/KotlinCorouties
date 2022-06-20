import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main program starts → ${Thread.currentThread().name}")

    val job: Job = launch(Dispatchers.Default) {
        for (i in 0..500) {
            if (!isActive) break // Checks if status is active or not
                           // return@launch would work too
            print("$i. ")
            Thread.sleep(1)
            // not delay() to avoid making it cooperative and immediately cancellable
        }
    }

    delay(500) // Will print a few number before coroutine gets cancelled
    // job.cancel()
    // job.join()
    job.cancelAndJoin() // better

    println("\nMain program ends → ${Thread.currentThread().name}")
}