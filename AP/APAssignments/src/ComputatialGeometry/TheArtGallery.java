package ComputatialGeometry;

import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by robin on 17/10/2017.
 */
public class TheArtGallery {

    static BufferedReader instream;
    private ArrayList<Node> nodeList;
    private boolean polygon=true,critical = false;
    private String message;

    public static void main(String[] args) throws IOException {
        instream = new BufferedReader(new InputStreamReader(System.in));
        TheArtGallery go = new TheArtGallery();
        go.start();

    }

    private void start() throws IOException {
        String[] input;
        boolean angle,pivot = true ,ongoing = true;
        int nodes, mod, a, b, c,temp;

        while (ongoing) {
            nodes = Integer.parseInt(instream.readLine().toString());
            if (nodes == 0) {break;}
            nodeList = new ArrayList<>();
            critical = false;
            temp = 0;
            //Each round do this
            for (int i = 0; i < nodes; i++) {
                input = instream.readLine().toString().split(" ");

                //Place nodes in a list
                nodeList.add(new Node(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
            }
            //Check if the figure is a polygon
            polygon = checkPolygon();

            mod = nodeList.size();
            //Check angle between 3 consecutive nodes, this can be the last 2 and the first one also.
            //If the angle is over 180, that means a critical point exists
            for (int j = 0; j < nodeList.size(); j++) {
                c = (j + 2) % mod;
                a = j % mod;
                b = (j + 1) % mod;
                angle = signed_triangle_area(nodeList.get(a),nodeList.get(b),nodeList.get(c));
                temp++;
                if (j == 0){
                    pivot = angle;
                }

                if (angle != pivot){
                    critical = true;
                    break;
                }
            }
            message = (critical ? "Yes" : "No");
            if (polygon){System.out.println(message);}
            else {
                System.out.println("No");
            }
            //System.out.println("polygon: " + polygon);
        }
    }

    private boolean checkPolygon() {
        int temp;
        for (int i = 0; i < nodeList.size(); i++) {
            for (int j = (i + 1); j < nodeList.size() - 1; j++) {
                if (j + 2 >= nodeList.size()) {
                    temp = 0;
                } else {
                    temp = j + 2;
                }
                if (Line2D.linesIntersect(nodeList.get(j - 1).x, nodeList.get(j - 1).y, nodeList.get(j).x, nodeList.get(j).y,
                        nodeList.get(j + 1).x, nodeList.get(j + 1).y, nodeList.get(temp).x, nodeList.get(temp).y)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean signed_triangle_area(Node a, Node b, Node c){
        return (((a.x * b.y) - (a.y * b.x) + (a.y * c.x) - (a.x * c.y)
                + (b.x * c.y) - (c.x * b.y)) / 2.0)<0;
    }

    private class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
