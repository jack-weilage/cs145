package lab5;

/**
 * PhoneBookEntry
 */
public class PhoneBookEntry {
    private String name;
    private String address;
    private String city;
    private String phoneNumber;

    public PhoneBookEntry(String name, String address, String city, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("{ %s, %s, %s, %s }", name, address, city, phoneNumber);
    }
}
