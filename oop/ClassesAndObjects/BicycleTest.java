public class BicycleTest {
    public static void main(String[] args) {
        Bicycle myBike = new Bicycle(0, 0, 1);

        myBike.setCadence(3);
        System.out.println(myBike.cadence);
        
        myBike.cadence = 5;
        System.out.println(myBike.cadence);

    }
}
