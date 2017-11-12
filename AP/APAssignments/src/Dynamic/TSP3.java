package Dynamic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by robin on 10/11/2017.
 */
public class TSP3 {
    static Scanner s;
    private int row, col;
    private Node[][] matrix;
    public static void main(String[] args) {
        s = new Scanner(System.in);
        TSP3 go = new TSP3();
        go.start();
    }

    private void start() {
        while (s.hasNext()) {
            row = s.nextInt();
            col = s.nextInt();

            matrix = new Node[row][col];

            createMatrix();
            createPaths();
            searchForOptimal();
            printResult();
        }
    }

    private void printResult() {
        int best = Integer.MAX_VALUE;
        int x = 0;

        for (int i = 0; i < row; ++i) {
            if (matrix[i][0].value < best) {
                best = matrix[i][0].value;
                x = i;
            }
        }
        Node currentBest = matrix[x][0];
        System.out.print(matrix[x][0].row +1);

        while (currentBest.from != null) {
            currentBest = currentBest.from;
            System.out.print(" " + (currentBest.row + 1));
        }
        System.out.println();

        System.out.println(best);
    }

    private void searchForOptimal() {
        for (int j = col - 2; j >= 0; --j){
            for (int i = row - 1; i >= 0; --i) {
                Node[] n = {matrix[i][j].up, matrix[i][j].right, matrix[i][j].down};
                Arrays.sort(n);

                int best = Integer.MAX_VALUE;
                for (int k = 0; k < 3; ++k) {
                    if (n[k].value < best){
                        best = n[k].value;
                        matrix[i][j].from = n[k];
                    }
                }

                matrix[i][j].value += best;

            }
        }
    }

    private void createPaths() {
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (j + 1 >= col) {
                    continue;
                }

                matrix[i][j].up = i - 1 < 0 ? matrix[row - 1][j + 1] : matrix[i - 1][j + 1];
                matrix[i][j].right = matrix[i][j + 1];
                matrix[i][j].down = i + 1 >= row ? matrix[0][j + 1] : matrix[i + 1][j + 1];
            }
        }
    }

    private void createMatrix() {
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                matrix[i][j] = new Node();
                matrix[i][j].value = s.nextInt();
                matrix[i][j].row = i;
            }
        }
    }

    static class Node implements Comparable<Node> {
        int row;
        int value;
        Node up;
        Node right;
        Node down;
        Node from;

        public int compareTo(Node n) {
            return this.row - n.row;
        }
    }
}
