package Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by robin on 10/11/2017.
 */
public class TSP2 {
    static BufferedReader instream;
    private String[] input;
    private String in;
    private int rows, columns;
    private Node[][] matrix;

    public static void main(String[] args) throws IOException {
        instream = new BufferedReader(new InputStreamReader(System.in));
        TSP2 go = new TSP2();
        go.start();
    }

    private void start() throws IOException {

        while(true) {
                input = instream.readLine().split(" ");
                if (input[0].equals("")||input[1].equals("")) break;
                rows = Integer.parseInt(input[0]);
                columns = Integer.parseInt(input[1]);

                createMatrix(rows, columns);
                traverseMatrix();
                printPath(findShortestPath());
        }
    }

    private void printPath(Node shortestPath) {
        int best = shortestPath.value;
        System.out.print((shortestPath.row+1));

        while(shortestPath.from!=null){
            shortestPath = shortestPath.from;
            System.out.print(" " + (shortestPath.row + 1));
        }
        System.out.println();
        System.out.println(best);
    }

    private Node findShortestPath() {
        for (int i = columns-2; i >= 0 ; i--) {
            for (int j = rows-1; j >= 0 ; j--) {
                Node[] choices = {matrix[j][i].up, matrix[j][i].right, matrix[j][i].down};

                Arrays.sort(choices);

                int shortest = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (choices[k].value < shortest){
                        shortest = choices[k].value;
                        matrix[j][i].from = choices[k];
                    }
                }
                matrix[j][i].value += shortest;
            }
        }

        int shortest = Integer.MAX_VALUE, x = 0;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0].value < shortest){
                shortest = matrix[i][0].value;
                x = i;
            }
        }

        return matrix[x][0];
    }

    private void traverseMatrix() {
        for (int i = 0; i<columns-1;i++) {
            for (int j = 0; j < rows; j++) {
                createTree(j,i);
            }
        }
    }

    private void createTree(int row, int column) {
        matrix[row][column].up = (row-1<0) ? matrix[rows-1][column+1] : matrix[row-1][column+1];
        matrix[row][column].right = matrix[row][column+1];
        matrix[row][column].down = (row+1==rows) ? matrix[0][column+1] : matrix[row+1][column+1];
    }

    private void createMatrix(int rows, int columns) throws IOException {
        matrix = new Node[rows][columns];
        for (int i = 0; i < rows; i++) {
            input = instream.readLine().split(" ");
            if(input.length>columns){
                for (int j = 0; j < input.length; j++) {
                    if (j%columns==0 && j>0) i++;
                    matrix[i][j%columns] = new Node(Integer.parseInt(input[j]), i);
                }
            } else{
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = new Node(Integer.parseInt(input[j]), i );
                }
            }
        }
    }

    private void printMatrix(Node[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j].value + " " );
            }
        }
    }

    private class Node implements Comparable<Node>{
        int  value, pathValue, row;
        Node up,right,down, from;

        public Node(int value, int row) {
            this.value = value;
            this.row = row;
        }

        @Override
        public int compareTo(Node o) {
            return this.row-o.row;
        }
    }
}
