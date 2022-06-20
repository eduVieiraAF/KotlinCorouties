import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main programs started → ${Thread.currentThread().name}")

    val result: String? = withTimeoutOrNull(2000) {
        for (i in 0..500) {
            print("$i.")
            delay(100)
        }

        "Coroutine ended" // in case it times out, 'result' will return 'null'
    }
    print("\nResult → $result")
    print("\nMain program ended → ${Thread.currentThread().name}")
}