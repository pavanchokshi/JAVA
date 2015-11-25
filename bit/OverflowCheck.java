package bit;

/**
 * @File : OverflowCheck.java
 * @Description : class for checking overflow
 * @author Pavan Chokshi
 * 
 */
public class OverflowCheck {
    static int sum(int a,int b) {
        if(a > Integer.MAX_VALUE - b) 
            return -1;
        else
            return a+b;
    }
    public static void main(String[] args) {
        int result = sum(Integer.MAX_VALUE,1);
        System.out.println(result);
    }
}