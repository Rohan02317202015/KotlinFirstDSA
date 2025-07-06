package com.rohan.dsaprime.basics.recursion

fun main() {

    println(Fibonacci().series(30,0,0))
}

class CheckPalindrome  {

    fun isPalindrome(word: String, low: Int, high: Int): Boolean {
        if( low >= high ) return true

        if( word[low] != word[high]) return false

       return isPalindrome(word, low + 1, high - 1)
    }
}

class Fibonacci {

    fun series(term: Int, acc: Int, previous: Int) {
        if(term <= 0) return
        if(acc == 0 && previous == 0){
            print("0 1 ")
            series(term - 2, 1, 1)
        } else {
            print("$acc ")
            val updatedAcc = acc + previous
            series(term - 1, updatedAcc, acc)
        }
    }
}