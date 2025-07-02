package com.rohan.dsaprime.sorting


fun main(){

    val array = arrayOf(4,5,2,3,1,1)
    InsertionSort().sort(array)
    println("After Sorting: ${array.toList()}")
}

// SelectionSort class: Implements the selection sort algorithm
private class SelectionSort {

    /*
    * Time Complexity: O(N^2)
    * Selection sort repeatedly finds the minimum element from the unsorted part and puts it at the beginning.
    */
    fun sort(array: Array<Int>){
        // Traverse through all array elements
        for (i in 0..array.size - 1){
            // Find the minimum element in unsorted array
            for(j in i.. array.size - 1){
                // Swap if the element found is smaller than the current element
                if(array[i] > array[j]){
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
    fun sort(array: Array<Int>){
        var lastIdx = array.size - 1
        // Outer loop for each pass
        for (i in 0..lastIdx){
            // Inner loop for pairwise comparison
            for(j in 0..lastIdx-1){
                // Swap if the current element is greater than the next
                if(array[j] > array[j+1]){
                    // Swapping without using a temporary variable
                    array[j] += array[j+1]
                    array[j+1] = array[j] - array[j+1]
                    array[j] = array[j] - array[j+1]
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
        for( i in 0..array.size-2 ){
            // If the current element is greater than the next, swap them
            if (array[i] > array[i+1]){
                // Swapping without using a temporary variable
                array[i] += array[i+1]
                array[i + 1] = array[i] - array[i+1]
                array[i] = array[i] - array[i+1]
                // Move the swapped element to its correct position in the sorted part
                var j = i
                while (j > 0 && array[j-1] > array[j]){
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