package codewars.katas

class CamelCaseFormatter {
    fun toCamelCase(str: String) : String {
        return if (str.isEmpty()) "" else buildString {
            append(str[0])
            var inBrackets = false

            for (i in 1 .. str.indices.last) {
                if (str[i] == '[') inBrackets = true
                if (str[i] == ']') inBrackets = false
                if (
                    str[i-1] in listOf('-', '_') &&
                    str[i] !in listOf('-', '_') &&
                            !inBrackets
                ){
                    append(str[i].uppercaseChar())
                } else if (str[i] !in listOf('-', '_')) {
                    append(str[i])
                }
            }
        }
    }
}