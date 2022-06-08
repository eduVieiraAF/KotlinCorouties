@file:Suppress("OPT_IN_IS_NOT_ENABLED")

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
fun main() { // main thread

    println("Main program started → ${Thread.currentThread().name}")

    GlobalScope.launch { // background coroutine that runs on a background thread
        println("Dummy fake work started → ${Thread.currentThread().name}")

        for (i in 0..4) {
            delay(1000)
            println("\t$i")
        }

        println("Dummy fake work ended → ${Thread.currentThread().name}")
    }

    Thread.sleep(6000) // blocks main thread and waits for coroutine to finish
    println("Main program ended → ${Thread.currentThread().name}")
}