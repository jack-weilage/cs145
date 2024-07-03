// Extra credit: 3 classes in this file + GitHub/VSCode + VSCode debugger
package heartRates;

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

    public Range getHeartRateRange() {
        int maxHeartRate = getMaximumHeartRate();

        return new Range(0.5 * maxHeartRate, 0.85 * maxHeartRate);
    }
}

// An additional class that stores a minimum and maximum value as part of a
// range.
class Range {
    private double min;
    private double max;

    public Range(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }
}

class Bitboard {
    // A 64 bit number, representing each of the squares on a chess board.
    private long bits;

    public Bitboard(long bits) {
        this.bits = bits;
    }

    // Checks if a specific square is set.
    public boolean isSet(long square) {
        return (this.bits & (1 << square)) != 0;
    }

    // Sets the bit at `square`.
    public void setSquare(long square) {
        this.bits |= 1 << square;
    }

    // Unsets the bit at `square`.
    public void unsetSquare(long square) {
        this.bits ^= 1 << square;
    }
}
