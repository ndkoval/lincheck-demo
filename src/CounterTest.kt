import org.jetbrains.lincheck.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import kotlin.concurrent.*

// This test shows how Lincheck can be used
// to write concurrent tests on a straightforward example.
class CounterTest {
    @Test // JUnit test
    fun test() = Lincheck.runConcurrentTest {
        var counter = 0
        // Increment the counter concurrently.
        val t1 = thread { counter++ }
        val t2 = thread { counter++ }
        // Wait for the threads to finish.
        t1.join()
        t2.join()
        // Check both increments have been applied.
        assertEquals(2, counter)
    }
}
