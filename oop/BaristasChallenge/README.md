Order Class Set Up:
Private Member Variables:

Set the member variables to private instead of  public.
This time do not include the total member variable, as we will be using a method for getting the total.
Constructor: 

Add a constructor to your Order class that takes no arguments, but sets the name to "Guest" and initializes the items array to an empty ArrayList<Item> 
Overloaded Constructor: 

Add an overloaded constructor for Order that takes String name as an argument, so you can create an instance with a name.
Accessors & Mutators (Getters and Setters)

Create getters and setters for all the member variables, using good naming convention for boolean accessors.

Order Class Methods:
addItem

Create a method called addItem  that takes an Item object as an argument and adds the item to the order's items array. No need to return anything.

Hint: How do you get the price of a given item instance from outside the Item class?

getStatusMessage

Create a method called getStatusMessage that returns a String message. If the order is ready, return "Your order is ready.", if not, return "Thank you for waiting. Your order will be ready soon."
getOrderTotal

Similar to the getOrderTotal method from the Cafe Business Logic assignment, create a method called getOrderTotal that sums together each of the item's prices, and returns the total amount. 
Note: This time, you do not need to pass in a list of prices, because each item object in this order's items array has its own price, that you can access using a getter!

display

Similar to the displayMenu function from the Cafe Business Logic assignment, create a method called display that prints out the order information like so: