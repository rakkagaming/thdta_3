package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by robin on 03/11/2017.
 */
public class KillingAliens {

    static BufferedReader instream;
    private int rounds, rowIndex, columnIndex;
    private String[] input;
    private String input2;
    private ArrayList<BoardTile> nodeList;
    private int[][] matrix;
    private ArrayList<EdgeNodes> edgeList;

    public static void main(String[] args) throws IOException {
        KillingAliens go = new KillingAliens();
        instream = new BufferedReader(new InputStreamReader(System.in));
        go.start();
    }

    private void start() throws IOException {
        rounds = Integer.parseInt(instream.readLine().toString());
        for (int i = 0; i < rounds; i++) {
            nodeList = new ArrayList<>();
            input = instream.readLine().split(" ");
            rowIndex = Integer.parseInt(input[0]);
            columnIndex = Integer.parseInt(input[1]);

            BoardTile[][] board = initBoard(rowIndex, columnIndex);

            edgeList = new ArrayList<>();
            for (int j = 0; j < nodeList.size(); j++) {
                matrix = adjecencyMatrix(rowIndex,columnIndex,nodeList.get(j).x,nodeList.get(j).y);
                ArrayList<BoardTile> temp = new ArrayList<>(nodeList);
                bfs(board, matrix, nodeList.get(j));
                for (int k = j+1; k < temp.size(); k++) {
                    edgeList.add(new EdgeNodes(nodeList.get(j), temp.get(k), matrix[temp.get(k).y][temp.get(k).x]));
                }
            }
            Collections.sort(edgeList, Comparator.comparing(EdgeNodes::getDistance));
            kruskalMST();

            edgeList.clear();
            nodeList.clear();

        }
    }

    private void printEdges(ArrayList<EdgeNodes> edgeList) {
        for (int i = 0; i < edgeList.size(); i++) {
            System.out.println(edgeList.get(i).distance);
        }
    }

    private void kruskalMST() {
        ArrayList<EdgeNodes> treeSet = new ArrayList<>();
        int size = 0;
        for (int i = 0; i < edgeList.size(); i++) {
            if (find(edgeList.get(i).start) != find(edgeList.get(i).end)){
                treeSet.add(edgeList.get(i));
                union(edgeList.get(i).start,edgeList.get(i).end);
                size += edgeList.get(i).distance;
            }
        }
        System.out.println(size);
    }

    private BoardTile find(BoardTile tile){
        while (tile != tile.parent ){
            tile = tile.parent;
        }
        return tile;
    }

    private void union(BoardTile x, BoardTile y){
        BoardTile rx = find(x);
        BoardTile ry = find(y);
        if (rx.equals(ry)) return;
        if (rx.rank>ry.rank) ry.parent = rx;
        else {
            rx.parent = ry;
            if (rx.rank==ry.rank)
                ry.rank++;
        }
    }

    private void bfs(BoardTile[][] board, int[][] matrix, BoardTile boardTile) {
        LinkedList<BoardTile> queue = new LinkedList();
        queue.add(boardTile);

        while (!queue.isEmpty()){
            BoardTile temp = queue.pop();

            if ((temp.x +1 < board[0].length) && !(board[temp.y][temp.x + 1].type== '#') && matrix[temp.y][temp.x + 1] == -1){
                matrix[temp.y][temp.x+1] = matrix[temp.y][temp.x] + 1;
                BoardTile newTile = board[temp.y][temp.x+1];
                queue.add(newTile);
            }
            if ((temp.x - 1 >= 0) && !(board[temp.y][temp.x - 1].type== '#') && matrix[temp.y][temp.x - 1] == -1){
                matrix[temp.y][temp.x-1] = matrix[temp.y][temp.x] + 1;
                BoardTile newTile = board[temp.y][temp.x-1];
                queue.add(newTile);
            }
            if ((temp.y + 1 < board.length) && !(board[temp.y + 1][temp.x].type== '#') && matrix[temp.y + 1][temp.x] == -1){
                matrix[temp.y +1 ][temp.x] = matrix[temp.y][temp.x] + 1;
                BoardTile newTile = board[temp.y + 1][temp.x];
                queue.add(newTile);
            }
            if ((temp.y - 1 >= 0) && !(board[temp.y - 1][temp.x].type== '#') && matrix[temp.y - 1][temp.x] == -1){
                matrix[temp.y - 1][temp.x] = matrix[temp.y][temp.x] +1 ;
                BoardTile newTile = board[temp.y - 1][temp.x];
                queue.add(newTile);
            }
        }
    }


    private int[][] adjecencyMatrix(int x,int y,int startX,int startY){
        int[][] numbers = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                numbers[i][j] = -1;
            }
        }
        numbers[startY][startX] = 0;
        return numbers;
    }

    private void printArray(BoardTile[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print("[");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].type + ",");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    private void printArray(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print("[");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]+ ",");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    private BoardTile[][] initBoard(int x, int y) throws IOException {
        BoardTile[][] board = new BoardTile[y][x];
        for (int i = 0; i < y; i++) {
            input2 = instream.readLine();
            for (int j = 0; j < x; j++) {
                board[i][j] = new BoardTile(j,i,false, input2.charAt(j));
                if (input2.charAt(j) == 'S'){
                    nodeList.add(board[i][j]);
                } else if (input2.charAt(j) == 'A'){
                    nodeList.add(board[i][j]);
                }
            }
        }
        return board;
    }


    private class BoardTile{
        private int x,y, rank =0;
        private char type;
        private boolean visited;
        BoardTile parent = this;

        public BoardTile(int x, int y, boolean visited, char type){
            this.x = x;
            this.y = y;
            this.visited = visited;
            this.type = type;
        }
    }

    private class EdgeNodes{
        BoardTile start;
        BoardTile end;
        int distance;

         public EdgeNodes(BoardTile start, BoardTile end, int distance){
             this.end = end;
             this.start = start;
             this.distance = distance;
         }

        public int getDistance() {
            return distance;
        }
    }
}
