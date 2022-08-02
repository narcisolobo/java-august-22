# OOP Day 1

Learning Objectives for the Day:
- OOP - Encapsulation
- Classes and Objects
- Member variables and methods
- Constructors and method overloading
- this

## What is a class? What is an object?

A class provides the blueprint for an object's state and behavior. It does this through what we call *"members"* - member variables and member methods.

Take, for instance, a car. A car might have member variables for its make, model, and color. It might also have methods for drive, beep, brake, etc.

## How do we declare a class?

We declare a class with the following syntax:

```java
class MyClass {
    // field, constructor, and 
    // method declarations
}
```
**Class Names Should be Pascal Case Nouns!**

The first line can also contain a few other keywords, like the access modifier (*public or private*) and whether it extends a superclass or implements any interfaces.

In general, class declarations can include these components, in order:

1. Modifiers such as public, private, and a number of others that you will encounter later. (However, note that the private modifier can only be applied to Nested Classes.)
2. The class name, with the initial letter capitalized by convention.
3. The name of the class's parent (superclass), if any, preceded by the keyword extends. A class can only extend (subclass) one parent.
4. A comma-separated list of interfaces implemented by the class, if any, preceded by the keyword implements. A class can implement more than one interface.
5. The class body, surrounded by braces, {}.

For now, though, let's keep it simple. Further discussion on modifiers, inheritance, and interfaces will come later in this course.

### Declaring Member Variables

There are several kinds of variables:

- Member variables in a class—these are called fields.
- Variables in a method or block of code—these are called local variables.
- Variables in method declarations—these are called parameters.

The Bicycle class uses the following lines of code to define its fields:

```java
public int cadence;
public int gear;
public int speed;
```
Field declarations are composed of three components, in order:

1. The modifier, such as public or private.
2. The field's type.
3. The field's name.

The fields of Bicycle are named cadence, gear, and speed and are all of data type integer (int). The public keyword identifies these fields as public members, accessible by any object that can access the class.

### Defining Methods
Here is an example of a typical method declaration:

```java
public double calculateSquareFootage(double width, double length) {
    double squareFootage = width * length;
    return squareFootage;
}
```
**Method Names Should be Camel Case Verbs (at least the first word)!**

The only required elements of a method declaration are the method's return type, name, a pair of parentheses, (), and a body between braces, {}.

More generally, method declarations have six components, in order:

1. Modifiers—such as public, private, and others you will learn about later.
2. The return type—the data type of the value returned by the method, or void if the method does not return a value.
3. The method name—the rules for field names apply to method names as well.
4. The parameter list in parenthesis—a comma-separated list of input parameters, preceded by their data types, enclosed by parentheses, (). If there are no parameters, you must use empty parentheses.
5. An exception list (not part of this course).
6. The method body, enclosed between braces—the method's code, including the declaration of local variables, goes here.

----
**Definition: Two of the components of a method declaration comprise the method signature—the method's name and the parameter types.**

----
The signature of the method declared above is:

```java
calculateSquareFootage(double, double)
```
### Creating Objects
Let's create, or *instantiate* a bicycle from the bicycle class.
```java
Bicycle myBike = new Bicycle(0, 0);
```
This statement has three parts:

1. Declaration: `Bicyle myBike` is a variable declaration that associate a variable name with an object type.
2. Instantiation: The `new` keyword is a Java operator that creates the object.
3. Initialization: The `new` operator is followed by a call to a constructor, which initializes the new object.