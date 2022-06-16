import kotlinx.coroutines.*

fun main() = runBlocking { // main thread

    println("Main program started → ${Thread.currentThread().name}")

    val job: Job = launch {
        println("Dummy fake work started → ${Thread.currentThread().name}")

        for (i in 0..4) {
            delay(1000)
            println("\t$i")
        }

        println("Dummy fake work ended → ${Thread.currentThread().name}")
    }

    // job.cancel() can cancel coroutine
    job.join() // will wait for coroutine to finish its execution → no need for delay or sleep or hard code time

    println("Main program ended → ${Thread.currentThread().name}")
}

// All will run in the Main Thread now