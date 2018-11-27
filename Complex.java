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

public Complex minus(Complex b) {

       Complex a = this;
       double real = a.re - b.re;
       double imag = a.im - b.im;
       return new Complex(real, imag); 
}

public Complex times(Complex b) {

       Complex a = this;
       double real = a.re * b.re - a.im * b.im; 	
       double imag = a.re * b.im + a.im * b.re;

       return new Complex(real, imag);   
}

public Complex reciprocal() {
       double scale = re*re + im*im;
       return new Complex(re / scale, -im / scale);
}

public Complex divides(Complex b) {

       Complex a = this;  

       return a.times(b.reciprocal());
}

public Complex scale(double alpha) {

       return new Complex(re * alpha, im * alpha); 
}

//return a string representation of the invoking Complex object
public String toString() {
       if(im == 0) return re + "";
       if(re == 0) return im + "i";
       if(im < 0) return re + " - " + (-im) + "i";
       return re + " + " + im + "i";
}

public double re() {return re; }
public double im() {return im; }

public Complex conjugate() {

       return new Complex(re, -im); 
} 

public Complex sin() {

      return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
}

public Complex cos() {

      return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
}

public Complex tan() {
      return sin().divides(cos());  
}

public double abs() {
 
       return Math.hypot(re, im);     
}

public boolean equals(Object x) {

       if(x == null) return false;
       if(x.getClass() != this.getClass()) return false;
       Complex that = (Complex) x; 
       return (this.re == that.re) && (this.im == that.im); 
}

 public static void main(String[] args) {

       Complex a = new Complex(5.0, 6.0);
       Complex b = new Complex(-3.0, 4.0);
       System.out.println("a = " + a);
       System.out.println("b = " + b); 
       System.out.println("a scale 3 = " + a.scale(3));
       System.out.println("Re(a) = " + a.re());
       System.out.println("Im(a) = " + a.im()); 
       System.out.println("Re(b) = " + b.re());
       System.out.println("Im(b) = " + b.im());  
       System.out.println("Conjugate(a) = " + a.conjugate());
       System.out.println("Conjugate(b) = " + b.conjugate());
       System.out.println("a + b = " + a.plus(b));
       System.out.println("a - b = " + a.minus(b));  
       System.out.println("a * b = " + a.times(b)); 
       System.out.println("a / b = " + a.divides(b));
       System.out.println("sin(a) = " + a.sin());
       System.out.println("cos(a) = " + a.cos());
       System.out.println("tan(a) = " + a.tan());
       System.out.println("|a| = " + a.abs());
       System.out.println("|b| = " + b.abs());
       System.out.println("a equals b ? " + a.equals(b));
 }

}
