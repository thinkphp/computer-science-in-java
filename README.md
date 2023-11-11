## Introduction to Java language

```
javac filename.java
java filename


public class Main {
  public static void main(String[] args) {
    System.out.println("Hello World");
  }
}
```

## What is java?

Java is a popular programming language, created in 1995.

It is owned by Oracle, and more than 3 billion devices run Java.

It is used for:

Mobile applications (specially Android apps)
Desktop applications
Web applications
Web servers and application servers
Games
Database connection
And much, much more!

## Why use Java?

Java works on different platforms (Windows, Mac, Linux, Raspberry Pi, etc.)

* It is one of the most popular programming language in the world
* It has a large demand in the current job market
* It is easy to learn and simple to use
* It is open-source and free
* It is secure, fast and powerful
* It has a huge community support (tens of millions of developers)
* Java is an object oriented language which gives a clear structure to programs and allows code to be reused, lowering development costs
* As Java is close to C++ and C#, it makes it easy for programmers to switch to Java or vice versa

## Variables

Variables are containers for storing data values.

In Java, there are different types of variables, for example:

```
String - stores text, such as "Hello". String values are surrounded by double quotes
int - stores integers (whole numbers), without decimals, such as 123 or -123
float - stores floating point numbers, with decimals, such as 19.99 or -19.99
char - stores single characters, such as 'a' or 'B'. Char values are surrounded by single quotes
boolean - stores values with two states: true or false
```

## Data Types

```
int myNum = 5;               // Integer (whole number)
float myFloatNum = 5.99f;    // Floating point number
char myLetter = 'D';         // Character
boolean myBool = true;       // Boolean
String myText = "Hello";     // String
```

## Switch Statement

```
switch(expression) {
  case x:
    // code block
    break;
  case y:
    // code block
    break;
  default:
    // code block
}
```
## While Statement

```
int i = 0;
while (i < 5) {
  System.out.println(i);
  i++;
}

int i = 0;
do {
  System.out.println(i);
  i++;
}
while (i < 5);
```

## For Statement

```
// Outer loop
for (int i = 1; i <= 2; i++) {
  System.out.println("Outer: " + i); // Executes 2 times
  
  // Inner loop
  for (int j = 1; j <= 3; j++) {
    System.out.println(" Inner: " + j); // Executes 6 times (2 * 3)
  }
} 
```

## For-each Loop

```
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
for (String i : cars) {
  System.out.println(i);
}
```

### References

https://introcs.cs.princeton.edu/java/home/

https://cs.stanford.edu/people/eroberts/books/index.html

https://web.stanford.edu/class/archive/cs/cs106a/cs106a.1124/lectures/03/Slides.pdf


### GUI

https://www3.ntu.edu.sg/home/ehchua/programming/java/j4a_gui.html


### JavaFX 

https://replit.com/@thinkphp/JavaFXProjects#Main.java

### Java AWT

### Java Swing

### Algorithms and Data Structures
