package com.rohan.dsaprime.maths

import com.rohan.dsaprime.then
import kotlin.math.log10
import kotlin.math.min
import kotlin.math.pow

fun main() {
    val n = 10
    val list = arrayListOf<Int>().apply {

        add(84)
        add(257)
    }

    PrimeNumbers().FindAllSPFInRange().brute(list)
    PrimeNumbers().FindAllSPFInRange().optimal(list)
}


/*
* Count No of digits in N
* */
private class CountNDigits {

    /*
    * TC: LogN
    * */
    fun brute(n: Int) {
        var N = n
        var count = 0;
        while (N != 0) {
            N = N / 10
            count++
        }
        println("Total Digits in Number $n is $count")
    }

    /*
    * TC: O(1)
    * */
    fun optimal(n: Int) {
        val N = n
        val result = if (N == 0) 0 else log10(N.toDouble()).toInt() + 1
        println("Total Digits in Number $n is $result")
    }
}

/*
* Reverse a number
* */
private class NumberReversal {

    /* TC: LogN */
    fun optimal(n: Int) {
        var N = n
        var reverse = 0
        while (N != 0) {
            val lastDigit = N % 10
            reverse = (reverse * 10) + lastDigit
            N = N / 10
        }

        println("Reverse of Number $n is $reverse")
    }
}

/*
* Palindrome Number
* */
private class PalindromeCheck {

    /* TC: LogN */
    fun optimal(n: Int) {
        var N = n
        var reverse = 0
        while (N != 0) {
            val lastDigit = N % 10
            reverse = (reverse * 10) + lastDigit
            N = N / 10
        }

        println("The Number is ${if (n == reverse) "a Palindrome" else "not a Palindrome"}")
    }
}

/*
* Find GCD or HCF
* */
private class GCD {

