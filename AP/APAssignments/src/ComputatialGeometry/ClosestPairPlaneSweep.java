package ComputatialGeometry;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by robin on 27/10/2017.
 */
public class ClosestPairPlaneSweep {
    static BufferedReader instream;
    public static void main(String[] args) throws IOException {
        instream = new BufferedReader(new InputStreamReader(System.in));
        ClosestPairPlaneSweep go = new ClosestPairPlaneSweep();
        go.start();
    }

    private void start() throws IOException {
        boolean ongoing = true;
        int input;
        double currentMin;
        String[] pointReader;
        Point[] points;
        while(ongoing){
            input = Integer.parseInt(instream.readLine().toString());
            if (input==0) return;
            currentMin = Double.POSITIVE_INFINITY;
            points = new Point[input];
            for (int i = 0; i < input; i++) {
                pointReader = instream.readLine().split(" ");
                points[i] = new Point(Integer.parseInt(pointReader[0]), Integer.parseInt(pointReader[1]));
            }
            Arrays.sort(points,HORISONTAL);
            for (int i = 0; i < points.length; i++) {
                for (int j = i; j < points.length; j++) {
                    if (points[i].x+currentMin > points[j].x);
                }
            }
        }
    }

    private static final Comparator<Point> HORISONTAL = new Comparator<Point>() {
        @Override
        public int compare(Point p1, Point p2) {
            if (p1.x < p2.x) return -1;
            if (p1.x > p2.x) return 1;
            if (p1.y < p2.y) return -1;
            if (p1.y > p2.y) return 1;
            return 0;
        }
    };

    private static final Comparator<Point> VERTICAL = new Comparator<Point>() {
        @Override
        public int compare(Point a, Point b) {
            if (a.y < b.y) return -1;
            if (a.y > b.y) return 1;
            if (a.x < b.x) return -1;
            if (a.x > b.x) return 1;
            return 0;
        }
    };
}
