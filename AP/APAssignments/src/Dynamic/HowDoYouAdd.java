package Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by robin on 17/10/2017.
 */
public class HowDoYouAdd {
    static BufferedReader instream;
    static int k, n;
    static String[] input;
    static boolean ongoing = true;

    public static void main(String[] args) {
        instream = new BufferedReader(new InputStreamReader(System.in));

        while(ongoing){
            try {
                input = instream.readLine().toString().split(" ");
                n = Integer.parseInt(input[0]);
                k = Integer.parseInt(input[1]);

                if (n==0 && k==0){
                    ongoing = false;
                    break;
                }

                BigInteger a = BigInteger.ONE;
                BigInteger b = BigInteger.ONE;

                for (int i = n+1; i <=n+k-1 ; i++) {
                    a = a.multiply(BigInteger.valueOf(i));
                }
                for (int i = 1; i <= k-1; i++) {
                    b = b.multiply(BigInteger.valueOf(i));
                }

                a = a.divide(b);
                a = a.mod(BigInteger.valueOf(1000000));

                System.out.println(a);
            } catch (Exception e) {
                ongoing = false;
                break;
            }
        }
    }
}
