package d3t2

import java.io.File

fun main() {
    val file = File("src/inputs/d3.txt")

    val text = file.readText()

    val regex = Regex("""(mul\(\d+,\d+\)|do\(\)|don't\(\))""")

    var sum = 0
    var ignore = false

    regex.findAll(text).forEach { match ->
        println(match.value)

        when (match.value) {
            "do()" -> {
                ignore = false
            }
            "don't()" -> {
                ignore = true
            }
            else -> {
                val regex2 = Regex("""mul\((\d+),(\d+)\)""")
                val match2 = regex2.find(match.value) ?: return@forEach

                val a = match2.groupValues[1].toInt()
                val b = match2.groupValues[2].toInt()

                if (!ignore) {
                    sum += a * b
                }
            }
        }
    }

    println(sum)
}