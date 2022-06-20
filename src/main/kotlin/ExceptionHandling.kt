import kotlinx.coroutines.*

// Cancellable suspending functions such as yield(), delay(), etc. throw a CancellationException
//  on the coroutine cancellation.

fun main() = runBlocking {
    println("Main programs started → ${Thread.currentThread().name}")

    val job: Job = launch(Dispatchers.Default) {
        try{
            for (i in 0..500) {
                if (!isActive) return@launch
                print("$i.")
                delay(5) // or use yield()
            }
        } catch (e: CancellationException) {
            print("\nException caught safely")
        } finally {
            print("\nClose all resources")
            // a suspending function cannot be executed from the 'finally' block as the coroutine running the code
            //  is already cancelled.
        }
    }

    delay(10)
    job.cancelAndJoin()

    print("\nMain program ended → ${Thread.currentThread().name}")
}