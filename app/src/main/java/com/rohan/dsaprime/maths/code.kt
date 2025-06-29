package com.rohan.dsaprime.maths

import com.rohan.dsaprime.then
import kotlin.math.log10
import kotlin.math.min
import kotlin.math.pow

fun main(){
    val n = 151111
    Exponential().brute(7,2)
    PrimeNumbers().CheckPrime().optimal(n)
    AllDivisors().optimal(n)
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
* Find GCD or HCF
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

    /*
    * Done by Euclidean Theorem
    * TC: O(Log(min(n1,n2)))
    * */
    fun optimal(n1: Int, n2: Int): Int {
        if( n2 <= 0 )
            return n1

        return optimal(n2 , n1%n2)
    }
}

/*
* ArmStrong Number
* */
private class ArmStrong {

    /* TC: LogN */
    fun optimal(n: Int){
        var N = n
        val pow = log10(n.toDouble()).toInt() + 1
        var result = 0
        while(N != 0){
            val ld = N % 10
            result += ld.toDouble().pow(pow).toInt()
            N = N/10
        }
        println( (result == n) then "$n is an ArmStrong Number" otherWise "$n is not an ArmStrong number")
    }
}

/*
* Find all the divisors of a Number
* */
private class AllDivisors {

    /*
    * Divisor means a number which can
    * divide a number such that we get
    * remainder 0.
    * This approach iterates through N
    * and check divisibility through Modulo
    * operator.
    * TC: O(N)
    * */
    fun brute(n: Int){
        val resultList = arrayListOf<Int>()
        for(i in 1..n){
            if(n % i == 0)
                resultList.add(i)
        }
        println("All divisors of $n is $resultList")

    }

    /*
    * To optimise brute solution,
    * we can observe that divisors
    * increases only till square root
    * of N and after that it start to
    * decrease. And if we observe the part
    * after the sq. root of N it gives a
    * mirror of the above divisors
    * Eg no is 16, sq root of 16 is 4
    * 1 x 16
    * 2 x 8
    * 4 x 4 -> Here we reached to square root
    * 8 x 2 -> And from here mirror starts
    * 16 x 1
    *
    * TC: O(sq_root(N))
    * */
    fun optimal(n: Int){
        val result = arrayListOf<Int>()
        var i = 1

        while ((i * i) <= n){
            // i * i make sure loop till sq. root of N
            if(n % i == 0 ) {
                result.add(i)
                result.add(n/i)
            }
            i += 1
        }

        println("All divisors of $n is $result")
    }
}

/*
* Check Prime or not
* */
private class PrimeNumbers {

    inner class CheckPrime {
        fun brute(n: Int) {
            val result = arrayListOf<Int>()
            for (i in 1..n) {
                if (n % i == 0) {
                    result.add(i)
                }
            }
            println("$n is ${(result.size > 2) then "not a Prime Number" otherWise "a Prime Number"}")
        }

        fun optimal(n: Int){
            val result = arrayListOf<Int>()
            var i = 1
            while ((i * i) <= n){
                if(n % i == 0){
                    result.add(i)
                    result.add(n/i)
                }
                i += 1
            }
            println( "$n is ${ (result.size > 2) then "not a Prime Number" otherWise "a Prime Number"}" )
        }
    }

    inner class FindAll {

        fun optimal(N: Int){
            var n = N
            var i = 2
            val result = arrayListOf<Int>()

            while ( (i*i) <= n){

                if(n % i == 0){
                    result.add(i)
                    while(n % i == 0){ n = n/i }
                }

                i = i + 1
            }

            if(n > 1)
                result.add(n)

            println("All Prime factors of $N is $result")
        }
    }

}


private class Exponential {
    fun brute(a: Int, b: Int){
        var result = 1L
        var base = a
        var exp = b

        while (exp > 0) {
            if (exp % 2 == 1) {
                result *= base
            }
            base *= base
            exp /= 2
        }
        println("Exponential of $a to $b is $result")
    }
}