package com.rohan.dsaprime.sorting

fun main() {
    val array = arrayOf(4, 5, 2, 3, 1, 1)
    QuickSort().sort(array, 0, 5)
    println("After Sorting: ${array.toList()}")
}

// SelectionSort class: Implements the selection sort algorithm
private class SelectionSort {

    /*
    * Time Complexity: O(N^2)
    * Selection sort repeatedly finds the minimum element from the unsorted part and puts it at the beginning.
    */
    fun sort(array: Array<Int>) {
        // Traverse through all array elements
        for (i in 0..array.size - 1) {
            // Find the minimum element in unsorted array
            for (j in i..array.size - 1) {
                // Swap if the element found is smaller than the current element
                if (array[i] > array[j]) {
                    // Swapping without using a temporary variable
                    array[i] += array[j]
                    array[j] = array[i] - array[j]
                    array[i] = array[i] - array[j]
                }
            }
        }
    }
}

// BubbleSort class: Implements the bubble sort algorithm
private class BubbleSort {

    /*
    * Time Complexity: O(N^2)
    * Bubble sort repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order.
    */
    fun sort(array: Array<Int>) {
        var lastIdx = array.size - 1
        // Outer loop for each pass
        for (i in 0..lastIdx) {
            // Inner loop for pairwise comparison
            for (j in 0..lastIdx - 1) {
                // Swap if the current element is greater than the next
                if (array[j] > array[j + 1]) {
                    // Swapping without using a temporary variable
                    array[j] += array[j + 1]
                    array[j + 1] = array[j] - array[j + 1]
                    array[j] = array[j] - array[j + 1]
                }
            }
            // Reduce the range for the next pass
            lastIdx -= 1
        }
    }
}

// InsertionSort class: Implements the insertion sort algorithm
private class InsertionSort {

    /*
    * Time Complexity: O(N^2)
    * Insertion sort builds the sorted array one item at a time by comparing each new element to the already-sorted elements and inserting it in the correct position.
    */
    fun sort(array: Array<Int>) {
        // Traverse from the first to the second last element
        for (i in 0..array.size - 2) {
            // If the current element is greater than the next, swap them
            if (array[i] > array[i + 1]) {
                // Swapping without using a temporary variable
                array[i] += array[i + 1]
                array[i + 1] = array[i] - array[i + 1]
                array[i] = array[i] - array[i + 1]
                // Move the swapped element to its correct position in the sorted part
                var j = i
                while (j > 0 && array[j - 1] > array[j]) {
                    // Swapping without using a temporary variable
                    array[j - 1] += array[j]
                    array[j] = array[j - 1] - array[j]
                    array[j - 1] = array[j - 1] - array[j]
                    j = j - 1
                }
            }
        }
    }
}

/**
 * MergeSort class: Implements the merge sort algorithm.
 *
 * Merge sort is a stable, divide-and-conquer sorting algorithm that recursively splits the array into halves,
 * sorts each half, and then merges the sorted halves to produce the final sorted array.
 *
 * Time Complexity: O(N log N)
 * Space Complexity: O(N) (due to the temporary array used during merging)
 */
private class MergeSort {

    /**
     * Recursively sorts the array from index [low] to [high] using merge sort.
     *
     * @param arr The array to be sorted.
     * @param low The starting index of the subarray to sort.
     * @param high The ending index of the subarray to sort.
     */
    fun mergeSort(arr: Array<Int>, low: Int, high: Int) {
        // Base case: If the subarray has one or no elements, it is already sorted
        if (low >= high) return //base condition

        val mid = (low + high) / 2

        // Recursively sort the left half
        mergeSort(arr, low, mid)

        // Recursively sort the right half
        mergeSort(arr, mid + 1, high)

        // Merge the two sorted halves
        merge(arr, low, mid, high)
    }

    /**
     * Merges two sorted subarrays of [array].
     * The first subarray is from [low] to [mid], the second is from [mid+1] to [high].
     *
     * @param array The array containing the subarrays to merge.
     * @param low The starting index of the first subarray.
     * @param mid The ending index of the first subarray.
     * @param high The ending index of the second subarray.
     */
    private fun merge(array: Array<Int>, low: Int, mid: Int, high: Int) {
        val temp = arrayListOf<Int>()
        var left = low
        var right = mid + 1

        /*
        * high is the end hence no pointer should
        * surpass it.
        * Left should not mid otherwise duplicate
        * of array elements are registered in
        * temp array
        * */
        while (left <= mid && right <= high) {
            if (array[left] <= array[right]) {
                temp.add(array[left])
                left++
            } else {
                temp.add(array[right])
                right++
            }
        }

        // if any of element left
        // from left array to be added
        while (left <= mid) {
            temp.add(array[left])
            left++
        }

        // if any of element left
        // from right array to be added
        while (right <= high) {
            temp.add(array[right])
            right++
        }

        //Inserting back to array
        //and subtract low as temp
        //starts from 0
        for (i in low..high) {
            array[i] = temp[i - low]
        }
    }
}

/**
 * QuickSort class: Implements the quick sort algorithm.
 *
 * Quick sort is an efficient, in-place, divide-and-conquer sorting algorithm that partitions the array
 * around a pivot element, recursively sorts the subarrays on either side of the pivot, and combines the results.
 *
 * Time Complexity: Average O(N log N), Worst O(N^2)
 * Space Complexity: O(log N) (due to recursion stack)
 */
private class QuickSort {

    /**
     * Recursively sorts the array from index [low] to [high] using quick sort.
     *
     * @param arr The array to be sorted.
     * @param low The starting index of the subarray to sort.
     * @param high The ending index of the subarray to sort.
     */
    fun sort(arr: Array<Int>, low: Int, high: Int){
        if(low < high) {
            // Partition the array and get the pivot index
            val pivotIdx = partition(arr, low, high)
            // Recursively sort elements before and after partition
            sort(arr, low, pivotIdx - 1)
            sort(arr, pivotIdx + 1, high)
        }
    }

    /**
     * Partitions the subarray [low to high] around a pivot element.
     * Elements less than or equal to the pivot are moved to the left,
     * and elements greater than the pivot are moved to the right.
     *
     * @param arr The array to partition.
     * @param low The starting index of the subarray.
     * @param high The ending index of the subarray.
     * @return The final index of the pivot element.
     */
    private fun partition(arr: Array<Int>, low: Int, high: Int): Int{
        var pivot = arr[low]
        var i = low
        var j = high
        // Move indices towards each other and swap elements as needed
        while(i < j){
            if( arr[i] <= pivot ){
                i++
            }

            if( arr[j] > pivot ) {
                j--
            }

            if( i < j) { // swap if i & j haven't crossed them
                arr[i] += arr[j]
                arr[j] = arr[i] - arr[j]
                arr[i] = arr[i] - arr[j]
            }
        }

        // Place the pivot in its correct sorted position
        arr[low] += arr[j]
        arr[j] = arr[low] - arr[j]
        arr[low] = arr[low] - arr[j]
        return j
    }
}