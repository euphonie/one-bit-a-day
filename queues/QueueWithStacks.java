package queues;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class QueueWithStacks {
    
    private static Stack<Integer> s1 = new Stack<Integer>();
    private static Stack<Integer> s2 = new Stack<Integer>();
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void slowEnQueue(int n) {
       /**
        * Leverages the block copy used inside Vector's implementation.
        * The use of System.arraycopy outperforms a n**2 shift of single elements
        * from one stack to the other and back
        */
        s1.add(0, n);
    }

    public static void fastEnQueue(int n){
        s1.push(n);
    }

    public static int fastDeQueue() {
        if (s1.isEmpty()){
            System.exit(0);
        }

        return s1.pop();
    }

    public static int slowDeQueue() {
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int x = s2.pop();
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return x;
    }

    public static int slowPeek() {
        if (s1.isEmpty()) { return s2.peek(); }
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int x =  s2.peek();
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return x;
    }

    public static int fastPeek() {
        if (s1.isEmpty()){ System.exit(0); }
        return s1.peek();
    }

    public static void main(String args[]) throws IOException {

        int cases = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        while (scanner.hasNext() && cases > 1) {
            String operation = scanner.nextLine();
            String[] parts = operation.split(" ");
            
            int operationType = -1, value = -1;
            if (parts.length > 1){
                operationType = Integer.valueOf(parts[0]);
                value = Integer.valueOf(parts[1]);
            } else {
                operationType = Integer.valueOf(parts[0]);
            }

            if (operationType == 1){
                QueueWithStacks.slowEnQueue(value);
            } else if (operationType == 2) {
                QueueWithStacks.fastDeQueue();
            } else {
                System.out.println(QueueWithStacks.fastPeek());
            }
            System.out.println(Arrays.toString(s1.toArray()));
            cases--;
        }

        scanner.close();
    }
}
