import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main programs started → ${Thread.currentThread().name}")

    withTimeout(2000) {
        try {
            for (i in 0..500) {
                print("$i.")
                delay(500)
            }
        } catch (e: TimeoutCancellationException) {
            println("\nProgram ran out of time")
        } finally {
            println("All resources will be closed due to time out")
        }
    }

    print("\nMain program ended → ${Thread.currentThread().name}")
}