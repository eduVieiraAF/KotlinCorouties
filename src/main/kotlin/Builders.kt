/**
 * What are coroutine builders →
 *
 * Methods for creating coroutines.
 *
 * TYPES →
 *
 * launch { } → creates a coroutine at local scope / does not block current thread
 *
 * GlobalScope.launch { } → Companion Object / creates a coroutine as global (app) level
 *
 * async { } → similar to launch → see Asynchkt
 *
 * GlobalScope.launch { } → Companion object and will run in the Global level
 *
 * runBlocking { }
 */