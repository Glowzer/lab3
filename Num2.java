import java.util.Random;
import java.util.Scanner;

public class Num2 {
    public static int[][] multi_matrix(int[][] mA, int[][] mB){
        int m = mA.length;
        int n = mB[0].length;
        int o = mB.length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < o; k++) {
                    res[i][j] += mA[i][k] * mB[k][j];
                }
            }
        }
        return res;
    }
    public static void main(String[] argc) {
        if (argc.length != 2) {
            System.err.println("Invalid number of parameters");
            System.exit(1);
        }
        int k = Integer.parseInt(argc[0]);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n <= 1) {
            System.err.println("Invalid N!");
            System.exit(3);
        }
        if (k >= n) {
            k /= n;
        }
        int[][] a = new int[n][n];
        Random rd = new Random(System.currentTimeMillis());
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = rd.nextInt(n + n + 1) - n;
            }
        }
        System.out.println("Previous matrix:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.printf("%8d ", a[i][j]);
            }
            System.out.println();
        }
        String select = argc[1];
        int[][] identity = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                identity[i][j] = 0;
            }
        }
        if (select.equals("top")) {
            for(int i = 0; i < n - 1; i++)
                identity[i][i+1] = 1;
            identity[n - 1][0] = 1;
            while(k > 0) {
                a = multi_matrix(identity, a);
                k--;
            }
        } else if (select.equals("left")) {
            for(int i = 0; i < n - 1; i++)
                identity[i][i+1] = 1;
            identity[n - 1][0] = 1;
            while(k > 0) {
                a = multi_matrix(a, identity);
                k--;
            }
        } else if (select.equals("right")) {
            for(int i = 0; i < n - 1; i++)
                identity[i+1][i] = 1;
            identity[0][n - 1] = 1;
            while(k > 0) {
                a = multi_matrix(a, identity);
                k--;
            }
        } else if (select.equals("bottom")) {
            for(int i = 0; i < n - 1; i++)
                identity[i+1][i] = 1;
            identity[0][n - 1] = 1;
            while(k > 0) {
                a = multi_matrix(identity, a);
                k--;
            }
        } else {
            System.err.println("Invalid parameter:".concat(select));
            System.exit(2);
        }
        System.out.println("New matrix:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.printf("%8d ", a[i][j]);
            }
            System.out.println();
        }
    }
}
