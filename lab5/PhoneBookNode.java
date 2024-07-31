package lab5;

/**
 * PhoneBookNode
 */
public class PhoneBookNode {
    public PhoneBookEntry entry;
    public PhoneBookNode next;

    /**
     * Constructs a {@link PhoneBookNode} without a next value.
     */
    public PhoneBookNode(PhoneBookEntry entry) {
        this.entry = entry;
        this.next = null;
    }

    /**
     * Constructs a {@link PhoneBookNode} with a next value.
     */
    public PhoneBookNode(PhoneBookEntry entry, PhoneBookNode next) {
        this.entry = entry;
        this.next = next;
    }

    @Override
    public String toString() {
        return entry.toString();
    }
}
