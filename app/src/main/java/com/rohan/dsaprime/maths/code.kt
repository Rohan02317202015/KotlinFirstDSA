package com.rohan.dsaprime.maths

import kotlin.math.log10

fun main(){
    NumberReversal().optimal(12345)
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


