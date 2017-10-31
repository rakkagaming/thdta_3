package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by robin on 29/10/2017.
 */
public class Main {

    static BufferedReader instream;
    private boolean ongoing, print;
    private String[] input;

    public static void main(String[] args) throws IOException {
        Main go = new Main();
        instream = new BufferedReader(new InputStreamReader(System.in));
        go.start();
    }

    private void start() throws IOException {
        int rounds = Integer.parseInt(instream.readLine().toString());
        for (int i = 0; i < rounds; i++) {
            ongoing = true; print = true;
            instream.readLine();
            int m = Integer.parseInt(instream.readLine().toString());
            long currentSpot = 0;
            ArrayList<Sections> lineList = new ArrayList<Sections>();
            //read in all lines

            while (ongoing){
                input = instream.readLine().toString().split(" ");
                if (input[0].equals("0") && input[1].equals("0")){
                    ongoing = false;
                    break;
                }else if(input.length>1){
                    Sections s = new Sections(input[0], input[1]);
                    lineList.add(s);
                }
            }
            int x = 0,  y = -1, last = -3;
            long temp = 0, longest = 0;
            ArrayList<Integer> lines = new ArrayList<>();
            //Sort lines in order
            lineList.sort(HORISONTAL);

            while(m>currentSpot) {
                //take the line that starts at currentspot or earlier, and goes the longest way
                for (; x < lineList.size(); x++) {
                    if (lineList.get(x).start > currentSpot || currentSpot >=m) {
                        break;
                    }
                    if (!(lineList.get(x).end<=currentSpot)) {
                        temp = lineList.get(x).end;
                        if (temp > longest) {
                            longest = temp;
                            y = x;
                        }
                    }
                }
                if (y==-1 || last == y){
                    System.out.println("0");
                    print=false;
                    break;
                }
                else {
                    currentSpot = lineList.get(y).end;
                    temp = y;
                    lines.add(y);
                }
                if ((x==lineList.size() && lines.size() == 1)){
                    System.out.println("0");
                    print=false;
                    break;
                }
                last = y;
            }
            if (print) {
                System.out.println(lines.size());
                for (int j = 0; j < lines.size(); j++) {
                    System.out.println(lineList.get(lines.get(j)).start + " " + lineList.get(lines.get(j)).end);
                }
            }
            System.out.println();
        }

    }


    private static final Comparator<Sections> HORISONTAL = new Comparator<Sections>() {
        @Override
        public int compare(Sections l1, Sections l2) {
            return (int)(l1.start-l2.start);
        }
    };

    private class Sections {
        long start, end;
        public Sections(String start, String end){
            this.start = Long.parseLong(start);
            this.end = Long.parseLong(end);
        }
    }
}
