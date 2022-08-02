# Week 1, Day 2 - More OOP

This afternoon, we'll discuss the following:
- Getters, Setters, and Access Modifiers
- Constructors and Overloading
- the `this` keyword
- the `static` keyword

## Getters, Setters, and Access Modifiers

In the spirit of encapsulation, it is customary to make fields `private`. This means they can only be *directly* accessed from the `Bicycle` class itself.

However, we still need access to these values. This can be done *indirectly* by adding `public` methods that *get* and *set* the values for us.

We call these special methods **getters and setters**.

Let's redeclare our `Bicycle` member variables to have `private` access and include some getters and setters.

```java
public class Bicycle {
	// private member variables
    private int cadence;
    private int gear;
    private int speed;

	public Bicycle(int startCadence, int startSpeed, int startGear) {
		cadence = startCadence;
		speed = startSpeed;
		gear = startGear;
}

	// getters and setters
	public int getCadence() {
		return cadence;
	}

	public void setCadence(int newCadence) {
		cadence = newCadence;
	}
	
	public int getGear() {
        return gear;
    }
        
    public void setGear(int newValue) {
        gear = newValue;
    }
        
    public int getSpeed() {
        return speed;
    }
        
    public void applyBrake(int decrement) {
        speed -= decrement;
    }
        
    public void speedUp(int increment) {
        speed += increment;
    }
}
```

Generally, we follow this Camel Case naming convention for getters and setters - 'get' or 'set', followed by the member variable we're getting or setting. But notice the setters for the speed member. There are two of them. This is a great example of a good reason to break from that naming convention if another approach makes more sense.

### Access Modifiers
|Modifier|Class|Package|Subclass|World|
|--------|-----|-------|--------|-----|
|public|Y|Y|Y|Y|
|protected|Y|Y|Y|N|
|*no modifier*|Y|Y|N|N|
|private|Y|N|N|N|

### Types
All variables must have a type. You can use primitive types such as int, float, boolean, etc. Or you can use reference types, such as strings, arrays, or objects.

## Constructors and Overloading
A class contains constructors that are invoked to create objects from the class blueprint. Constructor declarations look like method declarations—*except that they use the name of the class and have no return type*. For example, Bicycle has one constructor:

```java
public Bicycle(int startCadence, int startSpeed, int startGear) {
    cadence = startCadence;
    speed = startSpeed;
    gear = startGear;
}
```

To create a new Bicycle object called myBike, a constructor is called by the new operator:

```java
Bicycle myBike = new Bicycle(30, 0, 8);
```
`new Bicycle(30, 0, 8)` creates space in memory for the object and initializes its fields.

Although Bicycle only has one constructor, it could have others, including a no-argument constructor:

```java
public Bicycle() {
    cadence = 10;
    speed = 0;
    gear = 1;
}
```
`Bicycle yourBike = new Bicycle();` invokes the no-argument constructor to create a new Bicycle object called yourBike.

Both constructors could have been declared in Bicycle because they have different argument lists. The Java platform differentiates constructors on the basis of their *method signatures* - the number of arguments in the list and their types (the same applies to methods). *We call this method overloading.* You cannot write two constructors that have the same number and type of arguments for the same class, because the platform would not be able to tell them apart. Doing so causes a compile-time error.

Let's take a deeper look at overloading methods. Below, let's overload the constructor method:

```java
public Bicycle(int startCadence, int startSpeed, int startGear) {
    cadence = startCadence;
    speed = startSpeed;
    gear = startGear;
}

// create a no-argument constructor

// create a one-argument constructor

// create a two-argument constructor
```

What would these overloaded constructor methods' signatures look like? Let's write those below:

```java
// Your code here
```

## The `this` Keyword
Within an instance method or a constructor, this is a reference to the current object — the object whose method or constructor is being called. You can refer to any member of the current object from within an instance method or a constructor by using this.

In our `Bicycle` class, we have designed our constructors to have parameters whose names are different from the member variables they initialize - `startCadence` initializes `cadence`, `startGear` initializes `gear`, etc. But we could have used the same variable name for the parameter variables and member variables - `cadence` for `cadence`, `gear` for `gear`, and so on. You will see this "shadowing" of the member by the parameter more often than not. When we do this, the Java compiler cannot differentiate between the two variables. The this keyword is used in these situations.

Let's rewrite the three-argument constructor with shadowed parameters and the this keyword below:

```java
// Your code here
```
## The `static` Keyword
### Class Variables
When a number of objects are created from the same class blueprint, they each have their own distinct copies of instance variables. In the case of the Bicycle class, the instance variables are cadence, gear, and speed. Each Bicycle object has its own values for these variables, stored in different memory locations.

Sometimes, you want to have variables that are common to all objects. This is accomplished with the `static` modifier. Fields that have the `static` modifier in their declaration are called `static` fields or class variables. They are associated with the class, rather than with any object. Every instance of the class shares one class variable, which is in one fixed location in memory.

For example, suppose you want to create a number of `Bicycle` objects and assign each a serial number, beginning with 1 for the first object. This ID number is unique to each object and is therefore an instance variable. At the same time, you need a field to keep track of how many `Bicycle` objects have been created so that you know what ID to assign to the next one. Such a field is not related to any individual object, but to the class as a whole. For this you need a class variable, something like `numberOfBicycles`.

```java
public class Bicycle {
        
    private int cadence;
    private int gear;
    private int speed;
        
    // add an instance variable for the object ID
    private int id;
    
    // add a class variable for the
    // number of Bicycle objects instantiated
    private static int numberOfBicycles = 0;
}
```
Class variables should be referenced by the class name itself, as in

```java
Bicycle.numberOfBicycles
```

This makes it clear that they are class variables.

### Class Methods
The Java programming language supports static methods as well as static variables. Static methods, which have the static modifier in their declarations, should be invoked with the class name:
```java
ClassName.methodName(args)
```
A common use for static methods is to access static fields. For example, we could add a static method to the Bicycle class to access the numberOfBicycles static field:

```java
public static int getNumberOfBicycles() {
    return numberOfBicycles;
}
```