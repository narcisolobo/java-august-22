import java.util.*;

public class Basic13 {

  // print 1 to 255
  void print1To255() {
    for (int i = 1; i <= 255; i++) {
      System.out.println(i);
    }
  }

  void printIntsAndSum0To255() {
    int sum = 0;
    for (int i = 0; i <= 255; i++) {
      sum += i;
      System.out.println(i + " " + sum);
    }
  }

  // Iterate through an array and print each item
  void printArrayVals(int[] items) {
    for (int item : items) {
      System.out.println(item);
    }
  }

  void printArrayVals(ArrayList<Object> items) {
    for (Object item : items) {
      System.out.println(item);
    }
  }

  /* 
  12. Shift Array Values
  shiftArrayValsLeft(arr)
  Given an array, move all values forward (to the left) by one index, dropping the first value and leaving a 0 (zero) value at the end of the array.
  */

  int[] shiftArrayValsLeft(int[] items) {
    for (int i = 0; i < items.length - 1; i++) {
      items[i] = items[i + 1];
    }
    items[items.length - 1] = 0;
    return items;
  }

}