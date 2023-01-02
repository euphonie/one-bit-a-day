package strings;

public class FindPalindrome {

    
    public static int findExtraCharIndex(String s){
        int r = s.length() -1;
        for ( int i = 0; i< s.length(); i++) {
            if (s.charAt(r) != s.charAt(i)) {
                String removeRightChar = s.substring(0, i) + s.substring(i + 1);
                String removeLeftChar = s.substring(0, r) + s.substring(r + 1);
                if (FindPalindrome.checkPalindrome(removeRightChar)){ return i; }
                if (FindPalindrome.checkPalindrome(removeLeftChar)){ return r; }
                return -1;
            }
            r--;
        }
        return -1;
    }
    
    public static boolean checkPalindrome(String s){
        StringBuffer sbr = new StringBuffer(s);
        return s.equals(sbr.reverse().toString());
    }

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int palindromeIndex(String s) {
        // base cases 
        // - is already a palindrome
        // - exceeding index is right/left
        if (FindPalindrome.checkPalindrome(s)){ return -1; }
        if (FindPalindrome.checkPalindrome(s.substring(1, s.length()))) { return 0; }
        if (FindPalindrome.checkPalindrome(s.substring(0, s.length()-1))) { return s.length() -1; }

        // last case: the index is inside the string
        return FindPalindrome.findExtraCharIndex(s);
    }

    public static void main(String args[]) {
        System.out.println(
            String.format(
                "%s", FindPalindrome.palindromeIndex("aacdaa")
            )
        );
    }
    
}
