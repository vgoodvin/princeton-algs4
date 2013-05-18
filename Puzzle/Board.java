import java.util.ArrayList;

public class Board implements Comparable<Board> {
    private int[][] blocks;
    // construct a board from an N-by-N array of blocks
    public Board(int[][] blocks) {
        this.blocks = blocks;
    }

    // board dimension N
    public int dimension() {
        return blocks.length;
    }

    // number of blocks out of place
    public int hamming() throws Exception {
        throw new Exception("Not implemented yet");
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        int manhattan = 0;
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension(); j++) {
                if (blocks[i][j] == 0) {
                    continue;
                }
                int row = blocks[i][j] / dimension();
                int col = dimension();
                if (blocks[i][j] % dimension() > 0) {
                    col = blocks[i][j] % dimension();
                    row++;
                }
                manhattan += Math.abs(row - i + 1) + Math.abs(col - j + 1);
            }
        }
        return manhattan;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return manhattan() == 0;
    }

    // a board obtained by exchanging two adjacent blocks in the same row
    public Board twin() throws Exception {
        throw new Exception("Not implemented yet");
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (Object.class != this.getClass()) {
            return false;
        }
        return toString().equals(y.toString());
    }

    // all neighboring boards
    public Iterable<Board> neighbors() throws Exception {
        ArrayList<Board> neighbors = new ArrayList<Board>();
        // TODO: make neighbors
        throw new Exception("Not implemented yet");
        //return neighbors;
    }

    // string representation of the board (in the output format specified below)
    public String toString() {
        String out = Integer.toString(dimension());
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension(); j++) {
                out += " " + blocks[i][j];
            }
            out += "\n";
        }
        return out;
    }

    public int compareTo(Board o) {
        if (manhattan() == o.manhattan()) {
            return 0;
        }
        if (manhattan() > o.manhattan()) {
            return 1;
        }
        return -1;
    }
}