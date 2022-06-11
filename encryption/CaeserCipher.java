package encryption;

public class CaeserCipher {
    
    public static int shiftAscii(char ascii, int k) {
        int asciiIdx = (int) ascii;
        int correctedShift = (k % 26);
        if (Character.isUpperCase(ascii)) {
            int overflow = (asciiIdx + correctedShift) - (int)'Z';
            return overflow > 0  ? 64+ overflow  : asciiIdx + correctedShift;
        } else {
            int overflow = (asciiIdx + correctedShift) - (int)'z';
            return overflow > 0  ? 96+ overflow  : asciiIdx + correctedShift;
        }
    }

    public static String execute(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            
            char currChar = s.charAt(i);
            
            if (Character.isAlphabetic(currChar)) {
                int shiftedAscii = CaeserCipher.shiftAscii(currChar, k);
                sb.append((char)shiftedAscii);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        String cipheredString = CaeserCipher.execute("www.abc.xy", 87);
        assert cipheredString == "fff.jkl.gh";
    }
}
