package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SimpleTextEditor {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder S = new StringBuilder();
    private static Stack<String> history = new Stack<String>();


    public static void main(String[] args) throws IOException {
        int ops = Integer.parseInt(br.readLine().trim());

        while (ops-- > 0){
           
            String line = br.readLine().trim();
            int type = Integer.parseInt(line.substring(0, 1));

            
            switch(type){
                case 1:
                    String value = line.substring(2, line.length());
                    history.push(S.toString());
                    S.append(value);
                break;
                case 2:
                    int removeChars = Integer.parseInt(line.substring(2, line.length()));
                    history.push(S.toString());
                    S.setLength(S.length() - removeChars);
                break;
                case 3:
                    int idx = Integer.parseInt(line.substring(2, line.length()));
                    System.out.println(S.charAt(idx -1));
                break;
                case 4:
                    if (history.isEmpty()) { return; }
                     S = new StringBuilder(history.pop());
                break;
                default: 
                    System.exit(0);
                break;
            }
        }

        br.close();
    }
}
