public class PercolationStats {

    private Percolation pr;
    private double[] fractions;

    /**
     * Performs T independent computational experiments on an N-by-N grid.
     */
    public PercolationStats(int N, int T) {
        fractions = new double[T];
        for (int expNum = 0; expNum < T; expNum++) {
            pr = new Percolation(N);
            int openedSites = 0;
            while (!pr.percolates()) {
                int i = StdRandom.uniform(1, N + 1);
                int j = StdRandom.uniform(1, N + 1);
                if (!pr.isOpen(i, j)) {
                    pr.open(i, j);
                    openedSites++;
                }
            }
            double fraction = (double) openedSites / (N * N);
            StdOut.println(fraction);
            fractions[expNum] = fraction;
        }
    }

    /**
     * Sample mean of percolation threshold.
     */
    public double mean() {
        return StdStats.mean(fractions);
    }

    /**
     * Sample standard deviation of percolation threshold.
     */
    public double stddev() {
        return 0;
    }

    /**
     * Returns lower bound of the 95% confidence interval.
     */
    public double confidenceLo() {
        return 0;
    }

    /**
     * Returns upper bound of the 95% confidence interval.
     */
    public double confidenceHi() {
        return 0;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("Given N <= 0 || T <= 0");
        }
        PercolationStats ps = new PercolationStats(N, T);

        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = " + ps.confidenceLo() + ", " + ps.confidenceHi());
    }
}

