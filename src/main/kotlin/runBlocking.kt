/* runBlocking is also a coroutine builder that bridges the non-coroutine world of a regular fun main() and the
    code with coroutines inside of runBlocking { ... } curly braces. This is highlighted in an IDE by this:
    CoroutineScope hint right after the runBlocking opening curly brace.*/

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    println("Task started")
    launch {
        delay(2000)
        println("World")
        doSomething()
    }

    println("Hello, ")
}

suspend fun doSomething() {
    for (i in 0..4) {
        delay(1000)
        println(i)
    }
    println("Now it's over")
}

suspend fun mySuspendingFunction() {
    delay(1000)
    // do something
}