package ex64;

import java.util.Scanner;

public class ex64 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter year");
        int year = input.nextInt();
        System.out.println("Enter month");
        input.nextLine();   //skip newline character
        String month = input.nextLine();

        int days = 0;

        switch (month) {
            case "January":
            case "March":
            case "May":
            case "July":
            case "August":
            case "October":
            case "December":
            case "Jan":
            case "Mar":
            case "Jul":
            case "Aug":
            case "Oct":
            case "Dec":
            case "Jan.":
            case "Mar.":
            case "Aug.":
            case "Oct.":
            case "Dec.":
            case "1":
            case "3":
            case "5":
            case "7":
            case "8":
            case "10":
            case "12":
                days = 31;
                break;

            case "February":
            case "Feb":
            case "Feb.":
            case "2":
                //leap year
                if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0))
                    days = 29;
                else
                    days = 28;
                break;

            case "April":
            case "June":
            case "September":
            case "November":
            case "Apr":
            case "Jun":
            case "Sep":
            case "Nov":
            case "Apr.":
            case "Sep.":
            case "Nov.":
            case "4":
            case "6":
            case "9":
            case "11":
                days = 30;
                break;

            default:    
                System.out.println("Invalid month ");
                break;
        }
        if (days != 0) System.out.print("Number of days: " + days);
        input.close();
    }
}