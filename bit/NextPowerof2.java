package bit;

/**
 * @File : NextPowerof2.java
 * @Description : class for finding next power of 2
 * @author Pavan Chokshi
 * 
 */

public class NextPowerof2 {
    static int getNextPowerOf2(int n) {
        int count = 0;
        
        if ( (n & ~(n&(n-1))) == n)
          return n;

        while( n != 0)
        {
          n  >>= 1;
          count += 1;
        }

        return 1<<count;
    }
    public static void main(String[] args) {
        System.out.println(getNextPowerOf2(34));
    }
}