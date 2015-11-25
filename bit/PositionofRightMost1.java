package bit;

/**
 * @File : PositionofRightMost1.java
 * @Description : class for finding the position of rightmost 1
 * @author Pavan Chokshi
 * 
 */

public class PositionofRightMost1 {
    static int positionofRightMost1(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            if((n & 1) == 1)
                break;
            n = n >> 1;            
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(positionofRightMost1(19));
    }
}