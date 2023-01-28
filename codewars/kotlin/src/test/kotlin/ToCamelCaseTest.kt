import kotlin.test.assertEquals
import org.junit.jupiter.api.Test
import codewars.katas.CamelCaseFormatter

class ToCamelCaseTest {
    @Test
    fun testFixed() {
        val formatter = CamelCaseFormatter()
        assertEquals("", formatter.toCamelCase(""))
        assertEquals("theStealthWarrior", formatter.toCamelCase("the_stealth_warrior"))
        assertEquals("TheStealthWarrior", formatter.toCamelCase("The-Stealth-Warrior"))
        assertEquals("ABC", formatter.toCamelCase("A-B-C"))
        assertEquals(
            "DpKA[k]PuAnPIKJBMTPTsCAUA",
            formatter.toCamelCase("DpKA[-k-]PuAnPIKJBMTPTsCAUA")
        )
        assertEquals(
            "DpKA[k]PuAnPIKJBMTPTsCAUA",
            formatter.toCamelCase("DpKA[_-k]PuAnPIKJBMTPTsCAUA")
        )
    }
}