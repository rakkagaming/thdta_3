package ComputatialGeometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by robin on 18/10/2017.
 */
public class TheClosestPairProblem {

    static BufferedReader instream;
    private int nodes;
    private boolean ongoing = true;
    private ArrayList<Node> nodeList;
    private String[] input;
    private Double shortestPath, temp;

    public static void main(String[] args) throws IOException {
        instream = new BufferedReader(new InputStreamReader(System.in));
        TheClosestPairProblem go = new TheClosestPairProblem();
        go.start();
    }

    private void start() throws IOException {
        while(ongoing){
            nodes = Integer.parseInt(instream.readLine().toString());
            nodeList = new ArrayList<>();
            shortestPath = 10000.0;
            if (nodes == 0){
                ongoing = false;
                return;
            }
            createNodes();
            //temp = findShortest(nodeList);
            if ((temp = findShortest(nodeList))<shortestPath){
                System.out.println(String.format("%.4f", temp));
            }else {
                System.out.println("INFINITY");
            }
        }
    }

    private Double findShortest(ArrayList<Node> nodeList) {
        double xAxis, yAxis, temp, currentlyShortest = 10000;
        for (int i = 0; i < nodeList.size(); i++) {
            for (int j = i+1; j < nodeList.size(); j++) {
                xAxis = Math.abs(nodeList.get(i).x-nodeList.get(j).x);
                yAxis = Math.abs(nodeList.get(i).y-nodeList.get(j).y);
                temp = Math.sqrt(Math.pow(xAxis,2) + Math.pow(yAxis,2));

                if (temp<currentlyShortest){
                    currentlyShortest = temp;
                }
            }
        }
        return currentlyShortest;
    }

    private void createNodes() throws IOException {
        for (int i = 0; i < nodes; i++) {
            input = instream.readLine().toString().split(" ");
            nodeList.add(new Node(Double.parseDouble(input[0]), Double.parseDouble(input[1])));
        }
    }

    private class Node{
        double x,y;
        public Node(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
}
