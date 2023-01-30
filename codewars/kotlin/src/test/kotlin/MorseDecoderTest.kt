import codewars.katas.MorseCodeDecoder
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MorseDecoderTest {

    @Test
    fun decodeHeyJude(){
        val decoder = MorseCodeDecoder()
        assertEquals("HEY JUDE", decoder.decodeMorse(".... . -.--   .--- ..- -.. ."))
        assertEquals("HEY JUDE", 
            decoder.decodeMorse("     .... . -.--   .--- ..- -.. .      "))
    }

}