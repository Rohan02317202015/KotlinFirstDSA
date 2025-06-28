package com.rohan.dsaprime.maths

import kotlin.math.log10
import kotlin.math.min

fun main(){
   val r = GCD().optimal(66,12)
    println(r)
}


/*
* Count No of digits in N
* */
private class CountNDigits{

    /*
    * TC: LogN
    * */
    fun brute(n: Int){
        var N = n
        var count = 0;
        while(N != 0){
            N = N/10
            count++
        }
        println("Total Digits in Number $n is $count")
    }

    /*
    * TC: O(1)
    * */
    fun optimal(n: Int){
        val N = n
        val result = if(N == 0) 0 else log10(N.toDouble()).toInt() + 1
        println("Total Digits in Number $n is $result")
    }
}



/*
* Reverse a number
* */
private class NumberReversal {

    /* TC: LogN */
    fun optimal(n: Int){
        var N = n
        var reverse = 0
        while (N != 0){
            val lastDigit = N % 10
            reverse = (reverse * 10) + lastDigit
            N = N/10
        }

        println("Reverse of Number $n is $reverse")
    }
}

/*
* Palindrome Number
* */
private class PalindromeCheck {

    /* TC: LogN */
    fun optimal(n: Int){
        var N = n
        var reverse = 0
        while (N != 0){
            val lastDigit = N % 10
            reverse = (reverse * 10) + lastDigit
            N = N/10
        }

        println("The Number is ${ if(n == reverse) "a Palindrome" else "not a Palindrome" }")
    }
}

/*
* Find GCD
* */
private class GCD {

    /* TC: O(min(n1,n2))*/
    fun brute(n1: Int, n2: Int){

        var gcd = 1
        for( i in 1..min(n1, n2)){
            if(n1 % i == 0 && n2 % i ==0){
                gcd = i
            }
        }

        println("GCD of $n1 & $n2 is $gcd")
    }

    /* TC: O(min(n1,n2))*/
    fun better(n1: Int, n2: Int){

        // Just reverse the brute war
        // Find divisor reverse way
        var gcd = 0
        for( i in min(n1,n2)downTo 1){
            if(n1 % i == 0 && n2 % i == 0){
                gcd = i
                break
            }
        }
        println("GCD of $n1 & $n2 is $gcd")
    }

    /* TC: O(Log(min(n1,n2)))*/
    fun optimal(n1: Int, n2: Int): Int {
        if( n2 <= 0 )
            return n1

        return optimal(n2 , n1%n2)
    }
}

