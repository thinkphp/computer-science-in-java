import java.util.Objects;

public class Complex {

private final double re; // the real part
private final double im; // the imaginary part

//create a new object with the given real and imaginary parts
public Complex(double real , double imag) {

       re = real;
       im = imag;
} 

public Complex plus(Complex b) {
       
       Complex a = this;
       double real = a.re + b.re;
       double imag = a.im + b.im;
       return new Complex(real, imag);
}

//return a string representation of the invoking Complex object
public String toString() {
       if(im == 0) return re + "";
       if(re == 0) return im + "i";
       if(im < 0) return re + " - " + (-im) + "i";
       return re + " + " + im + "i";
}

public static void main(String[] args) {

       Complex a = new Complex(5.0, 6.0);
       Complex b = new Complex(-3.0, 4.0);
       System.out.println(a);
       System.out.println(b);  
       System.out.println(a.plus(b)); 
}

}
