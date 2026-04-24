AI Tools Used:
Claude Code

Prompts Used:
1. Provided the RequestManager code and asked to identify two shared resources, the concurrency problem, and why addRequest() is unsafe.
2. Provided Fixes A, B, C and asked to evaluate whether each correctly solves the concurrency problem, plus Part 3 (Riel's heuristic on getNextId visibility) and Part 4 (alternative synchronization approach with code snippet).

How AI Helped:
The AI helped me get a better understanding of concurrency and what the shared resources could be. It clarified why the compound action across getNextId() and requests.add() creates a race condition even when each step appears safe individually.

Reflection:
I learned that the following code had a race condition and that synchronizing only part of a compound operation does not make the whole operation thread-safe.
