import java.util.*;

public class Basic13Test {
  public static void main(String[] args) {
    Basic13 basic13 = new Basic13();
    basic13.print1To255();
    basic13.printIntsAndSum0To255();
    int[] integerItems = {6, 3, 9, 11, 0};
    basic13.printArrayVals(integerItems);
    ArrayList<Object> ourObjects = new ArrayList<Object>();
    ourObjects.add("Narciso");
    ourObjects.add(3.12);
    ourObjects.add(0);
    basic13.printArrayVals(ourObjects);
    int[] result = basic13.shiftArrayValsLeft(integerItems);
    for (int item : result) {
      System.out.println(item);
    }
  }
}