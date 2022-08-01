import java.awt.*;

public class Fundamentals {
    // Anatomy of a Java method
    public static void main(String[] args) {
        // Primitive Datatypes
        int age = 25;
        boolean isCool = true;
        double gpa = 4.0;
        long bigNumber = 23_456_789;
        char initial = 'N';

        byte newByte = 30;
        short herAge = 35;
        float interestRate = .02f;

        int x = 1;
        int y = x;

        x = 2;
        System.out.println(y); // this prints 1;

        Point d = new Point(1, 1);
        Point e = d;
        d.x = 2;
        System.out.println(e); // java.awt.Point[x=2,y=1]

        // Reference Datatypes / Object Types / Class Wrappers
        String myName = "Narciso Lobo";

        String nameA = new String("Jordan");
        String nameB = nameA;

        nameA = "Brandon";

        // System.out.println(nameB);

        Integer hisAge = 36;

        String m = "Mikey";
        String a = "Mikey";

        String b = new String("Jerry");
        String c = new String("Jerry");

        // System.out.println(m == a);
        // System.out.println(b == c);

    }
}