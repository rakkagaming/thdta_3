package Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 18/10/2017.
 */
public class RomanNumerals {

    static BufferedReader instream;
    private String input;
    private String[] roman;
    private StringBuilder x;
    private boolean ongoing = true;
    private int solutionNumber;

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
        String output;
        while(ongoing){
            roman = new String[3];
            output = "";
            input = instream.readLine().toString();
            if(input.contains("#")){
                ongoing = false;
                return;
            }
            x = new StringBuilder();
            x.append(input);
            boolean[] ch = new boolean[26];
            for (int i = 0; i < input.length()  ; i++) {
                if(input.charAt(i) == '+' || input.charAt(i) == '='){
                    x.replace(i,i+1," ");
                }else{
                    ch[x.charAt(i) - 'A'] = true;
                }
            }
            input = x.toString();
            roman = input.split(" ");

            boolean[] head  = new boolean[128];
            head[roman[0].charAt(0)] = true;
            head[roman[1].charAt(0)] = true;
            head[roman[2].charAt(0)] = true;

            List<Character> all = new ArrayList<>();

            for (int i = 0; i < 26; i++) {
                if (ch[i]) {
                    all.add(Character.toChars(65 + i)[0]);
                }
            }

            int[] value = new int[128];
            boolean[]used = new boolean[10];

            solutionNumber = 0;

            solve(0, all, value, used, head);

            //System.out.println(roman[0] + " + " + roman[1] + " = " + roman[2]);
            //System.out.println(checkRoman(roman[0]) + " " + checkRoman(roman[1])+ " " + checkRoman(roman[2]));
            if (checkRoman(roman[0]) + checkRoman(roman[1]) == checkRoman(roman[2])){
                output += "Correct ";
            }else{
                output += "Incorrect ";
            }

            switch (solutionNumber){
                case 0:
                    output += "impossible";
                    break;
                case 1:
                    output += "valid";
                    break;
                default:
                    output += "ambiguous";
                    break;
            }

            System.out.println(output);

        }
    }

    private void solve(int now, List<Character> all, int[] value, boolean[] used, boolean[] head) {
        if (solutionNumber > 1) return;
        if (now == all.size()) {
            int n1 = 0, n2 = 0, n3 = 0;

            for (int i = 0; i < roman[0].length(); i++) {
                n1 = n1 * 10 + value[roman[0].charAt(i)];
            }
            for (int i = 0; i < roman[1].length(); i++) {
                n2 = n2 * 10 + value[roman[1].charAt(i)];
            }
            for (int i = 0; i < roman[2].length(); i++) {
                n3 = n3 * 10 + value[roman[2].charAt(i)];
            }
            if (n1 + n2 == n3) {
                solutionNumber++;
            }
            return;
        }
        boolean var = head[all.get(now)];
        int tempVar;
        if (!var) {
            tempVar = 0;
        } else {
            tempVar = 1;
        }
        for (int d = tempVar; d < 10 && solutionNumber <= 1; d++) {
            if (!used[d]) {
                value[all.get(now)] = d;
                used[d] = true;
                solve(now + 1, all, value, used, head);
                used[d] = false;
            }
        }
    }

    private int checkRoman(String s) {
        int sum = 0;
        for (int i = 0; i < s.length()-1; i++) {
            if (decodeLetter(s.charAt(i))<decodeLetter(s.charAt(i+1))) sum -= decodeLetter(s.charAt(i));
            else sum += decodeLetter(s.charAt(i));
        }
        sum += decodeLetter(s.charAt(s.length()-1));
        return sum;
    }

}
