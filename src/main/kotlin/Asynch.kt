import kotlinx.coroutines.*

fun main() = runBlocking {

    println("Main program started → ${Thread.currentThread().name}")

    val jobDeferred: Deferred<Unit> = async {// does not return a job object but a deferred object
        println("Dummy fake work started → ${Thread.currentThread().name}")

        for (i in 0..4) {
            delay(1000)
            println("\t$i")
        }

        println("Dummy fake work ended → ${Thread.currentThread().name}")
    }

    //jobDeferred.join()
    jobDeferred.await()

    println("Main program ended → ${Thread.currentThread().name}")
}

