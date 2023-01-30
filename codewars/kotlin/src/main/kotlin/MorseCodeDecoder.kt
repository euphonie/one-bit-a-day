package codewars.katas

class MorseCodeDecoder {
    
    private val MorseCode : Map<String, Char> = mapOf(
        ".-" to 'a',
        "-..." to 'b',
        "-.-." to 'c',
        "-.." to 'd',
        "." to 'e',
        "..-." to 'f',
        "--." to 'g',
        "...." to 'h',
        ".." to 'i',
        ".---" to 'j',
        "-.-" to 'k',
        ".-.." to 'l',
        "--" to 'm',
        "-." to 'n',
        "---" to 'o',
        ".--." to 'p',
        "--.-" to 'q',
        ".-." to 'r',
        "..." to 's',
        "-" to 't',
        "..-" to 'u',
        "...-" to 'v',
        ".--" to 'w',
        "-..-" to 'x',
        "-.--" to 'y',
        "--.." to 'z',
        ".----" to '1',
        "..---" to '2',
        "...--" to '3',
        "....-" to '4',
        "....." to '5',
        "-...." to '6',
        "--..." to '7',
        "---.." to '8',
        "----." to '9',
        "-----" to '0'
    )
    
    fun decodeMorse(code: String) : String {
        val breakIntoWords : (String) -> List<String> =
            {code:String -> code.split("   ")}
        val translateWord : (String) -> String =
            {w:String -> w.split(" ").joinToString("") {MorseCode.getOrDefault(it, "").toString()}   }

        return breakIntoWords(code.trim())
            .joinToString(" ") {
                translateWord(it)
            }.uppercase()
    }
}