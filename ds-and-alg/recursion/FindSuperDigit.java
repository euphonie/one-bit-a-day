package recursion;

public class FindSuperDigit {
    
    public static int[] intToArrayDigits(int n){
        return Integer.toString(n).chars().map( c -> c- '0').toArray();
    }

    public static int findSuperDigit(int[] digits){
        while(digits.length > 1){
            int partialSuperDigit = 0;
            for (int i = 0; i< digits.length; i++) {
                partialSuperDigit += digits[i];
            }
            digits = FindSuperDigit.intToArrayDigits(partialSuperDigit);
        }
        return Integer.valueOf(digits[0]);
    }

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    public static int superDigit(String n, int k) {
        int[] digits = FindSuperDigit.intToArrayDigits(Integer.valueOf(n));
        int partial = FindSuperDigit.findSuperDigit(digits) * k;
        
        int[] finalDigits = FindSuperDigit.intToArrayDigits(partial);
        return FindSuperDigit.findSuperDigit(finalDigits);
    }


    public static void main(String args[]){
        System.out.println(FindSuperDigit.superDigit("123", 3));
    }
}
