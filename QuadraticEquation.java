/*
 *  Compilation: javac Quadratic.java
 *  Execution  : java Quadratic a b c
 *
 *  Given a, b and c, solves for the roots of a*x^2 + b*c + c
 *  Assumes both roots are real valued. 
 *
 *  ironman@localhost$ java Quadratic 1.0 -1.0 -1.0
 *   1.618033988749895
 *  -0.6180339887498949
 *
 *  Remark: 1.6118... is the golden ratio
 */

import java.math.*;
import java.io.*;
import java.util.*;
 
public class Lygtis1 {
     static class InputReader {
 
		private InputStream stream;
		private byte[] buf = new byte[8192];
		private int curChar;
		private int snumChars;
		private SpaceCharFilter filter;
 
		public InputReader(InputStream stream) {
			this.stream = stream;
		}
 
		public int snext() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
 
		public int nextInt() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
 
			int res = 0;
 
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
 
			return res * sgn;
		}
		
		public long nextLong() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
 
			long res = 0;
 
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
 
			return res * sgn;
		}
		
		public String readString() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			} while (!isSpaceChar(c));
			return res.toString();
		}
 
		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
 
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
 
 
    public long diskriminantas(long a, long b, long c)
    {
        return (b*b-4*a*c);
    }
    public double pirmasaknis(long a, long b, long c)
    {
        return (((-b+Math.sqrt(diskriminantas(a,b,c)))/(2*a)));
    }
    public double antrasaknis(long a, long b, long c)
    {
        return (((-b-Math.sqrt(diskriminantas(a,b,c)))/(2*a)));
    }
    
   
    public static void main(String[] args) {
        Lygtis1 g = new Lygtis1();
        InputReader in=new InputReader(System.in);
        PrintWriter pw=new PrintWriter(System.out);
  
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();      
        if (a == 0 && b == 0 && c == 0)
        {
            pw.println(-1);
        }        
        else if (a == 0 && b == 0)
        {
            pw.println(0);
        }
        else if (a == 0)
        {
            pw.println(1);
            double x = -(double)c/(double)b;
            pw.println(x);
        }
 
        else if (g.diskriminantas(a, b, c) > 0)
        {       
            pw.println(2);
            if (g.antrasaknis(a, b, c) < g.pirmasaknis(a, b, c))
            {
                pw.println(g.antrasaknis(a, b, c));
                pw.println(g.pirmasaknis(a, b, c));
            }
            else
            {
                pw.println(g.pirmasaknis(a, b, c));
                pw.println(g.antrasaknis(a, b, c));
            }
            
        }
        else if (g.diskriminantas(a, b, c) == 0)
        {
            pw.println(1);
            pw.println(g.antrasaknis(a, b, c));
        }
        else if (g.diskriminantas(a, b, c) < 0)
        {
             pw.println(0);
        }  
        pw.close();
    }
    
}
