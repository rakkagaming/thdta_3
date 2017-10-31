package Tentamen;

/**
 * Created by robin on 20/10/2017.
 */
public class E1 {
    static int rounds = 0;
    public static void main(String[] args) {
        int[] array = new int[2048];

        for (int i = 0; i < 2048; i++) {
            if (i<1024){array[i]=i;}
            else{array[i] = 5000-i;}
        }
        System.out.println(largest(array,0,array.length-1));
        System.out.println(rounds);
    }

    private static int power(int a, int b) {
        if(b==0) return 1;
        int c = power(a, b/2);
        if (b%2==0) return c*c;
        else return a*c*c;
    }

    private static int largest(int[] array, int a, int b){
        if(a==b) {return a;}
        if (b-a==1){
            int i = (array[a]>array[b]?a:b);
            rounds ++;
            return i;
        }
        rounds++;
        int k = ((b-a)/2)+a;
        if (array[k]<array[k-1]) return largest(array,a,k-1);
        return largest(array,k,b);
    }
}
