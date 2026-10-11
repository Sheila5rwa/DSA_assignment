# Week 3 Assignment: Build Your Own Data Structures (DSA I)

**Course:** Data Structures & Algorithms I  
**Author:** Sheila5rwa  
**Language:** Java (JDK 26+)

---

## 📌 Project Overview
This repository contains pure, custom implementations of core data structures and classic algorithms written in Java **without using `java.util` collection frameworks** inside custom implementations (except where explicitly allowed, such as `HashMap` in LRU Cache).

---

## 🏗️ Project Architecture & Components

```
DSA_Assignmnent/
├── src/
│   └── dsa/
│       ├── MyLinkedList.java        # Part 1: Generic Singly Linked List
│       ├── MyStack.java             # Part 2: Generic Stack backed by MyLinkedList
│       ├── MyQueue.java             # Part 2: Generic Queue implemented using two MyStacks
│       ├── AlgorithmicProblems.java # Part 2 & 3: isBalanced, rotateRight, isAnagram, twoSumSorted
│       ├── LRUCache.java            # Part 4: O(1) LRU Cache using HashMap & custom Doubly Linked List
│       └── Main.java                # Driver class demonstrating all parts and edge cases
└── README.md                        # Part 5: Complexity Report & real-world backend applications
```

---

## 📊 Part 5: Complexity Report & Real-World Backend Applications

| Part | Component / Method | Time Complexity (Best / Avg / Worst) | Space Complexity | Real-World Backend Application |
|---|---|---|---|---|
| **Part 1** | `MyLinkedList.addFirst(T)` | $O(1)$ | $O(1)$ | Used for prepending state or logs to fast audit chains and in memory-pool free lists. |
| **Part 1** | `MyLinkedList.addLast(T)` | $O(1)$ | $O(1)$ | Used in task buffers and transaction processing logs where fast append order matters. |
| **Part 1** | `MyLinkedList.removeFirst()` | $O(1)$ | $O(1)$ | Used at the head of worker dispatchers to consume the next queued workload immediately. |
| **Part 1** | `MyLinkedList.get(int index)` | $O(n)$ | $O(1)$ | Linear lookup used in non-indexed relational sequence scans and sequential record navigation. |
| **Part 1** | `MyLinkedList.size()` | $O(1)$ | $O(1)$ | Cached counters used in backend telemetry to monitor queue lengths and trigger backpressure alerts. |
| **Part 1** | `MyLinkedList.reverse()` | $O(n)$ | $O(1)$ | Reversing chronological database change-data-capture logs during rollback recovery operations. |
| **Part 1** | `MyLinkedList.findMiddle()` | $O(n)$ | $O(1)$ | Used as the partition phase in linked-list Merge Sort algorithms for database sorting engines. |
| **Part 2** | `MyStack.push(T)` | $O(1)$ | $O(1)$ | Used in undo/redo operation history stacks and web request navigation history. |
| **Part 2** | `MyStack.pop()` | $O(1)$ | $O(1)$ | Used in execution engines for popping stack frames during method and RPC returns. |
| **Part 2** | `MyStack.peek()` | $O(1)$ | $O(1)$ | Inspecting the topmost transaction context without altering the active transactional scope. |
| **Part 2** | `MyStack.isEmpty()` | $O(1)$ | $O(1)$ | Base-condition termination check in recursive backtracking and syntax parsers. |
| **Part 2** | `MyQueue.enqueue(T)` | $O(1)$ | $O(1)$ | Ingestion buffer for asynchronous message brokers (e.g., RabbitMQ, Celery) to accept incoming API jobs. |
| **Part 2** | `MyQueue.dequeue()` | Amortized $O(1)$ / Worst $O(n)$ | $O(1)$ | Worker thread consumption of submitted jobs in batch processing frameworks. |
| **Part 2** | `MyQueue.peek()` | Amortized $O(1)$ / Worst $O(n)$ | $O(1)$ | Previewing the next message to read lock state before processing in rate limiters. |
| **Part 2** | `AlgorithmicProblems.isBalanced(expr)` | $O(n)$ | $O(n)$ | Used in compilers, SQL query parsers, and JSON schema validators to verify structural integrity. |
| **Part 3** | `AlgorithmicProblems.rotateRight(a, k)` | $O(n)$ | $O(1)$ | Rotating server replica rings in consistent hashing topologies and round-robin scheduling algorithms. |
| **Part 3** | `AlgorithmicProblems.isAnagram(a, b)` | $O(n)$ | $O(1)$ (fixed 256 ascii) | Used in search engines and deduplication pipelines to detect mutated text and token anagrams. |
| **Part 3** | `AlgorithmicProblems.twoSumSorted(a, target)`| $O(n)$ | $O(1)$ | Financial portfolio ledger balancing and order-matching engines across pre-sorted order books. |
| **Part 4** | `LRUCache.get(key)` | $O(1)$ | $O(1)$ | Read-through caching layers (such as Redis or Memcached) to fetch frequently requested API payloads. |
| **Part 4** | `LRUCache.put(key, value)` | $O(1)$ | $O(1)$ | Cache eviction mechanisms in database buffer pools (e.g., InnoDB buffer pool) when RAM fills up. |

---

## 🚀 How to Compile and Run

Make sure you have JDK 8+ (or JDK 26) installed:

### 1. Compile:
```bash
javac -d out src/dsa/*.java
```

### 2. Run Main Demo:
```bash
java -cp out dsa.Main
```
