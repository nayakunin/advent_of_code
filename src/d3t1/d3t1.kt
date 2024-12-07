package d3t1

import java.io.File

fun main() {
    val file = File("src/inputs/d3.txt")

    val text = file.readText()

    val regex = Regex("""mul\((\d+),(\d+)\)""")

    var sum = 0

    regex.findAll(text).forEach { match ->
        println(match.groupValues)
        val a = match.groupValues[1].toInt()
        val b = match.groupValues[2].toInt()

        sum += a * b
    }

    println(sum)
}