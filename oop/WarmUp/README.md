# Java Day 2 – OOP Basics Warm Up

1. What does OOP stand for? What is it, briefly? 
2. What is a class?
3. Classes in Java contain member variables and methods. Give a brief explanation for each:
   1. Member Variables:
   2. Methods:

4. In groups: The following are lines of code that could belong to a Shopping Cart class, but are out of order. Copy this code into a java file, then arrange the code to make a functional class. (In your groups, once you re-order the code, use your annotate tools to put a * next to any attributes, and a box around any methods. Then someone take a screen shot.)

Answers:
1. Object Oriented Programming - A programming model centered around objects.
2. A class is a blueprint for an object's state and behavior.
3. Member Variables - they define an object's properties or fields. Methods - they define an object's behavior or functionality.
4. Code rearranged below:

```java
public class ShoppingCart {
   public ArrayList<String> items = new ArrayList<String>();
   public String store;
   public double total;
   
   public void add_item(String item, double price){
      this.items.add(item);
      this.total += price;
      }
}
```