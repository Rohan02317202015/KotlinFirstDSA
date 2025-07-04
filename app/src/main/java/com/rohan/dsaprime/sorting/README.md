# Sorting Algorithms

This folder contains implementations and explanations of classic sorting algorithms: Selection Sort, Bubble Sort, Insertion Sort, Merge Sort, and Quick Sort. Each algorithm is described with its core idea, real-world analogy, and any noteworthy implementation details from the codebase.

---

## 1. Algorithm Gist

- **Selection Sort:**
  - Repeatedly selects the minimum element from the unsorted part and moves it to the beginning.
  - Simple but inefficient for large datasets.
  - **Time Complexity:** O(N²)
  - **Space Complexity:** O(1)

- **Bubble Sort:**
  - Repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.
  - The largest elements "bubble up" to the end with each pass.
  - **Time Complexity:** O(N²)
  - **Space Complexity:** O(1)

- **Insertion Sort:**
  - Builds the sorted array one item at a time by inserting each new element into its correct position among the already-sorted elements.
  - Efficient for small or nearly sorted datasets.
  - **Time Complexity:** O(N²)
  - **Space Complexity:** O(1)

- **Merge Sort:**
  - A divide-and-conquer algorithm that splits the array into halves, sorts each half, and then merges the sorted halves.
  - Very efficient and stable, with guaranteed O(N log N) time.
  - **Time Complexity:** O(N log N)
  - **Space Complexity:** O(N)

- **Quick Sort:**
  - A divide-and-conquer algorithm that partitions the array around a pivot, then recursively sorts the subarrays on either side of the pivot. In this algorithm, we pick an element, find its correct position, and place it there; the left and right parts of the array repeat this process until every element is in its right position.
  - Fast in practice, but worst-case is O(N²) if the pivot choices are poor.
  - **Time Complexity:** Average O(N log N), Worst O(N²)
  - **Space Complexity:** O(log N) (due to recursion stack)

---

## 2. Real-World Analogies

- **Selection Sort:**
  - Like picking the smallest card from a shuffled deck and placing it at the front, then repeating for the rest.
  - Example: Selecting the shortest person from a group and moving them to the front, then repeating for the next shortest, and so on.

- **Bubble Sort:**
  - Like repeatedly walking through a line of people and swapping any two who are out of order, so the tallest gradually "bubbles" to the end.
  - Example: Sorting a stack of books by repeatedly comparing and swapping adjacent books until all are in order.

- **Insertion Sort:**
  - Like sorting playing cards in your hand: you pick up one card at a time and insert it into its correct position among the already sorted cards.
  - Example: Arranging exam papers in order as you receive them, inserting each new paper into the correct spot.

- **Merge Sort:**
  - Like dividing a pile of papers into smaller piles, sorting each pile, and then merging the sorted piles back together.
  - Example: Two people each sort half of a deck of cards, then combine their sorted halves into a fully sorted deck.

- **Quick Sort:**
  - Like a group of students lining up by height: one student (the pivot) stands in the correct position, and everyone else moves to the left or right depending on whether they are shorter or taller. The process repeats for each subgroup.
  - Example: Unordered students sort themselves by height by repeatedly choosing a "pivot" and splitting into groups until everyone is in order.

---

## 3. Noteworthy Implementation Details (from code.kt)

### Swapping Without a Temporary Variable
All sorting algorithms here use arithmetic operations to swap two elements without a temporary variable:
```kotlin
// Swap a and b without temp
a += b
b = a - b
a = a - b
```
**Caution:** This works for integers but can cause overflow or issues with non-integer types. Use with care.

### Selection Sort
- The inner loop starts from `i` (not `i+1`), so every element is compared with itself. This is safe but slightly less efficient.
- Swapping is done immediately when a smaller element is found, not after finding the minimum in the rest of the array (not the classic approach).

### Bubble Sort
- The outer loop reduces the range (`lastIdx`) after each pass, which is a standard optimization.
- Swapping is done using the arithmetic trick above.

### Insertion Sort
- After an initial swap, the code uses a `while` loop to "bubble" the swapped element leftward until it is in the correct position.
- This is a hybrid of bubble and insertion logic, and is less common than the classic shifting approach.
- Swapping is always done with the arithmetic trick.

### Merge Sort
- Uses an auxiliary `ArrayList<Int>` (`temp`) to store merged results before copying back to the original array.
- The merge function carefully handles remaining elements from both subarrays.
- The comment about "Left should not mid otherwise duplicate of array elements are registered in temp array" is a reminder to avoid pointer errors.

### Quick Sort
- The partition function uses the first element as the pivot.
- Indices `i` and `j` move towards each other, and elements are swapped if out of order.
- After the loop, the pivot is swapped into its correct position using the arithmetic trick.
- This is a Hoare-style partition, but with a custom swap and pivot logic.
- **Tricky:** The use of arithmetic swap and the way the pivot is handled can be error-prone if not careful with index bounds.

---

## 4. Tips

- If you revisit these algorithms, pay special attention to the swapping logic and partitioning in Quick Sort, as these are the most likely sources of subtle bugs or confusion.
- Review the real-world analogies to quickly recall the core idea of each algorithm. 