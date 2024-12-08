package d4t2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.io.File

class MainKtTest {
    @Test
    fun testAoCExample(@TempDir tempDir: File) {
        val solution = File("src/inputs/d4e2s.txt")

        // Capture the output
        val outputStream = java.io.ByteArrayOutputStream()
        System.setOut(java.io.PrintStream(outputStream))

        val content = """
            MMMSXXMASM
            MSAMXMSMSA
            AMXSXMAAMM
            MSAMASMSMX
            XMASAMXAMM
            XXAMMXXAMA
            SMSMSASXSS
            SAXAMASAAA
            MAMMMXMMMM
            MXMXAXMASX
        """.trimIndent()
        val input = File(tempDir, "input.txt")
        input.writeText(content)

        // Call the main function
        val count = execute(input)

        // Verify the output
        val output = outputStream.toString().trim()
        assertEquals(solution.readText(), output)
        assertEquals(9, count)
    }

    @Test
    fun testCustomExample(@TempDir tempDir: File) {
        // Capture the output
        val outputStream = java.io.ByteArrayOutputStream()
        System.setOut(java.io.PrintStream(outputStream))

        val content = """
            MMSSMSMMMMMM
            MAMMAMMASSAM
            MMSMMMMSMMSM
            SMMMMMMSMMSM
            MAMMAMMASSAM
            SMMSMSMMMMMM
        """.trimIndent()
        val input = File(tempDir, "input.txt")
        input.writeText(content)

        val solution = """
            M.SS.S......
            .A..A.......
            M.SM.M......
            S.MM.M......
            .A..A.......
            S.MS.S......
        """.trimIndent()

        // Call the main function
        val count = execute(input)

        // Verify the output
        val output = outputStream.toString().trim()
        assertEquals(solution, output)
        assertEquals(4, count)
    }
}