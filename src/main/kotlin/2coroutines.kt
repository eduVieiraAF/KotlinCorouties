@file:Suppress("OPT_IN_IS_NOT_ENABLED")

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    println("Main thread started → ${Thread.currentThread().name}")

    GlobalScope.launch {
        println("\tCoroutine 1 started → ${Thread.currentThread().name}")
        delay(1000)
        println("\tCoroutine 1 ended → ${Thread.currentThread().name}")
    }

    runBlocking {// blocks main thread
        delay(1000)
        println("\t\tCoroutine 2 → everyone stop → ${Thread.currentThread().name}")
    }

    Thread.sleep(2000)
    println("Main thread ended → ${Thread.currentThread().name}")
}