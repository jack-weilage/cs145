// Exercise HeartRatesTest.java
// Tests class HeartRates.
public class HeartRatesTest {
    public static void main(String[] args) {
        // create a HeartRates object for a person born in 1975;
        // rates calculated based on current year 2009.
        HeartRates bob = new HeartRates("Bob", "Blue", 1975, 2009);
        System.out.printf("First name: %s%n", bob.getFirstName());
        System.out.printf("Last name: %s%n", bob.getLastName());
        System.out.printf("Age: %d%n", bob.getAge());
        System.out.printf("Maximum heart rate: %d%n", bob.getMaximumHeartRate());
        System.out.println("Target heart rate range:");
        System.out.printf(" Minimum: %.0f%n", bob.getMinimumTargetHeartRate());
        System.out.printf(" Maximum: %.0f%n", bob.getMaximumTargetHeartRate());
    } // end main
} // end class HeartRatesTest
