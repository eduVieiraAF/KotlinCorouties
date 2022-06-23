import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking { // Thread: main

    // this → access CoroutineScope instance
    // coroutineContext → access coroutine context instance

    // Without Parameter: CONFINED → CONFINED DISPATCHER as we are confined to just one Thread
    launch { // inherits from parent 'runBlocking' coroutine and runs on Thread: main
        println("Coroutine #1 → ${Thread.currentThread().name}") //Thread main
        delay(1000)
        println("Coroutine #1 after 'delay()' → ${Thread.currentThread().name}")
                                                    // Thread: main as well even after 'delay()'
    }

    // With parameter: Dispatchers.Default → similar to GlobalScope.launch {  }
    launch(Dispatchers.Default) {
        println("Coroutine #2 → ${Thread.currentThread().name}") // Thread: T1
        delay(1000)
        println("Coroutine #2 after 'delay()' → ${Thread.currentThread().name}")
                                                    // after delay() T1 may get released or not
    }

    // With parameter: Dispatchers.Unconfined → UNCONFINED DISPATCHER as we are NOT confined to just one Thread
    launch(Dispatchers.Unconfined) { //will inherit from 'runBlocking {  }
        println("Coroutine #3 → ${Thread.currentThread().name}") // Thread: main
        delay(1000)
        println("Coroutine #3 after 'delay()' → ${Thread.currentThread().name}")
                                                    // after delay(), it will be executed on some other Thread
    }

    // Using coroutineContext property to pass context from immediate parent to child
    launch(coroutineContext) {// basically a property of runBlocking coroutine
        println("Coroutine #4 → ${Thread.currentThread().name}") // Thread: main
        delay(1000)
        println("Coroutine #4 after 'delay()' → ${Thread.currentThread().name}") // Thread: main as well
    }

    println("...code...")
}