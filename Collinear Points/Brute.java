import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Brute {
    public static void main(String[] args) {
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        In in = new In(args[0]);
        int pointsCount = in.readInt();
        Point[] points = new Point[pointsCount];
        for (int i = 0; i < pointsCount; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
            points[i].draw();
        }
        for (int p = 0; p < pointsCount; p++) {
            for (int q = p + 1; q < pointsCount; q++) {
                double slopeToQ = points[p].slopeTo(points[q]);
                for (int r = q + 1; r < pointsCount; r++) {
                    double slopeToR = points[p].slopeTo(points[r]);
                    if (slopeToQ == slopeToR) {
                        for (int s = r + 1; s < pointsCount; s++) {
                            double slopeToS = points[p].slopeTo(points[s]);
                            if (slopeToQ == slopeToS) {
                                List<Point> collinearPoints = new ArrayList<Point>(4);
                                collinearPoints.add(points[p]);
                                collinearPoints.add(points[q]);
                                collinearPoints.add(points[r]);
                                collinearPoints.add(points[s]);
                                Collections.sort(collinearPoints);
                                for (int i = 0; i < 3; i++) {
                                    StdOut.print(collinearPoints.get(i)); StdOut.print(" -> ");
                                }
                                StdOut.println(Collections.max(collinearPoints));
                                Collections.min(collinearPoints).drawTo(Collections.max(collinearPoints));
                            }
                        }
                    }
                }
            }
        }
    }
}
