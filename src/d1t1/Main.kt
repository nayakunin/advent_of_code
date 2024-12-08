package d1t1

import java.io.File
import kotlin.math.abs

fun distance (a: Int, b: Int): Int {
    return abs(a - b)
}

fun main() {
    val file = File("src/inputs/d1.txt")
    val regex = Regex("""(\d+)\s+(\d+)""")

    val arr1 = mutableListOf<Int>()
    val arr2 = mutableListOf<Int>()

    file.forEachLine { line ->
        val match = regex.find(line)
        if (match != null) {
            arr1.add(match.groupValues[1].toInt())
            arr2.add(match.groupValues[2].toInt())
        }
    }

    arr1.sort()
    arr2.sort()

    var sum = 0

    for (i in 0..<arr1.size) {
        sum += distance(arr1[i], arr2[i])
    }

    println(sum)
}