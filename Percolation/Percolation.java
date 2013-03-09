public class Percolation {

    private int[][] sites;

    /**
     * Creates N-by-N grid, with all sites blocked.
     */
    public Percolation(int N) {
        sites = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //sites[i][j] = ???;
            }
        }
    }

    /**
     * Opens site (row i, column j) if it is not already.
     */
    public void open(int i, int j) {

    }

    /**
     * Is site (row i, column j) open?
     */
    public boolean isOpen(int i, int j) {
        return false;
    }

    /**
     * Is site (row i, column j) full?
     */
    public boolean isFull(int i, int j) {
        return false;
    }

    /**
     * Does the system percolate?
     */
    public boolean percolates() {
        return false;
    }
}

