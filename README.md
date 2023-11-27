## Essential Java

The javac command is used for compiling Java source files to bytecode files. Bytecode files are platform independent.
This means that you can compile your code on one kind of hardware and operating system, and then run the code on any other platform that supports Java.

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

* Mobile applications (specially Android apps)
* Desktop applications
* Web applications
* Web servers and application servers
* Games
* Database connection
* And much, much more!

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

## Input/Output

```
import java.util.Scanner;

class Input {
    public static void main(String[] args) {
    	
        Scanner input = new Scanner(System.in);
    	
        // Getting float input
        System.out.print("Enter float: ");
        float myFloat = input.nextFloat();
        System.out.println("Float entered = " + myFloat);
    	
        // Getting double input
        System.out.print("Enter double: ");
        double myDouble = input.nextDouble();
        System.out.println("Double entered = " + myDouble);
    	
        // Getting String input
        System.out.print("Enter text: ");
        String myString = input.next();
        System.out.println("Text entered = " + myString);
    }
}

```

## Switch Statement Control Flow

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
## While Statement Control Flow

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

## For Statement Control Flow

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

## For-each Loop Statement Control Flow

```
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
for (String i : cars) {
  System.out.println(i);
}
```

## Break/Continue Statement Control Flow

```
for (int i = 0; i < 10; i++) {
  if (i == 4) {
    break;
  }
  System.out.println(i);
}

for (int i = 0; i < 10; i++) {
  if (i == 4) {
    continue;
  }
  System.out.println(i);
}
```

## Static keyword

```
public class StaticDepartment{
    public static int numberOfWorker= 0;
    public String name;
    
    public Department(String name) {
        this.name = name;
        numberOfWorker++; // increment the static variable every time a new 							//Person is created
    }

    public static void main(String[] args) {
      Department dpt1 = new Department("Admin");
      System.out.println(Department.numberOfWorker); // output: 1

      Department dpt2 = new Department ("Finance");
      System.out.println(Department.numberOfWorker); // output: 2

      Department dpt3 = new Department ("Software");
      System.out.println(Department.numberOfWorker); // output: 3
    }
}

```
## Java Exceptions - Try .. Catch

```
public class Main {
  public static void main(String[ ] args) {
    try {
      int[] myNumbers = {1, 2, 3};
      System.out.println(myNumbers[10]);
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    }
  }
}
```

## The Throw keyword

```
public class Main {
  static void checkAge(int age) {
    if (age < 18) {
      throw new ArithmeticException("Access denied - You must be at least 18 years old.");
    }
    else {
      System.out.println("Access granted - You are old enough!");
    }
  }

  public static void main(String[] args) {
    checkAge(15); // Set age to 15 (which is below 18...)
  }
}
```
## Java Strings

```
String txt = "Please locate where 'locate' occurs!";

System.out.println(txt.indexOf("locate")); // Outputs 7
System.out.println("The length of the txt string is: " + txt.length());
System.out.println(txt.toUpperCase());   // Outputs "HELLO WORLD"
System.out.println(txt.toLowerCase());   // Outputs "hello world"

//concatenation
String firstName = "John";
String lastName = "Doe";
System.out.println(firstName + " " + lastName);

//count words
String words = "One Two Three Four";
int countWords = words.split("\\s").length;
System.out.println(countWords);

//reverse a string
String originalStr = "Hello";
String reversedStr = "";

for (int i = 0; i < originalStr.length(); i++) {
  reversedStr = originalStr.charAt(i) + reversedStr;
}

System.out.println("Reversed string: "+ reversedStr);
```

## Java Arrays

```
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
cars[0] = "Opel";
System.out.println(cars[0]);
// Now outputs Opel instead of Volvo

// Loop through an array

String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
for (int i = 0; i < cars.length; i++) {
  System.out.println(cars[i]);
}

String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
for (String i : cars) {
  System.out.println(i);
}

public class Main {
  public static void main(String[] args) {
    int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
    for (int i = 0; i < myNumbers.length; ++i) {
      for(int j = 0; j < myNumbers[i].length; ++j) {
        System.out.println(myNumbers[i][j]);
      }
    }
  }
}
```
## File Handling

