package Arithmetics;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by robin on 17/10/2017.
 */
public class AllInAll {

    static String[] input;
    static String sub,whole;
    static boolean ongoing = true ;
    static BufferedReader instream;

    public static void main(String[] args) {
        instream = new BufferedReader(new InputStreamReader(System.in));
        while(ongoing) {
            try {
                input = instream.readLine().toString().split(" ");
                sub = input[0];
                whole = input[1];

                if (isSub()){
                    System.out.println("Yes");
                } else System.out.println("No");


            } catch (Exception e) {
                ongoing = false;
                break;
            }
        }
    }

    private static boolean isSub() {
        int x = 0;
        for (int i = 0; i < whole.length(); i++) {
            if (whole.charAt(i) == sub.charAt(x)){
                x++;
            }
            if (x==sub.length()) return true;
        }
        return false;
    }
}
