/**
 * Hashing is process which can map infinite range to finite range
 */

fun main() {
    val hashMap = HashMap<String, String>()
    val hashSet = HashSet<String>()

    //findFrequency(arrayOf(1,2,4), arrayOf(2,5,4))
    //findFirstNonRepeatingCharacter(arrayOf(2,5,4))
    //findCountOfDistinctElements(arrayOf(2,4,5,4))
    checkIfAnySubArraySumIsZero(arrayOf(2,2,1,-3,4,3,1,-2,-3,2))
}

fun checkIfAnySubArraySumIsZero(arrayOf: Array<Int>) {
    //1. Create prefix sum array
    //2. ps[j] - ps[i-1] = 0

    val prefixSum = arrayOfNulls<Int>(arrayOf.size)
    prefixSum[0] = arrayOf[0]
    for(i in 1..<arrayOf.size) {
        prefixSum[i] = arrayOf[i] + (prefixSum[i - 1] ?: 0)
        if(prefixSum[i] == 0) {
            print("true")
            return
        }
    }

    val hashSet = HashSet<Int>()
    for(i in arrayOf.indices) {
        if(hashSet.contains(prefixSum[i])) {
            print("true")
            return
        }
        hashSet.add(prefixSum[i]?:0)
    }
    print("false")
}

fun findCountOfDistinctElements(arrayOf: Array<Int>) {
    val hashSet = HashSet<Int>()
    for(i in arrayOf) {
        hashSet.add(i)
    }

    print(hashSet.size)
}

fun findFirstNonRepeatingCharacter(arrayOf: Array<Int>) {
    val frequencyMap = HashMap<Int, Int>()

    val n = arrayOf.size

    for(i in 0..<n) {
        if(frequencyMap.containsKey(arrayOf[i])) {
            frequencyMap[arrayOf[i]] = frequencyMap[arrayOf[i]]!!.plus(1)
        } else {
            frequencyMap[arrayOf[i]] = 1
        }
    }

    for(i in arrayOf) {
        val value = frequencyMap[i]
        if(value == 1) {
            print("This is the first non-repeating character - $i")
        }
    }
}

fun findFrequency(Q: Array<Int>, N: Array<Int>) {
    val frequencyMap = HashMap<Int, Int>()

    val q = Q.size
    val n = N.size

    for(i in 0..<n) {
        if(frequencyMap.containsKey(N[i])) {
            frequencyMap[N[i]] = frequencyMap[N[i]]!!.plus(1)
        } else {
            frequencyMap[N[i]] = 1
        }
    }

    for(i in 0..<q) {
        val value = frequencyMap[Q[i]]
        value?.let {
            print("${Q[i]} --> $it")
        } ?: print("0")
    }
}