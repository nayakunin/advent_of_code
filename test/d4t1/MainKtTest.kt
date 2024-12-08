package d4t1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class MainKtTest {
    @Test
    fun testMain() {
        val file = File("src/inputs/d4e1s.txt")

        // Capture the output
        val outputStream = java.io.ByteArrayOutputStream()
        System.setOut(java.io.PrintStream(outputStream))

        // Call the main function
        main()

        // Verify the output
        val output = outputStream.toString().trim()
        assertEquals(file.readText(), output)
    }
}