package d1t2

import java.io.File

fun main() {
    val fileName = "src/input.txt"
    val file = File(fileName)
    val regex = Regex("""(\d+)\s+(\d+)""")

    val arr1 = mutableListOf<Int>()
    val occurrencesMap = mutableMapOf<Int, Int>()

    file.forEachLine { line ->
        val match = regex.find(line)
        if (match != null) {
            val a = match.groupValues[1].toInt()
            val b = match.groupValues[2].toInt()

            arr1.add(a)
            occurrencesMap[b] = occurrencesMap.getOrDefault(b, 0) + 1
        }
    }

    var sum = 0;

    for (i in 0..<arr1.size) {
//        println("$i: ${arr1[i]} -> ${occurrencesMap[arr1[i]]}")
        sum += (occurrencesMap[arr1[i]] ?: 0) * arr1[i]
    }

    println(sum)
}