import java.util.Scanner;

public class ex63 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the height of the triangle: ");
        int n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= n - i; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i*2 - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        input.close();
    }
}