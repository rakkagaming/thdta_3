package Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by robin on 18/10/2017.
 */
public class RomanNumerals {

    static BufferedReader instream;
    private String[] input;
    private ArrayList<String> roman;
    private boolean ongoing = true;

    public static void main(String[] args) throws IOException {
        instream = new BufferedReader(new InputStreamReader(System.in));
        RomanNumerals go = new RomanNumerals();

        go.start();
    }

    private int decodeLetter(char letter){
        switch (letter){
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }

    private void start() throws IOException {
        String output, temp;
        while(ongoing){
            roman = new ArrayList<>();
            int k = 0;
            output = "";
            temp = "";
            input = instream.readLine().toString().split("");
            if(input[0].contains("#")){
                ongoing = false;
                return;
            }
            for (int i = 0; i < input.length; i++) {
                if(input[i].contains("+") || input[i].contains("=")){
                    roman.add(temp);
                    temp = "";
                    k++;
                }else{
                    temp += input[i];
                }
            }
            roman.add(temp);


            System.out.println(roman.get(0) + " " + roman.get(1) + " " + roman.get(2));
            //First check roman, aka check if it is Correct or incorrect

            if (checkRoman(roman.get(0)) + checkRoman(roman.get(1)) == checkRoman(roman.get(2))){
                output += "Correct ";
            }else{
                output += "Incorrect ";
            }
            System.out.println(output);
        }
    }

    private int checkRoman(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += decodeLetter(s.charAt(i));
        }
        return sum;
    }

}
