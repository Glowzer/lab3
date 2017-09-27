import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class array7 {
    private static int[][] arr;
    private static int i;
    private static int n;

    public static void main(String[] argc) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter size Matrix:");

        try{
            int n = Integer.parseInt(br.readLine());

            int[][] matrix = new int[n][n];
            Random r = new Random();
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    matrix[i][j] = r.nextInt(2*n + 1) - n;

            System.out.println("Source Matrix:");
            outputArray(matrix, n);

            task(matrix, n);

            System.out.println("Result Matrix:");
            outputArray(matrix, n);

        } catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
    }

    public static void task(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            int average = averageScore(arr, i, n);
            for (int j = 0; j < n; j++)
                arr[i][j] -= average;
        }
    }

    private static int averageScore(int[][] arr, int i, int n) {
        int sum = 0;
        for (int j = 0; j < n; j++)
            sum += arr[i][j];
        return sum / n;
    }

    public static void outputArray(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
}
