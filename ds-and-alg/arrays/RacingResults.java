package arrays;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class RacingResults {

  static final List<Integer> delegatedRacers = new ArrayList<>();
  static final Map<Integer, Integer> scores =
      new HashMap<Integer, Integer>();

  public static List<Integer> processResults(List<List<Integer>> raceResults) {
    List<Integer> winner =
        new ArrayList<>();

    int firstPlaceName = 0;
    for(List<Integer> result: raceResults) {
      Integer race = result.get(0);
      Integer racerName = result.get(1);
      Integer position = result.get(2);

      int score = computeScore(position);
      if (score == 0) {
        delegatedRacers.add(racerName);
      } else {
        Integer currentScore = scores.getOrDefault(racerName, 0);
        scores.put(racerName, currentScore + score);
        firstPlaceName = updateFirstPlace(firstPlaceName, racerName);
      }
    }

    winner.add(firstPlaceName);
    winner.add(scores.getOrDefault(firstPlaceName,0));
    return winner;
  }

  static int updateFirstPlace(int firstPlaceName, int raceWinner) {
    return
        scores.getOrDefault(firstPlaceName, 0) <
            scores.getOrDefault(raceWinner, 0)
        ? raceWinner : firstPlaceName;

  }

  static int computeScore(Integer position){
    if (position == 6) {return 1;}
    else if (position ==5 ){return 2; }
    else if (position ==4 ){return 3; }
    else if (position ==3 ){return 4; }
    else if (position ==2 ){return 6; }
    else if (position ==1 ){return 10; }
    else { return 0;}
  }



  public static void main(String[] args){
    List<List<Integer>> scores =
        Arrays.asList(
           Arrays.asList(2001, 1001, 3),
           Arrays.asList(2001, 1002, 2),
           Arrays.asList(2002, 1003, 1),
           Arrays.asList(2002, 1001, 2),
           Arrays.asList(2002, 1002, 3),
           Arrays.asList(2001, 1003, 1),
           Arrays.asList(2001, 1004, 7)
        );

    List<Integer> winner = processResults(scores);
    assertEquals(winner.get(0), new Integer(1003));
    assertEquals(winner.get(1), new Integer(20));

    for (Integer racer: delegatedRacers){
      System.out.printf(racer + " ");
    }
  }
}
