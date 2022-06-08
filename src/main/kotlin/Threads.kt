import kotlin.concurrent.thread

/**
It’s tempting to think that spawning more threads can help us execute more tasks concurrently.
Unfortunately, that’s not always true.

Creating too many threads can actually make an application under-perform in some situations or run out of memory.
Threads are objects which impose overhead during object allocation and garbage collection.

To overcome these issues, Kotlin introduced a new way of writing asynchronous, non-blocking code; the Coroutine.

Similar to threads, coroutines can run in concurrently, wait for, and communicate with each other with the
difference that creating them is way 'cheaper' than threads.
 */

// Example with thread

fun main() { // main thread

    println("Main program started → ${Thread.currentThread().name}")

    thread { // background thread or worker thread and does not block main thread but run concurrently.
        println("Dummy fake work started → ${Thread.currentThread().name}")

        for (i in 0..4) {
            Thread.sleep(1000)
            println(i)
        }

        println("Dummy fake work ended → ${Thread.currentThread().name}")
    }

    println("Main program ended → ${Thread.currentThread().name}")
}
