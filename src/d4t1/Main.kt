package d4t1

import java.io.File

enum class Direction {
    UpRight,
    Right,
    DownRight,
    Down,
}

const val SIZE = 4

fun main() {
    val file = File("src/inputs/d4.txt")
    val matrix = mutableListOf<MutableList<Char>>()
    val matrix2 = mutableListOf<MutableList<Char>>()

    file.forEachLine { line ->
        matrix.add(line.toMutableList())
        matrix2.add(MutableList(line.length) { '.' })
    }

    fun pick(x: Int, y: Int, direction: Direction): Pair<String?, List<Pair<Int, Int>>> {
        when (direction) {
            Direction.UpRight -> {
                if (y >= SIZE - 1 && x <= matrix[y].size - SIZE) {
                    return Pair(
                        listOf(matrix[y][x], matrix[y - 1][x + 1], matrix[y - 2][x + 2], matrix[y - 3][x + 3]).joinToString(""),
                        listOf(
                            Pair(x, y),
                            Pair(x + 1, y - 1),
                            Pair(x + 2, y - 2),
                            Pair(x + 3, y - 3),
                        )
                    )
                }
            }
            Direction.Right -> {
                if (x <= matrix[y].size - SIZE) {
                    return Pair(
                        listOf(matrix[y][x], matrix[y][x + 1], matrix[y][x + 2], matrix[y][x + 3]).joinToString(""),
                        listOf(
                            Pair(x, y),
                            Pair(x + 1, y),
                            Pair(x + 2, y),
                            Pair(x + 3, y),
                        )
                    )
                }
            }
            Direction.DownRight -> {
                if (y <= matrix.size - SIZE && x <= matrix[y].size - SIZE) {
                    return Pair(
                        listOf(matrix[y][x], matrix[y + 1][x + 1], matrix[y + 2][x + 2], matrix[y + 3][x + 3]).joinToString(""),
                        listOf(
                            Pair(x, y),
                            Pair(x + 1, y + 1),
                            Pair(x + 2, y + 2),
                            Pair(x + 3, y + 3),
                        )
                    )
                }
            }
            Direction.Down -> {
                if (y <= matrix.size - SIZE) {
                    return Pair(
                        listOf(matrix[y][x], matrix[y + 1][x], matrix[y + 2][x], matrix[y + 3][x]).joinToString(""),
                        listOf(
                            Pair(x, y),
                            Pair(x, y + 1),
                            Pair(x, y + 2),
                            Pair(x, y + 3),
                        )
                    )
                }
            }
        }

        return Pair(null, listOf())
    }

    var count = 0

    for (y in 0..<matrix.size) {
        for (x in 0..<matrix[y].size) {
            if (matrix[y][x] != 'X' && matrix[y][x] != 'S') {
                continue
            }
            for (direction in Direction.entries) {
                val (result, idxs) = pick(x, y, direction)
                if (result == "XMAS" || result == "XMAS".reversed()) {
                    for ((i, j) in idxs) {
                        matrix2[j][i] = matrix[j][i]
                    }
                    count += 1
                }
            }
        }
    }

    println(count)
    println(matrix2.joinToString("\n") { it.joinToString("") })
}