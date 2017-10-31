package DataStructures;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by robin on 26/09/2017.
 */
public class KillingAliensInBorgMaze {

    private int rounds, width, height,nodes=0;
    private String[] input;
    private char[] charArray;
    private int[][] board;
    private ArrayList<Verticis> verticis = new ArrayList<>();
    private Verticis start;

    public static void main(String[] args) {
        KillingAliensInBorgMaze go = new KillingAliensInBorgMaze();
        try {
            go.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() throws IOException {
        BufferedReader instream = new BufferedReader(new InputStreamReader(System.in));
        rounds = Integer.parseInt(instream.readLine().toString());

        for (int i = 0; i < rounds; i++) {
            input = instream.readLine().split(" ");
            width = Integer.parseInt(input[0]);
            height = Integer.parseInt(input[1]);
            board = new int[width][height];

            instream.readLine();
            for (int j = 1; j < height-1; j++) {
                charArray = instream.readLine().toCharArray();
                for (int k = 1; k < width-1; k++) {
                    switch (charArray[k]){
                        case '#':
                            verticis.add(new Verticis(width,height,'#'));
                            break;
                        case 'S':
                            verticis.add(new Verticis(width,height,'S'));
                            nodes++;
                            break;
                        case 'A':
                            verticis.add(new Verticis(width,height,'A'));
                            nodes++;
                            break;
                    }
                }
            }
            for (int j = 0; j < verticis.size(); j++) {
                verticis.get(j).setDteSize(verticis.size());
            }
            for (int j = 0; j < verticis.size(); j++) {
                if (verticis.get(j).type == 'A' || verticis.get(j).type == 'S'){
                    for (int k = (j+1); k < verticis.size(); k++) {
                        if (verticis.get(k).type == 'A' || verticis.get(k).type == 'S'){
                            verticis.get(k).distanceToEdges[j] = verticis.get(j).distanceToEdges[k] = findDistance(j,k);
                        }
                    }
                }
            }

            instream.readLine();

        }
    }

    private int findDistance(int start, int end) {
        int startX, startY, endX, endY;

        startX = verticis.get(start).x;
        startY = verticis.get(start).y;
        endX = verticis.get(end).x;
        endY = verticis.get(end).y;


        return 0;
    }

    private class Verticis{
        private int x,y,distance;
        private char type;
        private int[] distanceToEdges;

        public Verticis(int x, int y,char type){
            this.x = x;
            this.y = y;
            this.type = type;
            distance = 999999;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        private void setDistance(int i ){
            distance = i;
        }

        private int getDistance(){
            return distance;
        }

        public char getType() {
            return type;
        }

        public void setDteSize(int size){
            distanceToEdges = new int[size];
        }
    }
}
