import kotlinx.coroutines.*

fun main() = runBlocking { // main thread

    println("Main program started → ${Thread.currentThread().name}")

    launch {
        println("Dummy fake work started → ${Thread.currentThread().name}")

        for (i in 0..4) {
            delay(1000)
            println("\t$i")
        }

        println("Dummy fake work ended → ${Thread.currentThread().name}")
    }

    withContext(Dispatchers.IO) {
        Thread.sleep(6000)
    }

    println("Main program ended → ${Thread.currentThread().name}")
}

// All will run in the Main Thread now