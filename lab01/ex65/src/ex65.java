import java.util.Scanner;

public class ex65 {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter the number of elements: ");

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double sum = 0;

        double a[] = new double[n];

        for (int i = 0; i < n; i++) {
            a[i] = input.nextDouble();
            sum += a[i];
        }
        //bubble sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    double temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        System.out.println("The sorted array is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\nThe sum is: " + sum);
        System.out.println("The average value is: " + sum/n);
        input.close();
    }
}