```
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

public class CreateFile {
  public static void main(String[] args) {
    try {
      File myObj = new File("filename.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}


import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class WriteToFile {
  public static void main(String[] args) {
    try {
      FileWriter myWriter = new FileWriter("filename.txt");
      myWriter.write("Files in Java might be tricky, but it is fun enough!");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {
  public static void main(String[] args) {
    try {
      File myObj = new File("filename.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}

import java.io.File;  // Import the File class

public class DeleteFile {
  public static void main(String[] args) { 
    File myObj = new File("filename.txt"); 
    if (myObj.delete()) { 
      System.out.println("Deleted the file: " + myObj.getName());
    } else {
      System.out.println("Failed to delete the file.");
    } 
  } 
}

import java.io.File; 

public class DeleteFolder {
  public static void main(String[] args) { 
    File myObj = new File("C:\\Users\\MyName\\Test"); 
    if (myObj.delete()) { 
      System.out.println("Deleted the folder: " + myObj.getName());
    } else {
      System.out.println("Failed to delete the folder.");
    } 
  } 
}
```

## Object-Oriented Programming

```
public class Main {
  int x = 5;

  public static void main(String[] args) {
    Main myObj = new Main();
    System.out.println(myObj.x);
  }
}

public class Main {
  int x = 5;

  public static void main(String[] args) {
    Main myObj1 = new Main();  // Object 1
    Main myObj2 = new Main();  // Object 2
    System.out.println(myObj1.x);
    System.out.println(myObj2.x);
  }
}

public class Main {
  final int x = 10;

  public static void main(String[] args) {
    Main myObj = new Main();
    myObj.x = 25; // will generate an error: cannot assign a value to a final variable
    System.out.println(myObj.x);
  }
}

public class Main {
  String fname = "John";
  String lname = "Doe";
  int age = 24;

  public static void main(String[] args) {
    Main myObj = new Main();
    System.out.println("Name: " + myObj.fname + " " + myObj.lname);
    System.out.println("Age: " + myObj.age);
  }
}

public class Main {
  static void myMethod() {
    System.out.println("Hello World!");
  }

  public static void main(String[] args) {
    myMethod();
  }
}

//Static vs public

public class Main {
  // Static method
  static void myStaticMethod() {
    System.out.println("Static methods can be called without creating objects");
  }

  // Public method
  public void myPublicMethod() {
    System.out.println("Public methods must be called by creating objects");
  }

  // Main method
  public static void main(String[] args) {
    myStaticMethod(); // Call the static method
    // myPublicMethod(); This would compile an error

    Main myObj = new Main(); // Create an object of Main
    myObj.myPublicMethod(); // Call the public method on the object
  }
}

// Outputs "Hello World!"


// Create a Main class
public class Main {
 
  // Create a fullThrottle() method
  public void fullThrottle() {
    System.out.println("The car is going as fast as it can!");
  }

  // Create a speed() method and add a parameter
  public void speed(int maxSpeed) {
    System.out.println("Max speed is: " + maxSpeed);
  }

  // Inside main, call the methods on the myCar object
  public static void main(String[] args) {
    Main myCar = new Main();   // Create a myCar object
    myCar.fullThrottle();      // Call the fullThrottle() method
    myCar.speed(200);          // Call the speed() method
  }
}

// The car is going as fast as it can!
// Max speed is: 200


//Constructors.
//A constructor is a special method that creates an object and provides a reference to that object.
//Java automatically invokes a constructor when a client program uses the keyword new.
//Each time that a client invokes a constructor, Java automatically:

=> Allocates memory for the object
=> Invokes the constructor code to initialize the instance variables
=> Returns a reference to the newly created object

public class Main {
  int modelYear;
  String modelName;

  public Main(int year, String name) {
    modelYear = year;
    modelName = name;
  }

  public static void main(String[] args) {
    Main myCar = new Main(1969, "Mustang");
    System.out.println(myCar.modelYear + " " + myCar.modelName);
  }
}

// Outputs 1969 Mustang


//Encapsulation
public class Person {
  private String name; // private = restricted access

  // Getter
  public String getName() {
    return name;
  }

  // Setter
  public void setName(String newName) {
    this.name = newName;
  }
}

public class Main {
  public static void main(String[] args) {
    Person myObj = new Person();
    myObj.setName("John"); // Set the value of the name variable to "John"
    System.out.println(myObj.getName());
  }
}

//Inheritance

class Vehicle {
  protected String brand = "Ford";        // Vehicle attribute
  public void honk() {                    // Vehicle method
    System.out.println("Tuut, tuut!");
  }
}

class Car extends Vehicle {
  private String modelName = "Mustang";    // Car attribute
  public static void main(String[] args) {

    // Create a myCar object
    Car myCar = new Car();

    // Call the honk() method (from the Vehicle class) on the myCar object
    myCar.honk();

    // Display the value of the brand attribute (from the Vehicle class) and the value of the modelName from the Car class
    System.out.println(myCar.brand + " " + myCar.modelName);
  }
}


//Polymorphism

class Animal {
  public void animalSound() {
    System.out.println("The animal makes a sound");
  }
}

class Pig extends Animal {
  public void animalSound() {
    System.out.println("The pig says: wee wee");
  }
}

class Dog extends Animal {
  public void animalSound() {
    System.out.println("The dog says: bow wow");
  }
}

class Main {
  public static void main(String[] args) {
    Animal myAnimal = new Animal();  // Create a Animal object
    Animal myPig = new Pig();  // Create a Pig object
    Animal myDog = new Dog();  // Create a Dog object
    myAnimal.animalSound();
    myPig.animalSound();
    myDog.animalSound();
  }
}
```

