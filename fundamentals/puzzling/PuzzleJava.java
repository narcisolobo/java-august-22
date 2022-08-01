import java.util.Random;

public class PuzzleJava {
  /* 
  getTenRolls
  Write a method that will generate and return an array with 10 random numbers between 1 and 20 inclusive. 
  */

  Random random = new Random();

  int[] getTenRolls() {
    int[] tenRolls = new int[10];
    for (int i = 0; i < 10; i++) {
      tenRolls[i] = random.nextInt(20) + 1;
    }
    return tenRolls;
  }

  void generateRandomInts() {
    for (int i = 1; i <= 100; i++) {
      System.out.println(random.nextInt(20));
    }
  }

}