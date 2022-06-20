import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main programs started → ${Thread.currentThread().name}")

    val job: Job = launch(Dispatchers.Default) {
        try {
            for (i in 0..500) {
                if (!isActive) return@launch
                print("$i.")
                delay(5)
            }
        } catch (e: CancellationException) {
            print("\nException caught safely with: ${e.message}")
        } finally {
        // generally we do not use suspending function in 'finally' but in rare cases wrap it with 'withContext()
        // This will start a new coroutine in another context
            withContext(NonCancellable){ // pass in parameter
                delay(1000)
                print("\nClose all resources")
            }
        }
    }

    delay(10)
    job.cancel(CancellationException("My own cancellation message → Cancel && goodbye"))
    job.join()

    print("\nMain program ended → ${Thread.currentThread().name}")
}