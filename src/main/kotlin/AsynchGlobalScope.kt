@file:Suppress("OPT_IN_IS_NOT_ENABLED")

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {

    println("Main program started → ${Thread.currentThread().name}")

    val jobDeferred: Deferred<Unit> = GlobalScope.async {// does not return a job object but a deferred object
        println("Dummy fake work started → ${Thread.currentThread().name}")

        for (i in 0..4) {
            delay(1000)
            println("\t$i")
        }

        println("Dummy fake work ended → ${Thread.currentThread().name}")
    }

    jobDeferred.await()

    println("Main program ended → ${Thread.currentThread().name}")
}

// will not run in the main thread

