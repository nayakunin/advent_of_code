package d4t2

import java.io.File

fun execute(file: File): Int {
    val matrix = mutableListOf<MutableList<Char>>()
    val matrix2 = mutableListOf<MutableList<Char>>()

    file.forEachLine { line ->
        matrix.add(line.toMutableList())
        matrix2.add(MutableList(line.length) { '.' })
    }

    fun pick(x: Int, y: Int): List<Pair<Int, Int>>? {
        val tl = matrix[y - 1][x - 1]
        val tr = matrix[y - 1][x + 1]
        val bl = matrix[y + 1][x - 1]
        val br = matrix[y + 1][x + 1]
        val s1 = "$tl$br"
        val s2 = "$tr$bl"
        if ((s1 == "MS" || s1 == "SM") && (s2 == "MS" || s2 == "SM")) {
            return listOf(
                Pair(x - 1, y - 1),
                Pair(x + 1, y + 1),
                Pair(x - 1, y + 1),
                Pair(x + 1, y - 1)
            )
        }

        return null
    }

    var count = 0

    for (y in 1 ..< matrix.size - 1) {
        for (x in 1 ..< matrix[y].size - 1) {
            if (matrix[y][x] != 'A') {
                continue
            }
            val idxs = pick(x, y)
            if (idxs != null) {
                count += 1
                matrix2[y][x] = 'A'
                for ((i, j) in idxs) {
                    matrix2[j][i] = matrix[j][i]
                }
            }
        }
    }

    println(matrix2.joinToString("\n") { it.joinToString("") })

    return count
}

fun main() {
    val file = File("src/inputs/d4.txt")
    val count = execute(file)
    println(count)
}