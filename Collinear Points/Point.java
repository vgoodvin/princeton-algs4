/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER;       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
        SLOPE_ORDER = this.new SlopeOrder<Point>();
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        if (that.x == x) {
            return (that.y == y) ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }
        if (that.y == y) {
            return 0.0;
        }
        return (that.y - y) / (that.x - x);
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        if (y == that.y && x == that.x) {
            return 0;
        }
        return (y < that.y || (y == that.y && x < that.x)) ? -1 : 1;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    private class SlopeOrder<E> implements Comparator<E> {
        public int compare(E o1, E o2) {
            double slope1 = slopeTo((Point) o1);
            double slope2 = slopeTo((Point) o2);
            if (slope1 == slope2) {
                return 0;
            }
            return (slope1 < slope2) ? -1: 1;

        }
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}