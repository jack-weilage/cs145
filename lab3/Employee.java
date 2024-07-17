package lab3;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;

    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    // Return employee's first name.
    public String getFirstName() {
        return firstName;
    }

    // Return employee's last name.
    public String getLastName() {
        return lastName;
    }

    // Return employee's social security number.
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    @Override
    public String toString() {
        return String.format("employee %s %s%nsocial security number: %s", getFirstName(), getLastName(),
                getSocialSecurityNumber());
    }
}
