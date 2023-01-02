package factorization;

/**
 * Problem description:
 * 
 * Two players are playing a game of Tower Breakers! Player  always moves first, and both players always play optimally.The rules of the game are as follows:

    Initially there are n towers.
    Each tower is of height m.
    The players move in alternating turns.
    In each turn, a player can choose a tower of height  and reduce its height to y, where 1<=y<x and y evenly divides x.
    If the current player is unable to make a move, they lose the game.
    Given the values of  and , determine which player will win. If the first player wins, return . Otherwise, return 2.
 */
public class TowerBreakers {


    public static int divisor(int number)
    {
        int i;
        for (i = 2; i <= Math.sqrt(number); i++)
        {
            if (number % i == 0)
            {
                return number/i;
            }
        }
        return 1;
    }

    public static int minStepAllowed(int n, int m) {
        int turns = 0;
        
        int divisor = m;
        while (m > 1) {
            divisor = TowerBreakers.divisor(m);
            m -= divisor;
            System.out.println(divisor + " " + m);
            turns++;
        }
        turns *= n;
        return turns % 2 == 1 ? 1 : 2;
    }

    public static int mostOptimalStep(int n, int m) {
        if (m == 1){ return 2; }
        return n % 2 == 1 ? 1 : 2;
    }

    public static void main(String args[]) {
        System.out.println(TowerBreakers.mostOptimalStep(100000, 1));
    }
    
}
