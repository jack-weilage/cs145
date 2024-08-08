package lab6;

public class Exercise2 {

    /**
     * A faulty summation function, which doesn't change the values with thich it is
     * called.
     */
    public int sum(int n) {
        // The base case is when n == 0, but...
        if (n == 0) {
            return 0;
        } else {
            // ...the calls to `sum` never change the value of n, creating an infinite loop.
            return n + sum(n);
        }
    }
}
