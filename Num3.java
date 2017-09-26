import java.util.Random;
import java.util.Scanner;

public class Num3 {
    public static void main(String[] argc){
        if(argc.length != 1){
            System.err.println("Invalid number of parameters");
            System.exit(1);
        }
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
        String select = argc[0];
        int[] res = new int[n * n];
        int ind = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                res[ind++] = a[i][j];
            }
        }
        int max_amount = -1;
        if (select.equals("inc")) {
            int tmp = 0;
            for(int i = 1; i < n * n; i++){
                if(res[i-1] < res[i]){
                    tmp++;
                }else{
                    if(max_amount < tmp){
                        max_amount = tmp;
                        tmp = 0;
                    }
                }
            }
            if(max_amount < tmp){
                max_amount = tmp;
            }
        }else if (select.equals("dec")){
            int tmp = 0;
            for(int i = 1; i < n * n; i++){
                if(res[i-1] > res[i+1]){
                    tmp++;
                }else{
                    if(max_amount < tmp){
                        max_amount = tmp;
                        tmp = 0;
                    }
                }
            }
            if(max_amount < tmp){
                max_amount = tmp;
            }
        }else{
            System.err.println("Invalid parameter:".concat(select));
            System.exit(2);
        }
        System.out.println("Answer:" + Integer.toString(max_amount));
    }
}
