package ComputatialGeometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by robin on 17/10/2017.
 */
public class SunnyMountains {

    static BufferedReader instream;
    private int rounds,cords;
    private String[] input;
    private ArrayList<Integer> x,y;

    private ArrayList<Node> nodeList;

    public static void main(String[] args) throws IOException {
        instream = new BufferedReader(new InputStreamReader(System.in));
        SunnyMountains go = new SunnyMountains();
        go.start();
    }

    public void start() throws IOException {
            rounds = Integer.parseInt(instream.readLine().toString());
            for (int i = 0; i < rounds; i++) {

                nodeList = new ArrayList<>();
                cords = Integer.parseInt(instream.readLine().toString());
                for (int j = 0; j < cords; j++) {
                    input = instream.readLine().split(" ");

                    nodeList.add(new Node(Integer.parseInt(input[0]),Integer.parseInt(input[1])));
                }
                Collections.sort(nodeList, Comparator.comparing(Node::getX));
                calculateSunnySide(nodeList);
            }
    }
    private void calculateSunnySide(ArrayList<Node> a) {
        double topAngle, distance = 0;
        double xDiff, yDiff, topY = a.get(a.size()-1).y;


        for (int i = cords-1; i > 0; i--) {
            if (a.get(i-1).y>topY) {
                xDiff = Math.abs(a.get(i).x - a.get(i - 1).x);
                yDiff = Math.abs(a.get(i).y - a.get(i - 1).y);

                //System.out.println("xDiff, yDiff: " + xDiff + " " + yDiff);

                topAngle = xDiff/yDiff;

                //System.out.println("Angle: " + topAngle);

                yDiff = yDiff - (topY - a.get(i).y);

                xDiff = yDiff * topAngle;

                topY = a.get(i-1).y;
                distance += Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
            }
        }
        System.out.println(String.format("%.2f",distance));
    }

    private class Node{
        int x, y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }
    }
}
