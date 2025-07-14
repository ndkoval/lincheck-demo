import org.jetbrains.lincheck.*
import java.util.concurrent.*
import kotlin.concurrent.*
import kotlin.test.*

// This test demonstrates the deadlock by two threads
// that perform nested `computeIfAbsent` calls in opposite order.
class ConcurrentHashMapDeadlock {
    @Test
    fun test() = Lincheck.runConcurrentTest {
        val map = ConcurrentHashMap<String, String>()
        // In one thread, try to update `key2` while locking `key1`.
        val thread1 = thread {
            map.computeIfAbsent("key1") {
                map.computeIfAbsent("key2") { "value2" }
                "value1"
            }
        }
        // In another thread, try to update `key1` while locking `key2`.
        val thread2 = thread {
            map.computeIfAbsent("key2") {
                map.computeIfAbsent("key1") { "value1" }
                "value2"
            }
        }
        // Wait until both threads complete.
        thread1.join()
        thread2.join()
    }
}
