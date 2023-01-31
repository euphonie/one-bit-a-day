import codewars.katas.FindSubstrings
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindSubstringsTest {
    @Test
    fun testFixed() {
        val a2 = arrayOf<String>("lively", "alive", "harp", "sharp", "armstrong")
        val finder = FindSubstrings()
        assertArrayEquals(
            arrayOf<String>("live", "strong"),
            finder.inArray(arrayOf<String>("xyz", "live", "strong"), a2)
        )
        assertArrayEquals(
            arrayOf<String>("arp", "live", "strong"),
            finder.inArray(arrayOf<String>("live", "strong", "arp"), a2)
        )
        assertArrayEquals(arrayOf<String>(), finder.inArray(arrayOf<String>("tarp", "mice", "bull"), a2))
        assertArrayEquals(
            arrayOf<String>("by", "or", "ple"),
            finder.inArray(
                arrayOf<String>("gla", "by", "ple", "or", "pini", "ple"),
                arrayOf<String>(
                    "somewhere).",
                    "is",
                    "what",
                    "have",
                    "answer",
                    "what",
                    "Ruby,",
                    "your",
                    "Ruby",
                    "sample;",
                    "(mladen's",
                    "for",
                    "for",
                    "answer",
                    "here",
                    "does",
                    "comment)"
                )
            )
        )
    }
}