// Maintains information about a person's maximum and target heart rates.
// Note: This class assumes that the birth month, day, and year are correct values.
public class HeartRates {
    private String firstName;
    private String lastName;

    private int birthYear;
    private int currentYear;

    public HeartRates(String firstName, String lastName, int birthYear, int currentYear) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.birthYear = birthYear;
        this.currentYear = currentYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public int getAge() {
        return currentYear - birthYear;
    }

    public int getMaximumHeartRate() {
        return 220 - getAge();
    }

    public double getMinimumTargetHeartRate() {
        return 0.5 * getMaximumHeartRate();
    }

    public double getMaximumTargetHeartRate() {
        return 0.85 * getMaximumHeartRate();
    }
}
