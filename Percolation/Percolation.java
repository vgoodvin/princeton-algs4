public class Percolation {

    private boolean[][] opened;
    private int top = 0;
    private int bottom;
    private int size;
    private QuickFindUF qf;

    /**
     * Creates N-by-N grid, with all sites blocked.
     */
    public Percolation(int N) {
        size = N;
        bottom = size * size + 1;
        qf = new QuickFindUF(size * size + 2);
        opened = new boolean[size][size];
        for (int j = 1; j <= size; j++) {
            qf.union(getQFIndex(1, j), top);
            qf.union(getQFIndex(size, j), bottom);
        }
    }

    /**
     * Opens site (row i, column j) if it is not already.
     */
    public void open(int i, int j) {
        opened[i - 1][j - 1] = true;
        if (j > 1 && isOpen(i, j - 1)) {
            qf.union(getQFIndex(i, j), getQFIndex(i, j - 1));
        }
        if (j < size && isOpen(i, j + 1)) {
            qf.union(getQFIndex(i, j), getQFIndex(i, j + 1));
        }
        if (i > 1 && isOpen(i - 1, j)) {
            qf.union(getQFIndex(i, j), getQFIndex(i - 1, j));
        }
        if (i < size && isOpen(i + 1, j)) {
            qf.union(getQFIndex(i, j), getQFIndex(i + 1, j));
        }
    }

    /**
     * Is site (row i, column j) open?
     */
    public boolean isOpen(int i, int j) {
        return opened[i - 1][j - 1];
    }

    /**
     * Is site (row i, column j) full?
     */
    public boolean isFull(int i, int j) {
        return qf.connected(top, getQFIndex(i , j));
    }

    /**
     * Does the system percolate?
     */
    public boolean percolates() {
        return qf.connected(top, bottom);
    }

    private int getQFIndex(int i, int j) {
        return size * (i - 1) + j;
    }

    public String toString() {
        String out = qf.find(top) + "\n";
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                out += " " + qf.find(getQFIndex(i, j));
            }
            out += "\n";
        }
        out += qf.find(bottom) + "\n";
        return out;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Percolation pr = new Percolation(N);
        pr.open(1, 6);
        pr.open(2, 6);
        pr.open(3, 6);
        pr.open(4, 6);
        pr.open(5, 6);
        pr.open(6, 6);
        pr.open(7, 6);
        pr.open(8, 6);
        pr.open(9, 6);
        pr.open(10, 6);
        StdOut.println(pr.toString());
        StdOut.println(pr.percolates());
    }
}

