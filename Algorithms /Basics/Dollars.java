import java.util.*;

class Dollars
{
  public static void main(String[] args)
  {

    // Declaration & Initialization
    int quarters, dimes, nickles, pennies;
    int totalCents;

    Scanner keyboard = new Scanner(System.in);

    System.out.println("Enter a number of cents here: ");
    totalCents = keyboard.nextInt();

    // Calculations
    quarters = totalCents / 25;
    totalCents = totalCents % 25;

    dimes = totalCents / 10;
    totalCents = totalCents % 10;

    nickles = totalCents / 5;
    totalCents = totalCents % 5;

    pennies = totalCents;

    // Print
    System.out.println("You can exchange this into: ");
    System.out.println(quarters + " quarters");
    System.out.println(dimes + " dimes");
    System.out.println(nickles + " nickles");
    System.out.println(pennies + " pennies");

    // Close Scanner
    keyboard.close();
  }
}
