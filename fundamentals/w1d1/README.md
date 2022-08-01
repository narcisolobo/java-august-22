# Java Stack - Week 1, Day 1

## Welcome to Java!

### What is Java and Why Do We Learn It?

### Variables
#### Primitive Datatypes
- **byte** - The byte data type is an 8-bit integer. It has a minimum value of -128 and a maximum value of 127 (inclusive). The byte data type can be useful for saving memory in large arrays, where the memory savings actually matters. They can also be used in place of int where their limits help to clarify your code; the fact that a variable's range is limited can serve as a form of documentation.
- **short**: The short data type is a 16-bit integer. It has a minimum value of -32,768 and a maximum value of 32,767 (inclusive). As with byte, the same guidelines apply: you can use a short to save memory in large arrays, in situations where the memory savings actually matters.
- **int**: By default, the int data type is a 32-bit integer, which has a minimum value of -2 to the 31st power and a maximum value of 2to the 31st power minus 1. In Java SE 8 and later, you can use the int data type to represent an unsigned 32-bit integer, which has a minimum value of 0 and a maximum value of 232-1.
- **long**: The long data type is a 64-bit integer. The signed long has a minimum value of -2 to the 63rd power and a maximum value of 2 to the 63rd power minus 1. Use this data type when you need a range of values wider than those provided by int.
- **float**: The float data type is a single-precision 32-bit IEEE 754 floating point. As with the recommendations for byte and short, use a float (instead of double) if you need to save memory in large arrays of floating point numbers. This data type should never be used for precise values, such as currency. For that, you will need to use the java.math.BigDecimal class instead.
- **double**: The double data type is a double-precision 64-bit IEEE 754 floating point. For decimal values, this data type is generally the default choice. As mentioned above, this data type should never be used for precise values, such as currency.
- **boolean**: The boolean data type has only two possible values: true and false. Use this data type for simple flags that track true/false conditions. This data type represents one bit of information, but its "size" isn't something that's precisely defined.
- **char**: The char data type is a single 16-bit Unicode character.