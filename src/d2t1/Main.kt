package d2t1

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

    mainLoop@ for (numbers in arr1) {
        val sign = if (numbers[0] - numbers[1] < 0) -1 else 1
        for (i in 0..<numbers.size - 1) {
            val d = d1t1.distance(numbers[i], numbers[i + 1])

            if (d !in 1..3 || sign * (numbers[i] - numbers[i + 1]) < 0) {
                continue@mainLoop
            }
        }

        sum += 1
    }

    println(sum)
}