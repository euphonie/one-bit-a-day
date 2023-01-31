package codewars.katas

class FindSubstrings {

    fun inArray(array1: Array<String>, array2: Array<String>): Array<String> {
        val inArray = array1.filter {
            array2.any { str -> str.contains(it) }
        }.toSet().sortedBy { it };
        return inArray.toTypedArray();
    }
}