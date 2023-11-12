// Java program to illustrate the
// nextInt() method of Scanner class in Java
// without parameter

import java.util.*;

public class Prog {
    public static void main(String[] argv)
        throws Exception
    {

        String s = "1 2 3 4 a +";

        // create a new scanner
        // with the specified String Object
        Scanner scanner = new Scanner(s);

        while (scanner.hasNext()) {

            // if the next is a Int,
            // print found and the Int
            if (scanner.hasNextInt()) {
                System.out.println("Found Int value :"
                                   + scanner.nextInt());
            }

            // if no Int is found,
            // print "Not Found:" and the token
            else {
                System.out.println("Not found Int value :"
                                   + scanner.next());
            }
        }
        scanner.close();
    }
}
