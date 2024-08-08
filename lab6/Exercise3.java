package lab6;

public class Exercise3 {
    /**
     * Prints Pascal's triangle using two loops to iterate through the rows and
     * columns.
     */
    public void printPascalLooped(int depth) {
        if (depth <= 0) {
            return;
        }

        for (int row = 0; row < depth; row++) {
            // The number of spaces isn't exactly depth - row, but this works well enough.
            System.out.print(" ".repeat(depth - row));

            for (int col = 0; col <= row; col++) {
                System.out.print(calculatePascal(row, col) + " ");
            }

            System.out.println();
        }
    }

    public int calculatePascal(int row, int col) {
        // If the column is all the ways to the left (col <= 1) or all the way to the
        // right (col == row), the value must be 1
        if (col == 0 || col == row) {
            return 1;
        }

        // Small optimization: If the column is either the second from the left or
        // right, the value is just the row number.
        if (col == 1 || col == row - 1) {
            return row;
        }

        // Go "up" one row, and find the values at the two points directly above.
        return calculatePascal(row - 1, col - 1) + calculatePascal(row - 1, col);
    }

    public static void main(String[] args) {
        Exercise3 test = new Exercise3();

        test.printPascalLooped(10);
    }

}
