import org.jetbrains.lincheck.datastructures.*
import java.util.concurrent.*
import kotlin.test.*

// This test reveals a non-linearizability issue
// in the `ConcurrentLinkedDeque` implementation.
//
// Importantly, a special API for testing
// data structures is used in this case.
class ConcurrentLinkedDequeTest {
    private val deque = ConcurrentLinkedDeque<Int>()

    @Operation
    fun addFirst(e: Int) = deque.addFirst(e)

    @Operation
    fun addLast(e: Int) = deque.addLast(e)

    @Operation
    fun pollFirst() = deque.pollFirst()

    @Operation
    fun pollLast() = deque.pollLast()

    @Operation
    fun peekFirst() = deque.peekFirst()

    @Operation
    fun peekLast() = deque.peekLast()

    @Test
    fun modelCheckingTest() = ModelCheckingOptions().check(this::class)
}
