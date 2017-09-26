import java.util.Random;
import java.util.Scanner;

public class Num1 {
    public static void main(String[] argc){
        if(argc.length != 2){
            System.err.println("Invalid number of parameters");
            System.exit(1);
        }
        int k = Integer.parseInt(argc[0]);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n <= 1){
            System.err.println("Invalid N!");
            System.exit(3);
        }
        int[][] a= new int[n][n];
        Random rd = new Random(System.currentTimeMillis());
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                a[i][j] = rd.nextInt(n + n + 1) - n;
            }
        }
        System.out.println("Previous matrix:");
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                System.out.printf("%8d ",a[i][j]);
            }
            System.out.println();
        }
        String select = argc[1];
        if (select.equals("rows")) {
            for (int i = a.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (a[j][k] > a[j + 1][k]) {
                        int[] tmp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = tmp;
                    }
                }
            }
        }else if (select.equals("cols")){
            for (int i = a.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (a[k][j] > a[k][j + 1]) {
                        for(int ind = 0; ind < a.length; ind++){
                            int tmp = a[ind][j];
                            a[ind][j] = a[ind][j + 1];
                            a[ind][j + 1] = tmp;
                        }
                    }
                }
            }
        }else{
            System.err.println("Invalid parameter:".concat(select));
            System.exit(2);
        }
        System.out.println("New matrix:");
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                System.out.printf("%8d ",a[i][j]);
            }
            System.out.println();
        }
    }
}
