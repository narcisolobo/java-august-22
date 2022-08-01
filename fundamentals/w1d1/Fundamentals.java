import java.math.BigDecimal;

public class Fundamentals {

    // Anatomy of a Java method
    public static void main(String[] args) {
        
        // Printing to the console

        // How does our computer execute Java code?

        // What happens if there's an error?

        // Primitive Variables
        byte myByte = 20;
        short myShort = 32_000;
        int myInt = 45;
        long myLong = 5678L;
        double myDouble = 2.2;
        float myFloat = 5.65F;
        boolean isBool = true;
        char myChar = 'J';

        String myString = "Narciso";
        
        System.out.println(myByte);
        System.out.println(myShort);
        System.out.println(myInt);
        System.out.println(myLong);
        System.out.println(myDouble);
        System.out.println(myFloat);
        System.out.println(isBool);
        System.out.println(myChar);
        System.out.println(myString);

        // Object 

/*      Input :
        double a=0.03;
        double b=0.04;
        double c=b-a;
        System.out.println(c);
        Output :0.009999999999999998

        Input :
        BigDecimal _a = new BigDecimal("0.03");
        BigDecimal _b = new BigDecimal("0.04");
        BigDecimal _c = _b.subtract(_a);
        System.out.println(_c);
        Output :0.01 */

        double a=0.03;
        double b=0.04;
        double c=b-a;
        System.out.println(c);
        
        BigDecimal _a = new BigDecimal("0.03");
        BigDecimal _b = new BigDecimal("0.04");
        BigDecimal _c = _b.subtract(_a);
        System.out.println(_c);
    }
}