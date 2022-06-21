import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main program started → ${Thread.currentThread().name}")

    val messageThree: Deferred<String> = async(start = CoroutineStart.LAZY) { getMessageThree() }
    val messageFour: Deferred<String> = async(start = CoroutineStart.LAZY) { getMessageFour() }
    println("Return values from suspend functions → \n\t${messageThree.await()}\n\t${messageFour.await()}")

    println("Main program ended → ${Thread.currentThread().name}")
}

// CoroutineStart.LAZY only allows for function execution if I'm using the returned String values in the code
// so if I comment out the 2nd println statement, the suspend functions will not be executed as they're not "useful"

suspend fun getMessageThree(): String {
    delay(1000L)
    println("\tCode some more in message Three")
    return "Message #3"
}

suspend fun getMessageFour(): String {
    delay(1000L)
    println("\tCode some more in message Four")
    return "Message #4"
}



