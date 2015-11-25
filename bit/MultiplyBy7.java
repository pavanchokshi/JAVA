package bit;

/**
 * @File : MultiplyBy7.java
 * @Description : class for finding multiple by 7
 * @author Pavan Chokshi
 * 
 */

public class MultiplyBy7 {
    static int multiplywith7(int n) {
        return (n<<3) - n;
    }
    public static void main(String[] args) {
        System.out.println(multiplywith7(8));
    }
}