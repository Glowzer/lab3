import java.util.*;


public class Lab3 {
    public static void main(String[] args) {

        System.out.println("Enter dimension:");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        if(n < 1){
            System.err.println("Dimension is incorrect!");
            System.exit(1);
        }

        Integer matrix[][] = new Integer[n][n];
        Random random = new Random((new Date()).getTime());

        System.out.println("Dimension is : " + n);

        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt() % ( n + 1 );
                System.out.format("%4d",matrix[i][j]);
            }
            System.out.println("\n");
            Arrays.sort(matrix[i], new Comparator<Integer>() {
                        public int compare(Integer a, Integer b) {
                            if(b == 0)
                                return -1;

                            return 0;
                        }
                    }
            );
        }

        System.out.println("\n");
        System.out.println("Result:");
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.format("%4d ", matrix[i][j]);
            }
            System.out.println("\n");
        }
    }
}
