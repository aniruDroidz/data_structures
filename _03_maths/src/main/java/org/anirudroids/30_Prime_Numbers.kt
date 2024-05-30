import kotlin.math.sqrt

fun main() {
    val primeNumbers = `30_Prime_Numbers`()
    val spfs = primeNumbers.forth(20)

    for(i in spfs) {
        println(i)
    }
}
class `30_Prime_Numbers` {
    /**
     * Given an integer N. Check if it is prime or not
     */
    fun first(n: Int) {
        //TODO
    }

    /**
     * Given a number N. We need to print all the prime numbers from 1 to N
     */
    fun second(n: Int) {
        //TODO
    }

    /**
     * Sieve of Eratosthenes
     */
    fun third(n: Int) {
        val isPrime = Array(n+1) {true}

        for(i in 2..sqrt(n.toDouble()).toInt()) {
            if(isPrime[i]) {
                for(j in i*i..n step i) {
                    isPrime[j] = false
                }
            }
        }

        for(i in isPrime) {
            if(i) {
                print(i)
            }
        }
    }

    /**
     * Given n. Return the SPF(Smallest prime factor of all the numbers from 2 to n)
     */
    fun forth(n: Int): Array<Int> {
        val spf = Array(n+1) {it}

        for(i in 2..sqrt(n.toDouble()).toInt()) {
            if(spf[i] == i) {
                for(j in i*i..n step i) {
                    if(spf[j] == j) {
                        spf[j] = i
                    }
                }
            }
        }

        return spf
    }

    /**
     * Basic Prime Factorisation
     * Process of finding the prime numbers which are multiplied to get the original number
     */
    /**
     * For a given number n. Find the count of divisors of all the numbers from 1 to n.
     */
    fun fifth(n: Int) {

    }
}