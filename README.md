# Lincheck Demo: Testing Concurrent Code

This is a demo project showcasing [Lincheck](https://github.com/JetBrains/lincheck) - a framework developed by JetBrains for testing concurrent programs. Initially focused on data-structure testing, Lincheck 3.0 provides a special declarative API for testing data structures.

## Examples

This repository contains several examples demonstrating how to use Lincheck:

1. [`CounterTest`](src/CounterTest.kt) - A simple example showing how to write a Lincheck test
2. [`ConcurrentHashMapDeadlock`](src/ConcurrentHashMapDeadlock.kt) - Shows how Lincheck can detect non-trivial deadlocks in concurrent code
3. [`ConcurrentLinkedDequeTest`](src/ConcurrentLinkedDequeTest.kt) - Demonstrates testing a concurrent data structure and revealing a non-linearizability issue

Watch this video demonstration of running [`CounterTest`](src/CounterTest.kt) and analyzing the error with the [Lincheck plugin](https://plugins.jetbrains.com/plugin/24171-lincheck/) for IntelliJ IDEA:

[![Lincheck Counter Example](https://img.youtube.com/vi/vmK90egjP8A/0.jpg)](https://www.youtube.com/watch?v=vmK90egjP8A)

## What Can I Test with Lincheck?

You can test almost any concurrent logic, such as:
- Concurrent caches
- Custom thread schedulers
- Implementation details of Kotlin Coroutines
- And more

## Lincheck vs Stress Tests

| Stress Tests                                                  | Lincheck |
|---------------------------------------------------------------|----------|
| May miss bugs                                                 | Systematically explores schedules |
| Hard to reproduce failures                                    | Provides an execution trace |
| May detect weak memory bugs (e.g., missing volatile modifier) | Assumes strong memory model (support for weak memory models planned) |

Feel free to explore the examples in this repository to understand how Lincheck can be used in your projects.

## Running the Examples

To run the examples in this repository:

1. Clone this repository:
   ```
   git clone https://github.com/ndkoval/lincheck-demo.git
   cd lincheck-demo
   ```

2. Run the tests using Gradle:
   ```
   ./gradlew test
   ```

3. For the best experience, open the project in IntelliJ IDEA with the [Lincheck plugin](https://plugins.jetbrains.com/plugin/24171-lincheck/) installed to visualize and debug the execution traces.