    /* TC: O(min(n1,n2))*/
    fun brute(n1: Int, n2: Int) {

        var gcd = 1
        for (i in 1..min(n1, n2)) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i
            }
        }

        println("GCD of $n1 & $n2 is $gcd")
    }

    /* TC: O(min(n1,n2))*/
    fun better(n1: Int, n2: Int) {

        // Just reverse the brute war
        // Find divisor reverse way
        var gcd = 0
        for (i in min(n1, n2) downTo 1) {
            if (n1 % i == 0 && n2 % i == 0) {
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
        if (n2 <= 0)
            return n1

        return optimal(n2, n1 % n2)
    }
}

/*
* ArmStrong Number
* */
private class ArmStrong {

    /* TC: LogN */
    fun optimal(n: Int) {
        var N = n
        val pow = log10(n.toDouble()).toInt() + 1
        var result = 0
        while (N != 0) {
            val ld = N % 10
            result += ld.toDouble().pow(pow).toInt()
            N = N / 10
        }
        println((result == n) then "$n is an ArmStrong Number" otherWise "$n is not an ArmStrong number")
    }
}

/*
* Find all the divisors of a Number N
* Which means it can be Prime &
* Non Prime Number
* eg: 126
* [1, 126, 2, 63, 3, 42, 6, 21, 7, 18, 9, 14]
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
    fun brute(n: Int) {
        val resultList = arrayListOf<Int>()
        for (i in 1..n) {
            if (n % i == 0)
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
    fun optimal(n: Int) {
        val result = arrayListOf<Int>()
        var i = 1

        while ((i * i) <= n) {
            // i * i make sure loop till sq. root of N
            if (n % i == 0) {
                result.add(i)
                result.add(n / i)
            }
            i += 1
        }

        println("All divisors of $n is $result")
    }
}

private class Exponential {

    fun brute(a: Int, b: Int) {
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

/*
* Prime Numbers/Factors
* Prime Numbers are those numbers
* which is exactly divisible by two
* numbers ie, 1 and the N itself
* */
private class PrimeNumbers {

    /*
    * Check IF a given number N is
    * Prime of Not
    * */
    inner class CheckPrime {

        /*TC: O(N) */
        fun brute(n: Int) {
            val result = arrayListOf<Int>()
            for (i in 1..n) {
                if (n % i == 0) {
                    result.add(i)
                }
            }
            println("$n is ${(result.size > 2) then "not a Prime Number" otherWise "a Prime Number"}")
        }

        /*TC: O(sqRoot(N)) */
        fun optimal(n: Int): Boolean {
            val result = arrayListOf<Int>()
            var i = 1
            while ((i * i) <= n) {
                if (n % i == 0) {
                    result.add(i)
                    result.add(n / i)
                }
                i += 1
            }
            println("$n is ${(result.size > 2) then "not a Prime Number" otherWise "a Prime Number"}")
            return result.size == 2
        }
    }

    /*
    * Find all Prime Factors of a Number N
    * Which means only Prime Numbers
    * eg: 126
    * [2, 3, 7]
    *
    * */
    inner class FindAllPrimeFactorsOfN {
        fun optimal(N: Int) {
            var n = N
            var i = 2
            val result = arrayListOf<Int>()

            while ((i * i) <= n) {

                if (n % i == 0) {
                    result.add(i)
                    while (n % i == 0) {
                        n = n / i
                    }
                }

                i = i + 1
            }

            if (n > 1)
                result.add(n)

            println("All Prime factors of $N is $result")
        }
    }

    /*
    * Find all Prime Factors of a Number N
    * Which means only Prime Numbers
    * eg: 126
    * [2, 3, 7]
    * */
    inner class FindAllPrimeFactorsTillN {

        /*
        * This approach iterates through each number
        * and check if prime or not
        * TC: O( N * sq_root(N)) => N raise to 3/2
        * */
        fun brute(n: Int) {
            val result = arrayListOf<Int>()
            val checkPrime = CheckPrime()
            for (i in 2..n) {    // O(N)
                if (checkPrime.optimal(i)) {  //O(Sq_root(N))
                    result.add(i)
                }
            }

            println("All Prime factors till $n is $result")
        }

        /*
        * To optimise brute solution
        * We can pre-compute things
        * This algo is called
        * "Sieve of Eratosthenes" => "e-ruh-tows-theh-neez"
        * TC: The time complexity for this solution is already
        * been proofed by mathematician hence as it seems
        * => O(N) + O(sqRoot(N) * LogN) + O(N)
        * but the proven by the mathematician is
        * => O( N * Log (LogN) ) // consider this
        * SC: O(N)
        * */
        fun optimal(n: Int) {
            val primeArray = BooleanArray(n + 1) { true } // pre-initialise
            primeArray[0] = false // Because 1 and 0 are not
            primeArray[1] = false // prime number
            var i = 2
            while (i * i <= n) { // till square root of N
                if (primeArray[i]) {
                    var j = i * i
                    for (multiple in j..n step i) {
                        primeArray[multiple] = false
                    }
                }
                i += 1
            }

            val result = (2..n).filter { primeArray[it] }
            println("All prime number till $n are $result")
        }
    }


    /*
    * This problem statement states that
    * A query is given Q which contains ranges like
    * L = 1, R = 10
    * L = 2, R = 7
    * L = 4, R = 20, and so on
    * such that:
    *  0 < Q <= 10 pow 5
    *  0 < L < R <= 10 pow 6
    * */
    inner class FindAllPrimeFactorsInRange {

        /*
        * This approach will iterate through
        * all the queries and find primes
        *
        * TC: O( Q * R * sqrt(N) )
        * where:
        * Q: is the number of queries,
        * R: in worst case right, as left is 2
        * N: to check prime of a number in range L to R
        *
        * Observations:
        * Here if Q is 10 pow 5 and
        * R is going to 10 pow 6
        * and the sqrt of N
        * its huge, hence to reduce this
        *
        * we cannot reduce Q TC as we have
        * to iterate through each of the queries
        * but can reduce R TC
        * by not to computing each of the range
        * again and again but just by computing
        * this once. See in optimal solution
        * */
        fun brute(queries: List<Pair<Int, Int>>) {

            queries.forEach { query -> // O (Q)

                var (left, right) = query
                if (left < 2)
                    left = 2 // to avoid 0 and 1 to be added

                val result = arrayListOf<Int>()
                val checkPrime = CheckPrime()

                for (i in left..right) { // O( right - left + 1 )
                    if (checkPrime.optimal(i))  // O(sqrt(i))
                        result.add(i)
                }

                println("Number of Prime factors from ${query.first} to ${query.second} is ${result.size}")
            }
        }

        /*
        * In brute we get the solution but TC is huge
        * hence by using Sieve and Prefix Sum we can
        * reduce this to optimum by introducing space
        * complexity of O(max R)
        *
        * 1. Create a Prime Array for max R + 1
        * 2. Put 1 in every prime indexes
        * 3. Sum them using prefix sum
        * 4. Iterate through queries and find
        * prefixSum[right] - prefixSum[left]
        *
        * Note: It will only tell you the number of
        * Primes in that range not the values itself
        *
        * TC: O( Q + N * LogLogN + R + Q )
        * which summarises to
        * => O ( Q + N * LogLogN )
        * SC: O(R)
        * */
        fun optimal(queries: List<Pair<Int, Int>>) {
            // Step 1 : O(Q)
            val maxRight = queries.maxBy { it.second }.second // O(Q)
            val primeArr = Array(maxRight + 1) { 1 }
            primeArr[0] = 0
            primeArr[1] = 0
            var i = 2
            // Step 2
            // This whole sieve is O(N * LogLog(N))
            while (i * i <= maxRight) {
                if (primeArr[i] == 1) {
                    for (multiples in i * i..primeArr.size - 1 step i) {
                        primeArr[multiples] = 0
                    }
                }
                i += 1
            }

            // Step 3: O(R)

            // Running Fold includes the initial
            // accumulator ie 0 and push it to 0 index
            // .drop(1) will drop first element on
            // resultant array ie index 0
            val prefixSumArr = primeArr
                .runningFold(0) { accumulated, nextNum ->
                    accumulated + nextNum
                }.drop(1)


            //Step 4: O(Q)
            queries.forEach { query ->
                val (left, right) = query
                val primeCount = prefixSumArr[right] - prefixSumArr[left - 1]
                println("Total number of Prime counts from $left to $right is $primeCount")
            }
        }
    }

    /*
    * This problem statement states that
    * A query is given Q which contains a number like
    * 10
    * 7
    * 20, and so on
    * such that:
    *  0 < Q <= 10 pow 5
    *  0 < Q[i] <= 10 pow 6
    *
    * We have to find All Smallest Prime Factors of N
    * Repetition is allowed
    * */
    inner class FindAllSPFInRange {

        /*
        * In this approach we'll iterates each
        * and every query and its number
        * */
        fun brute(queries: List<Int>) {
            val result: ArrayList<Pair<Int, List<Int>>> = arrayListOf()
            queries.forEach { value ->

                var number = value
                val pair = Pair<Int, ArrayList<Int>>(number, arrayListOf())
                var i = 2

                while (i * i <= number) {
                    while (number % i == 0) {
                        pair.second.add(i)
                        number = number / i
                    }
                    i += 1
                }
                if (number > 1) {
                    pair.second.add(number)
                }
                result.add(pair)
            }

            for (pair in result) {
                val (number, spfs) = pair
                println("SPF of $number is $spfs")
            }
        }


        /*
        *
        * To optimize the brute way we would use
        * pre-computation like will be creating an
        * array for largest number available in the
        * query( +1 as array indexes starts from 0)
        * with value as their index so arr[4] contains
        * 4, hence index == value.
        * Then we will run a loop and check, let say i as index
        * 1.
        * */
        fun optimal(queries: List<Int>) {
            val maxOut = queries.maxBy { it }
            val preArray = Array(maxOut + 1) { it }
            var i = 2

            while (i * i < maxOut) {
                for (multiples in i * i..maxOut step i) {
                    if (preArray[multiples] == multiples)
                        preArray[multiples] = i
                }
                i += 1
            }
            val resultList = arrayListOf<Pair<Int, List<Int>>>()
            queries.forEach { query ->
                var number = query
                val result = Pair(number, arrayListOf<Int>())
                while (number != 1) {
                    result.second.add(preArray[number])
                    number = number / preArray[number]
                }
                resultList.add(result)
            }

            resultList.forEach { result ->
                println("SPF of ${result.first} is ${result.second}")
            }
        }
    }
}