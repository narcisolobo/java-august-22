# Week 1, Day 3 AM - Java OOP Advanced

This morning, we'll discuss the following:
- The Four Pillars of OOP
- Interfaces
- Abstract Classes

## The Four Pillars of OOP - "A PIE"

### Encapsulation

---
In OOP, we group together related data in classes and objects. This is only one facet of encapsulation. Encapsulation also helps us make sure our "sensitive" data is hidden from users. To achieve this, we declare our member variables/fields as `private` and expose them with `public` *getters and setters.*

```java
public class Warrior {
  // private field
  private int strength;

  // constructor
  public Warrior() {
    strength = 20;
  }
  
  // getters and setters
  public int getStrength() {
    return strength;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }
}
```
**Why Encapsulation?**

- Better control of class attributes and methods
- Class attributes can be made read-only (if you only use the get method), or write-only (if you only use the set method)
- Flexible: the programmer can change one part of the code without affecting other parts
- Increased security of data

### Inheritance

---
In OOP, we can inherit tfields and methods from one class to another.

- subclass (child) - the class that inherits from another class
- superclass (parent) - the class being inherited from

To inherit from a class, we use the `extends` keyword. Let's say we have a `Character` class, like so:

```java
public class Character {
  private int health;

  public Character() {
    health = 100;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

}
```
We can then inherit from that class in our `Warrior` class.

```java
public class Warrior extends Character {
  // private field
  private int strength;

  // constructor
  public Warrior() {
    strength = 20;
  }
  
  // getters and setters
  public int getStrength() {
    return strength;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }
}
```
Now the `Warrior` class inherits all fields and methods from the `Character` class!

```java
// main method
Warrior warrior = new Warrior();
System.out.println(warrior.getHealth()) // prints 100
```

**Why And When To Use Inheritance?**

- It is useful for code reusability: reuse attributes and methods of an existing class when you create a new class.
- Also take a look at polymorphism, which allows us to implement inherited methods differently from subclass to subclass.
  
## Abstraction

---
Abstraction is a sister pillar of encapsulation. Data abstraction is the process of hiding certain details and showing only essential information to the user.
Abstraction can be achieved with either abstract classes or interfaces.

Think about our superclass that `Warrior` extends. Does it really make sense to instantiate a `Character` object? Probably not. This is a great opportunity to *abstract* that class from the user.

```java
abstract class Character {
  private int health;

  public Character() {
    health = 100;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void intimidate() {
    System.out.println("I'm coming for you!");
  }
}
```

**Why And When To Use Abstract Classes and Methods?**
---
- Code reuseability - it helps keep our code DRY. Inherited fields and methods can be shared amongst subclasses.
- To achieve security - hide certain details and only show the important details of an object.

## Polymorphism

---
Polymorphism means "many forms", and it occurs when we have many classes that are related to each other by inheritance.

Inheritance gives subclasses the ability to use their superclass' fields and methods. But what if we want our `Warrior` subclass to intimidate his enemies in a different way than what is specified in the `Character` superclass?

Polymorphism lets us override any inherited methods and implement them however we like.

```java
public class Warrior extends Character {
  // private field
  private int strength;

  // constructor
  public Warrior() {
    strength = 20;
  }
  
  // getters and setters
  public int getStrength() {
    return strength;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  // overridden method with a difference of implementation
  public void intimidate() {
    System.out.println("I'm gonna git you sucka!")
  }
}
```
```java
// main method
Warrior warrior = new Warrior();
System.out.println(warrior.getHealth()) // prints 100
```

**Why And When To Use "Inheritance" and "Polymorphism"?**
- It is useful for code reusability: reuse attributes and methods of an existing class when you create a new class.
- Flexibility - the power of overriding superclass methods.

## Interfaces

---

Another way to achieve abstraction in our Java code is by using interfaces. An interface typically contains bodyless methods. It is up to the classes that use that interface to fill the method bodies in with their own implementations of each method.

An interface can be thought of as a "contract". Any class that implements an interface must use every method in that interface.

Let's take a look at a possible interface for our `Warrior` class. Perhaps an `Attackable` interface that can be shared amongst objects that can attack other objects. We declare an interface using the `interface` keyword.

**Use Adjectives When Naming Interfaces**

```java
public interface Attackable {
    abstract void attack();
}
```

Now our `Warrior` class can use the Attackable interface like so:

```java
public class Warrior extends Character implements Attackable {
	private int strength;

	public Warrior() {
		strength = 20;
	}
	
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void intimidate() {
		System.out.println("I'm gonna git you sucka!")
	}

	public void attack() {
		System.out.println("The warrior attacks with a sword!")
	}
}
```
### Notes on Interfaces:
- Like abstract classes, interfaces cannot be used to create objects (in the example above, it is not possible to create an "Attackable" object in the main method.)
- Interface methods do not have a body - the body is provided by the "implementing" class
- On implementation of an interface, you must override all of its methods
- Interface methods are by default abstract and public
- Interface attributes are by default public, static and final
- An interface cannot contain a constructor (as it cannot be used to create objects)


**Why And When To Use Interfaces?**
1) To achieve security - hide certain details and only show the important details of an object (interface).

2) Java does not support "multiple inheritance" (a class can only inherit from one superclass). However, it can be achieved with interfaces, because the class can implement multiple interfaces. *Note: To implement multiple interfaces, separate them with a comma*.

### Abstracts vs Interfaces

---
Now that we've seen both Abstract Classes and Interfaces it will be important for us to learn when to use one vs the other.

|**Abstract Classes**|**Interfaces**|
|----------------|----------|
| A generic version of a class to be inherited from | Identifies behaviors an implementing class must satisfy |
| Cannot be instantiated | Cannot be instantiated |
| Can have a constructor | Doesn't have a constructor |
| Can have instance variables	| Can only have static final variables |
| A Java class can only inherit from one parent class (at a time)	| A Java class can implement multiple Interfaces |