package Arithmetics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by robin on 16/10/2017.
 */
public class BigMod {

    static BufferedReader instream;
    static boolean ongoing = true;

    public static void main(String[] args) throws IOException {
        instream = new BufferedReader(new InputStreamReader(System.in));

        start();
        instream.close();
        System.exit(0);
    }

    private static void start() {
        long base, power, mod;
        while(ongoing) {
            try {
                base = Integer.parseInt(instream.readLine().toString());
                power = Integer.parseInt(instream.readLine().toString());
                mod = Integer.parseInt(instream.readLine().toString());

                long output = bigModCalc(base, power, mod);
                System.out.println(output);

                instream.readLine();

            } catch (Exception e) {
                ongoing = false;
                return;
            }
        }
    }

    private static long bigModCalc(long base, long power, long mod) {

        if(power==0){
            return 1;
        }
        long z = bigModCalc(base, power/2 ,mod);

        if ( power % 2 == 0) {
            return ((long) Math.pow(z,2)) % mod;
        }
        else {
            return ((long) Math.pow(z,2) * base ) % mod;
        }

    }
}
