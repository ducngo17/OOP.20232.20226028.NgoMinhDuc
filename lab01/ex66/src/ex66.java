import java.util.Scanner;

public class ex66 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        //input
        System.out.println("Enter the number of rows of 2 matrices: ");
        int m = input.nextInt();
        System.out.println("Enter the number of columns of 2 matrices: ");
        int n = input.nextInt();

        //declare
        //matrix 1
        int a1[][] = new int[m][n];
        //matrix 2
        int a2[][] = new int[m][n];
        //sum matrix
        int sum[][] = new int[m][n];

        //input matrix 1
        System.out.println("Enter the first matrix: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a1[i][j] = input.nextInt();
            }
        }  

        //input matrix 2
        System.out.println("Enter the second matrix: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a2[i][j] = input.nextInt();
                //
                sum[i][j] = a1[i][j] + a2[i][j];

            }
        }  
        
        //print sum matrix:
        System.out.println("The sum matrix is: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
        input.close();
    }
}