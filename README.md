# Deque & RandomizedQueue – Java Implementation

This repository contains two data structure implementations commonly used in algorithms and systems programming:

- **Deque** (Double-Ended Queue) implemented using a **doubly linked list**
- **RandomizedQueue** implemented using a **resizing array** with random removal

Both implementations follow the specifications of the Princeton University *Algorithms, Part I* programming assignment.

---

## 📌 1. Deque (Double-Ended Queue)

### 🔍 Overview
A **Deque** is a queue where items can be added or removed from **both** the front and the back.  
This implementation uses a **doubly linked list**, giving all operations constant time:

| Operation        | Time Complexity |
|------------------|-----------------|
| addFirst         | O(1)            |
| addLast          | O(1)            |
| removeFirst      | O(1)            |
| removeLast       | O(1)            |
| isEmpty          | O(1)            |
| size             | O(1)            |

### ✨ Features
- Add items at both ends  
- Remove items from both ends  
- Iterable from front to back  
- Throws proper exceptions for invalid operations  
- Uses `Iterator` for enhanced for-loop support  

### 🧱 Internal Structure
Each element is stored in a node:

```java
private class node {
    Item item;
    node next;
    node pervious;
}
Pointers maintained:

first → front of deque

last → back of deque

📌 2. RandomizedQueue
🔍 Overview
A RandomizedQueue stores items similar to a normal queue,
but removal happens by choosing a random item uniformly.

This structure uses a resizing array internally.

✨ Features
Add items using enqueue

Remove a random item using dequeue

sample() returns a random item without removing it

Automatically resizes the internal array (doubling & halving)

Supports iteration in independent random order

🧮 Time Complexity
Operation	Time Complexity
enqueue	Amortized O(1)
dequeue	Amortized O(1)
sample	O(1)
iterator	O(n)

🧱 Internal Behavior
Uses StdRandom.uniformInt(size) to pick random indices

Array expands when full, shrinks when quarter-full

Iterator provides items in reverse (can be modified for random order)

📦 Project Structure
Copy code
/
├── Deque.java
└── RandomizedQueue.java
▶️ Running the Code
Compile:

bash
Copy code
javac-algs4 Deque.java
javac-algs4 RandomizedQueue.java
Run:

bash
Copy code
java-algs4 Deque
java-algs4 RandomizedQueue
🧪 Error Handling
Both classes throw standard Java exceptions:

Case	Exception
Adding null to either structure	IllegalArgumentException
Removing from an empty structure	NoSuchElementException
Calling iterator with no next item	NoSuchElementException

📜 Notes
This implementation follows the style and constraints of the official Princeton Algorithms course , including:

No use of Java internal collections

Manual array resizing

Custom iterator classes