## Java Classes - import java.util.*

```

// Import the HashMap class
import java.util.HashMap;

public class Main {
  public static void main(String[] args) {
    // Create a HashMap object called capitalCities
    HashMap<String, String> capitalCities = new HashMap<String, String>();

    // Add keys and values (Country, City)
    capitalCities.put("England", "London");
    capitalCities.put("Germany", "Berlin");
    capitalCities.put("Norway", "Oslo");
    capitalCities.put("USA", "Washington DC");
    System.out.println(capitalCities);
  }

  //access an item
  capitalCities.get("England");

  //remove an item
  capitalCities.remove("England");

  //get the size
  //loop through a HashMap
  // Print keys
  for (String i : capitalCities.keySet()) {
       System.out.println(i);
  }
}


// Import the HashMap class
import java.util.HashMap;

public class Main {
  public static void main(String[] args) {

    // Create a HashMap object called people
    HashMap<String, Integer> people = new HashMap<String, Integer>();


    // Add keys and values (Name, Age)
    people.put("John", 32);
    people.put("Steve", 30);
    people.put("Angie", 33);

    for (String i : people.keySet()) {
      System.out.println("key: " + i + " value: " + people.get(i));
    }
  }
}


// Import the LinkedList class
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) {
    LinkedList<String> cars = new LinkedList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    System.out.println(cars);
  }
}

// Import the HashSet class
import java.util.HashSet;

public class Main {
  public static void main(String[] args) {
    HashSet<String> cars = new HashSet<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("BMW");
    cars.add("Mazda");
    System.out.println(cars);
  }
}

cars.contains("Mazda");
cars.size();
for (String i : cars) {
  System.out.println(i);
}

import java.util.HashSet;

public class Main {
  public static void main(String[] args) {

    // Create a HashSet object called numbers
    HashSet<Integer> numbers = new HashSet<Integer>();

    // Add values to the set
    numbers.add(4);
    numbers.add(7);
    numbers.add(8);

    // Show which numbers between 1 and 10 are in the set
    for(int i = 1; i <= 10; i++) {
      if(numbers.contains(i)) {
        System.out.println(i + " was found in the set.");
      } else {
        System.out.println(i + " was not found in the set.");
      }
    }
  }
}
```

