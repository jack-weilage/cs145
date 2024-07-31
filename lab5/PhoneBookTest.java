package lab5;

/**
 * PhoneBookTest
 *
 * This test suite requires the use of assertion, which can be enabled by using
 * the `-ea` CLI flag
 */
public class PhoneBookTest {
    public static void main(String[] args) {
        PhoneBook bellingham = new PhoneBook();
        assert bellingham.size() == 0 : "An empty phonebook has a length of zero";
        try {
            bellingham.get(0);
            assert false : "PhoneBook.get(0) should throw when the list is empty";
        } catch (Exception e) {
        }

        PhoneBookEntry johnSmith = new PhoneBookEntry("John Smith", "100 Street Name", "City Name", "(111) 111-1111");
        bellingham.add(johnSmith);
        assert bellingham.size() == 1 : "After adding an element, the phonebook should have a length of one";
        assert bellingham.get(0) == johnSmith : "The element at index zero should be what was added";

        PhoneBookEntry aliceJones = new PhoneBookEntry("Alice Jones", "200 Lane Name", "City Name", "(111) 222-2222");
        bellingham.add(aliceJones);
        assert bellingham.size() == 2 : "After adding a second element, the phonebook should have a length of two";
        assert bellingham.get(1) == aliceJones : "The element at index one should be what was added";

        PhoneBookEntry jasmineSalah = new PhoneBookEntry("Jasmine Salah", "300 Road", "City Name", "(111) 333-3333");
        bellingham.replace(1, jasmineSalah);
        assert bellingham.size() == 2 : "After replacing an element, the phonebook should have the same length";
        assert bellingham.get(1) == jasmineSalah : "The element at index one should be what was replaced";

        bellingham.remove(0);
        assert bellingham.size() == 1 : "After removing an element, the phonebook should have less length";
        assert bellingham.get(0) == jasmineSalah
                : "After removing an element, the element in that index should be the next one";

        System.out.println(bellingham);
        System.out.println("All assertions passed!");
    }
}
