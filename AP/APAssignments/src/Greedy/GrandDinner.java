package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by robin on 29/10/2017.
 */
public class GrandDinner {

    static BufferedReader instream;
    private boolean ongoing = true, error = false;
    private String[] input;
    private int teams,tables;
    private int[] members, seats;
    private ArrayList<int[]> seatings;
    private String output, end;

    public static void main(String[] args) throws IOException {
        instream = new BufferedReader(new InputStreamReader(System.in));
        GrandDinner go = new GrandDinner();
        go.start();
    }

    private void start() throws IOException {
        while(ongoing){
            output = ""; end = "";
            error = false;
            input = instream.readLine().toString().split(" ");
            teams = Integer.parseInt(input[0]);
            tables = Integer.parseInt(input[1]);
            if ((teams+tables)==0){
                error = true;
                break;
            }
            members = new int[teams];
            seats = new int[tables];

            input = instream.readLine().split(" ");

            seatings = new ArrayList<>();

            for (int i = 0; i < members.length; i++) {
                members[i] = Integer.parseInt(input[i]);
            }
            input = instream.readLine().split(" ");

            for (int i = 0; i < seats.length; i++) {
                seats[i] = Integer.parseInt(input[i]);
                seatings.add(new int[i]);
            }

            Arrays.sort(members);
            if (members[members.length-1]>tables){
                //System.out.println("0");
            }
            else {
                for (int i = teams-1; i >= 0; i--) {
                    //System.out.println(i);
                    int c = 0;
                    for (int j = 0; j < members[i]-1; j++) {
                        //System.out.println(i);
                        seatAtTable(i,c);
                    }
                    //System.out.println();
                    if (!error){
                        end = "" +output.subSequence(0, output.length()) + "\n";
                    }
                }
            }
            if (error){
                //System.out.println(0);
            }else{
                System.out.println(1);
                System.out.println(end);
            }
        }
    }

    public void seatAtTable(int team, int tableCounter){
        //System.out.println("entered this place, " + team + " " + tableCounter);
        while(tableCounter<tables) {
            for (int i = tableCounter; i < seatings.get(tableCounter).length; i++) {
                if (seatings.get(tableCounter)[i] == team) {
                    i++;
                }
                if (seatings.get(tableCounter)[i] == 0) {
                    System.out.println("placed a member from team: " + team + " at table: " + tableCounter);
                    seatings.get(tableCounter)[i] = team;
                    output += tableCounter + " ";
                    return;
                }
            }
            tableCounter++;
        }

    }
}
