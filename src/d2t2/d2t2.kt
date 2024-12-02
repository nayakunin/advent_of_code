package d2t2

import java.io.File

fun main() {
    val file = File("src/inputs/d2.txt")
    val regex = Regex("""(\d+(\s+\d+)*)""")

    val arr1 = mutableListOf<List<Int>>()

    file.forEachLine { line ->
        val match = regex.find(line)
        if (match != null) {
            val numbers = match.groupValues[1].split(" ").map { it.toInt() }
            arr1.add(numbers)
        }
    }

    var sum = 0

    fun isSafe(list: List<Int>): Int? {
        val sign = if (list[0] - list[1] < 0) -1 else 1
        for (i in 0 ..< list.size - 1) {
            val d = d1t1.distance(list[i], list[i + 1])

            if (d !in 1 .. 3 || sign * (list[i] - list[i + 1]) < 0) {
                return i + 1
            }
        }
        return null
    }

    mainLoop@ for (numbers in arr1) {
        val checkedIdx = isSafe(numbers)

        if (checkedIdx == null) {
            sum += 1
            continue@mainLoop
        }

        for (i in 0 .. checkedIdx) {
            val safe = isSafe(numbers.filterIndexed { index, _ -> index != i })

            if (safe == null) {
                sum += 1
                continue@mainLoop
            }
        }
    }
    println(sum)
}