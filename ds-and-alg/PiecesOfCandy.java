import java.util.Scanner;

public class PiecesOfCandy {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String args[]){
        int cases = scanner.nextInt();
        
        scanner.nextLine();

        String pieces = scanner.nextLine();
        
        System.out.println(pieces);

        scanner.close();
    }
}