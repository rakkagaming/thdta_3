package Arithmetics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by robin on 17/10/2017.
 */
public class WineTrading {

    static boolean ongoing = true;
    static int inhabitants;
    static int[] bottles,leftPart, rightPart;
    static long trades;
    static String[] input;
    static BufferedReader instream;


    public static void main(String[] args) {
        instream = new BufferedReader(new InputStreamReader(System.in));

        while(ongoing){
            try {
                inhabitants = Integer.parseInt(instream.readLine().toString());
                if(inhabitants == 0){
                    ongoing = false;
                    break;
                }
                input = instream.readLine().toString().split(" ");
                bottles = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

                leftPart = Arrays.copyOfRange(bottles,0,bottles.length/2);
                rightPart = Arrays.copyOfRange(bottles,bottles.length/2,bottles.length);

                trades = 0;

                //System.out.println("left size"+leftPart.length);
                //System.out.println("right size" + rightPart.length);
                for (int i = 0; i < leftPart.length-1; i++) {
                    //System.out.println("int left");
                    trades += Math.abs(leftPart[i]);
                    leftPart[i+1] = leftPart[i] + leftPart[i+1];
                }
                for (int i = rightPart.length-1; i > 0; i--) {
                    //System.out.println("in right");
                    trades += Math.abs(rightPart[i]);
                    rightPart[i-1] = rightPart[i-1] + rightPart[i];
                }

                trades += Math.abs(rightPart[0]);

                System.out.println(trades);


            } catch (Exception e) {
                System.out.println("error?");
                ongoing = false;
                break;
            }
        }
    }
}