https://www3.ntu.edu.sg/home/ehchua/programming/java/j4a_gui.html

### Graphical User Interface GUI JavaFX 

```
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.paint.Color; 
import javafx.stage.Stage;  

public class JavafxSample extends Application { 
   @Override     
   public void start(Stage primaryStage) throws Exception {            
      //creating a Group object 
      Group group = new Group(); 
       
      //Creating a Scene by passing the group object, height and width   
      Scene scene = new Scene(group ,600, 300); 
      
      //setting color to the scene 
      scene.setFill(Color.BROWN);  
      
      //Setting the title to Stage. 
      primaryStage.setTitle("Sample Application"); 
   
      //Adding the scene to Stage 
      primaryStage.setScene(scene); 
       
      //Displaying the contents of the stage 
      primaryStage.show(); 
   }    
   public static void main(String args[]){          
      launch(args);     
   }     
```

https://replit.com/@thinkphp/JavaFXProjects#Main.java

### Graphical User Interface GUI AWT

```
// Java AWT Program for Hello World 
import java.awt.*; 
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 

// Driver Class 
public class AWT_Example { 
	// main function 
	public static void main(String[] args) 
	{ 
		// Declaring a Frame and Label 
		Frame frame = new Frame("Basic Program"); 
		Label label = new Label("Hello World!"); 

		// Aligning the label to CENTER 
		label.setAlignment(Label.CENTER); 

		// Adding Label and Setting 
		// the Size of the Frame 
		frame.add(label); 
		frame.setSize(300, 300); 

		// Making the Frame visible 
		frame.setVisible(true); 

		// Using WindowListener for closing the window 
		frame.addWindowListener(new WindowAdapter() { 
			@Override
			public void windowClosing(WindowEvent e) 
			{ 
				System.exit(0); 
			} 
		}); 
	} 
}

```

### Graphical User Interface GUI Swing

```
import java.io.*;
import javax.swing.*;
 
// Main class
class GFG {
 
    // Main driver method
    public static void main(String[] args)
    {
        JFrame frame
            = new JFrame(); // creating instance of JFrame
 
        JButton button = new JButton(
            " GFG WebSite Click"); // creating instance of
                                   // JButton
        button.setBounds(
            150, 200, 220,
            50); // x axis, y axis, width, height
 
        frame.add(button); // adding button in JFrame
 
        frame.setSize(500, 600); // 400 width and 500 height
        frame.setLayout(null); // using no layout managers
        frame.setVisible(true); // making the frame visible
    }
}
```

### References

https://cs.fit.edu/~ryan/cse1002/

https://www.buildingjavaprograms.com/toc4.shtml

https://introcs.cs.princeton.edu/java/home/

https://cs.stanford.edu/people/eroberts/books/index.html

https://web.stanford.edu/class/archive/cs/cs106a/cs106a.1124/lectures/03/Slides.pdf

https://users.utcluj.ro/~ocuibus/ISP/ISP%20laborator%20(site)/

https://www.programming-books.io/essential/java/

https://www.w3schools.com/java/default.asp

https://web.stanford.edu/class/archive/cs/cs106a/cs106a.1124/lectures/27/Slides.pdf


## Programming Contests

   * VK Cup 2015 - Wild Card Round 1 https://codeforces.com/contest/530

   * Codeforces Alpha Round 20 https://codeforces.com/contest/20

   * Experimental Educational Round: VolBIT Formulas Blitz https://codeforces.com/contest/630

