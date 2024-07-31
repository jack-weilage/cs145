// Extra credit: a sort method
package lab5;

/**
 * PhoneBook
 */
public class PhoneBook {
    private PhoneBookNode head;
    private long size;

    public PhoneBook() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Add a {@link PhoneBookEntry} to the end of the linked list.
     */
    public void add(PhoneBookEntry entry) {
        PhoneBookNode current = head;

        if (current == null) {
            head = new PhoneBookNode(entry);
        } else {
            // Iterate to the final element in the list.
            while (current.next != null) {
                current = current.next;
            }

            current.next = new PhoneBookNode(entry);
        }

        // The list has grown.
        size++;
    }

    /**
     * Adds a {@link PhoneBookEntry} at the index.
     */
    public void add(long index, PhoneBookEntry entry) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException(index);
        }

        PhoneBookNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        // The node at `index` should have the data from the entry, but link to the next
        // entry.
        current = new PhoneBookNode(entry, current.next);
        // The list has grown.
        size++;
    }

    /**
     * Returns the {@link PhoneBookEntry} at `index`. If the index is greater than
     * the total size of the list, this method throws an
     * {@link IndexOutOfBoundsException}.
     */
    public PhoneBookEntry get(long index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException(index);
        }

        PhoneBookNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.entry;
    }

    /**
     * Replaces the {@link PhoneBookEntry} at the index. If the index is greater
     * than the total size of the list, this method throws an
     * {@link IndexOutOfBoundsException}.
     */
    public void replace(long index, PhoneBookEntry replacement) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException(index);
        }

        PhoneBookNode current = head;
        // Search until one before the index.
        for (int i = 0; i + 1 < index; i++) {
            current = current.next;
        }

        // The node at `index` should be replaced with a new node containing the new
        // data, but links to the next node.
        current.next = new PhoneBookNode(replacement, current.next.next);
    }

    /**
     * Removes the {@link PhoneBookNode} at the index. If the index is greater than
     * the total size of the list, this method doesn't do anything.
     */
    public void remove(long index) {
        // If the index is out of bounds, the node already doesn't exist.
        if (index > size - 1) {
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;

            return;
        }

        PhoneBookNode current = head;
        // Search until one before the index.
        for (int i = 0; i + 1 < index; i++) {
            current = current.next;
        }

        // The next element (at `index`) should become the next next element
        // (at `index + 1`)
        current.next = current.next.next;

        // The list has shrunk.
        size--;
    }

    /**
     * Returns the total number of nodes in the {@link PhoneBook}.
     */
    public long size() {
        return size;
    }

    @Override
    public String toString() {
        PhoneBookNode current = head;
        String output = "";

        while (current != null) {
            // If the current node isn't the first node, add a little arrow between the
            // nodes.
            if (current != head) {
                output += " -> ";
            }

            output += current.toString();
            current = current.next;
        }

        return output;

    }
}
