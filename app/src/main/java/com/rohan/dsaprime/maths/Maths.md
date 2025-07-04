# Maths

---

## Key Concepts, Formulas & Tricky Implementation Details

### Counting Digits
- **Optimal Formula:** Number of digits in n = ⌊log₁₀(n)⌋ + 1
- **Concept:** Logarithms quickly determine the number of digits in a number, reducing the need for loops.
- **Tricky:** Special case for n = 0 (should return 0 or 1 depending on convention).

### Number Reversal & Palindrome Check
- **Concept:** Both use digit extraction with `% 10` and reconstruct the number by multiplying and adding digits.
- **Tricky:** Palindrome check simply compares the original and reversed number.

### GCD (Greatest Common Divisor)
- **Optimal Formula:** gcd(a, b) = gcd(b, a % b), with gcd(a, 0) = a (Euclidean Algorithm)
- **Concept:** Recursively reduces the problem size, yielding O(log(min(a, b))) time complexity.
- **Tricky:** The 'better' method iterates downwards, breaking early on the first divisor found.

### Armstrong Number
- **Formula:** For n with d digits: n is Armstrong if sum of each digit^d equals n.
- **Concept:** Uses digit extraction and powers to check the Armstrong property.
- **Tricky:** Uses log10(n) to determine the number of digits efficiently.

### All Divisors
- **Optimal Concept:** For each i from 1 to √n, if n % i == 0, both i and n/i are divisors.
- **Tricky:** If i × i = n (perfect square), only add i once to avoid duplicates.

### Exponential (Power)
- **Optimal Formula:**
  - If b is even: a^b = (a^(b/2))^2
  - If b is odd: a^b = a × (a^(b-1))
- **Concept:** Exponentiation by squaring reduces the number of multiplications from O(b) to O(log b).
- **Tricky:** Handles both even and odd exponents efficiently.

### Prime Numbers & Factors
- **Optimal Concept:** Sieve of Eratosthenes efficiently finds all primes up to n by marking multiples of each prime as composite.
- **Formula:** For each i from 2 to √n, mark all multiples of i as non-prime.
- **Tricky:**
  - Sieve is used for optimal prime factorization and prime number generation.
  - Prefix sums on the sieve array allow fast range queries for prime counts.
  - Smallest Prime Factor (SPF) array enables fast factorization of many numbers.
  - Many methods use nested loops and careful index management; off-by-one errors are easy to make, so double-check bounds.

### Prefix Sums for Range Queries
- **Concept:** Precompute cumulative counts (e.g., of primes) so that the number of items in a range [L, R] is prefix[R] - prefix[L-1].

---

**Tip:** When revisiting these algorithms, pay special attention to the use of mathematical properties (like square roots, logs, and sieves) for optimization, and to the handling of edge cases (like n = 0, perfect squares, or very large numbers).

