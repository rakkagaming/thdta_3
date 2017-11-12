package Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by robin on 10/11/2017.
 */
public class TSP {
    static BufferedReader instream;
    private String[] input;
    private int rows, columns;
    private Node[][] matrix;
    private ArrayList rowPath;

    public static void main(String[] args) throws IOException {
        instream = new BufferedReader(new InputStreamReader(System.in));
        TSP go = new TSP();
        go.start();
    }

    private void start() throws IOException {

        while(true) {
            try {
                input = instream.readLine().split(" ");
                rows = Integer.parseInt(input[0]);
                columns = Integer.parseInt(input[1]);

                createMatrix(rows, columns);
                traverseMatrix();

                int value = findShortest();

                printResult(value);
            }catch (Exception e){
                break;
            }
        }
    }

    private void printResult(int value) {
        for (int i = 0; i < rowPath.size(); i++) {
            System.out.print(rowPath.get(i));
            if (!(i== rowPath.size()-1)) System.out.print(" ");
        }
        System.out.println("\n"+value);
    }

    private int findShortest() {
        int shortest = Integer.MAX_VALUE;
        rowPath = new ArrayList();

        for (int i = 0; i < rows; i++) {
            int temp = 0;
            ArrayList<Integer> tempPath = new ArrayList<>();

            Node current = matrix[i][0];
            while(current!=null){
                temp += current.value;
                tempPath.add(current.row);
                current = current.parent;
            }

            if (temp < shortest){
                shortest = temp;
                rowPath = tempPath;
            }
        }
        return shortest;
    }

    private void traverseMatrix() {
        for (int i = columns-1; i >= 0; i--) {
            for (int j = 0; j < rows; j++) {
                matrix[j][columns-1].setParent(null);
                matrix[j][columns-1].pathValue = matrix[j][columns-1].value;
                createTree(j,i);
            }
        }
    }

    private void createTree(int row, int column) {
        if (column==0) return;
        for (int i = 0; i < 3; i++) {
            if ((row-1+i)<0){
                //Kolla på node längst ner
                if (matrix[rows-1][column-1].parent == null || matrix[rows-1][column-1].parent.pathValue > matrix[row][column].pathValue){
                    matrix[rows-1][column-1].setParent(matrix[row][column]);
                    matrix[rows-1][column-1].pathValue =  matrix[row][column].pathValue + matrix[rows-1][column-1].value;
                }else if(matrix[rows-1][column-1].parent.pathValue==matrix[row][column].pathValue && matrix[rows-1][column-1].parent.row > matrix[row][column].row){
                    matrix[rows-1][column-1].setParent(matrix[row][column]);
                    matrix[rows-1][column-1].pathValue =  matrix[row][column].pathValue + matrix[rows-1][column-1].value;
                }
            }else if((row-1+i)==rows){
                //Kolla på node högst upp
                if (matrix[0][column-1].parent == null || matrix[0][column-1].parent.pathValue > matrix[row][column].pathValue){
                    matrix[0][column-1].setParent(matrix[row][column]);
                    matrix[0][column-1].pathValue =  matrix[row][column].pathValue + matrix[0][column-1].value;
                }else if(matrix[0][column-1].parent.pathValue==matrix[row][column].pathValue && matrix[0][column-1].parent.row > matrix[row][column].row){
                    matrix[0][column-1].setParent(matrix[row][column]);
                    matrix[0][column-1].pathValue =  matrix[row][column].pathValue + matrix[0][column-1].value;
                }
            }else{
                //Kolla node
                if (matrix[row-1+i][column-1].parent == null || matrix[row-1+i][column-1].parent.pathValue > matrix[row][column].pathValue){
                    matrix[row-1+i][column-1].setParent(matrix[row][column]);
                    matrix[row-1+i][column-1].pathValue =  matrix[row][column].pathValue + matrix[row-1+i][column-1].value;
                }else if(matrix[row-1+i][column-1].parent.pathValue==matrix[row][column].pathValue && matrix[row-1+i][column-1].parent.row > matrix[row][column].row){
                    matrix[row-1+i][column-1].setParent(matrix[row][column]);
                    matrix[row-1+i][column-1].pathValue =  matrix[row][column].pathValue + matrix[row-1+i][column-1].value;
                }
            }
        }
    }

    private void createMatrix(int rows, int columns) throws IOException {
        matrix = new Node[rows][columns];
        for (int i = 0; i < rows; i++) {
            input = instream.readLine().split(" ");
            if(input.length>columns){
                for (int j = 0; j < input.length; j++) {
                    if (j%columns==0 && j>0) i++;
                    matrix[i][j%columns] = new Node(Integer.parseInt(input[j]), i + 1);
                }
            } else{
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = new Node(Integer.parseInt(input[j]), i + 1);
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

    private class Node{
        int  value, pathValue, row;
        Node parent;

        public Node(int value, int row) {
            this.value = value;
            this.row = row;
        }

        public void setParent(Node parent){
            this.parent = parent;
        }
    }
}
