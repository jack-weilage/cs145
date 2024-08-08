package lab6;

public class Exercise1 {
    /**
     * A function to multiply `a` by `b`.
     *
     * This function either returns `a` or `a + mystery()`, meaning that the result
     * must always be a multiple of `a`.
     *
     * When called (with a `b` greater than or equal to 1), this function calls
     * itself `b` times, adding `a` to the result each time.
     */
    public int mystery(int a, int b) {
        if (b == 1) {
            return a;
        } else {
            return a + mystery(a, b - 1);
        }
    }
}
