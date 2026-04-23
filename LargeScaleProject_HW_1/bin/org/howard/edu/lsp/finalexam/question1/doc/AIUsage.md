Tools: Claude code 
Prompt
A university system stores student service requests. Each request should receive a unique request ID before being added to a shared list. Multiple requests may be processed at the same time.
Given Code
import java.util.ArrayList;
import java.util.List;

public class RequestManager {
    private int nextId = 1;
    private List<String> requests = new ArrayList<>();

    public int getNextId() {
        int id = nextId;
        nextId++;
        return id;
    }

    public void addRequest(String studentName) {
        int id = getNextId();
        String request = "Request-" + id + " from " + studentName;
        requests.add(request);
    }

    public List<String> getRequests() {
        return requests;
    }
}

1. Identify two shared resources.
2. What concurrency problem may occur?
3. Why is addRequest() unsafe?

response:
Part 1:

Shared Resource #1: nextId — the integer counter used to assign unique request IDs. All threads share and mutate this field.

Shared Resource #2: requests — the ArrayList that stores all request strings. All threads share and mutate this list.

Concurrency Problem: A race condition. Two threads can interleave their execution such that they read the same value of nextId (or the same state of requests), resulting in duplicate IDs, lost updates, or corrupted list state.

Why addRequest() is unsafe: It performs a compound check-then-act across two separate operations — calling getNextId() and then requests.add() — without holding any lock across both steps. Even if each individual operation were atomic, another thread can interleave between them, causing two threads to obtain the same ID or one thread's add() to corrupt the list while another is also writing to it.Part 1:

Shared Resource #1: nextId — the integer counter used to assign unique request IDs. All threads share and mutate this field.

Shared Resource #2: requests — the ArrayList that stores all request strings. All threads share and mutate this list.

Concurrency Problem: A race condition. Two threads can interleave their execution such that they read the same value of nextId (or the same state of requests), resulting in duplicate IDs, lost updates, or corrupted list state.

Why addRequest() is unsafe: It performs a compound check-then-act across two separate operations — calling getNextId() and then requests.add() — without holding any lock across both steps. Even if each individual operation were atomic, another thread can interleave between them, causing two threads to obtain the same ID or one thread's add() to corrupt the list while another is also writing to it.

Prompt
Part 2: Evaluate Fixes (10 points)
For each fix, determine whether it correctly solves the concurrency problem.
•	If the fix is correct, explain why it works. 
•	If the fix is not correct, explain what problem still exists. 
There are no partially correct answers for this section.

Fix A:
public synchronized int getNextId() { ... }

Fix B:
public synchronized void addRequest(String studentName) { ... }

Fix C:
public synchronized List<String> getRequests() { ... }
Part 3: Object-Oriented Design (5 points)
1. Based on Arthur’s Riel’s heuristics, should getNextId() be public?
2. Explain.
Part 4: Alternative Synchronization Approach (10 points)
In lecture, we discussed an alternative approach to managing concurrency that does not rely on the synchronized keyword.
1.	Describe how this alternative approach could be used to make addRequest() thread-safe. 
2.	Provide a short code snippet (5–10 lines) demonstrating how this approach would be applied to make addRequest()thread-safe.

response

Part 2:

Fix A — synchronized getNextId(): INCORRECT.
Synchronizing only getNextId() ensures each ID increment is atomic in isolation, but addRequest() is still unsynchronized. Two threads can each call addRequest() concurrently, obtain different IDs (safely), but then both call requests.add() at the same time on the unsynchronized ArrayList, causing a race condition on the list itself. The compound action (getNextId + add) is still not atomic.

Fix B — synchronized addRequest(): CORRECT.
Synchronizing addRequest() acquires the lock for the entire method body, making the compound operation — getting an ID and adding to the list — atomic with respect to other threads calling addRequest(). No two threads can interleave inside this method simultaneously, eliminating both the ID duplication and the list corruption race.

Fix C — synchronized getRequests(): INCORRECT.
This only synchronizes the read accessor. It does nothing to protect nextId or requests during writes in addRequest(). The race condition on both shared resources during concurrent addRequest() calls is completely unaddressed.

Part 3:

Answer: No, getNextId() should not be public.

Explanation: According to Riel's heuristic, a class should hide its internal implementation details — only behavior that is part of the class's public contract should be exposed. getNextId() is an internal bookkeeping helper that exists solely to support addRequest(); it is an implementation detail of ID generation, not a service the class offers to external clients. Exposing it as public allows external code to call it independently, consuming IDs without creating requests, which breaks the invariant that every assigned ID corresponds to an entry in requests. It should be private.

Part 4:

Description:
The alternative approach discussed in lecture is using ReentrantLock (from java.util.concurrent.locks). Instead of using the synchronized keyword, you explicitly acquire a lock before entering the critical section and release it in a finally block to guarantee the lock is always released even if an exception is thrown. This gives finer-grained control over locking than synchronized while achieving the same mutual exclusion guarantee — only one thread can hold the lock and execute the protected block at a time.

Code Snippet:


import java.util.concurrent.locks.ReentrantLock;

private final ReentrantLock lock = new ReentrantLock();

public void addRequest(String studentName) {
    lock.lock();
    try {
        int id = nextId++;
        requests.add("Request-" + id + " from " + studentName);
    } finally {
        lock.unlock();
    }
}
The AI helped me get a better understanding of concurrency and what the shared resources could be.

reflection:
The learned that the following code had a race condition.
