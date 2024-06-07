package hust.soict.globalict.lab01;

import javax.swing.JOptionPane;

public class LinearSystem {
    public static void main(String[] args) {
        //input
        String stra11, stra12, stra21, stra22, strb1, strb2;
        stra11 = JOptionPane.showInputDialog(null, "Please enter a11: ", "Input a11", JOptionPane.INFORMATION_MESSAGE);
        stra12 = JOptionPane.showInputDialog(null, "Please enter a12: ", "Input a12", JOptionPane.INFORMATION_MESSAGE);
        stra21 = JOptionPane.showInputDialog(null, "Please enter a21: ", "Input a21", JOptionPane.INFORMATION_MESSAGE);
        stra22 = JOptionPane.showInputDialog(null, "Please enter a22: ", "Input a22", JOptionPane.INFORMATION_MESSAGE);
        strb1 = JOptionPane.showInputDialog(null, "Please enter b1: ", "Input b1", JOptionPane.INFORMATION_MESSAGE);
        strb2 = JOptionPane.showInputDialog(null, "Please enter b2: ", "Input b2", JOptionPane.INFORMATION_MESSAGE);

        //convert string to double
        double a11 = Double.parseDouble(stra11);
        double a12 = Double.parseDouble(stra12);
        double a21 = Double.parseDouble(stra21);
        double a22 = Double.parseDouble(stra22);
        double b1 = Double.parseDouble(strb1);
        double b2 = Double.parseDouble(strb2);
        

        double a1 = a11/a21;
        double a2 = a12/a22;
        double b = b1/b2;

        //if a11/a21 = a12/a22 != b1/b2 then no solution
        //if a11/a21 = a12/a22 = b1/b2 then many solutions (1 equation)
        if (a1 == a2 && a2 != b) JOptionPane.showMessageDialog(null, "The system has no solution");
        else if (a1 == a2 && a2 == b) JOptionPane.showMessageDialog(null, "The system has infinitely many solutions");
        //x = D1/D, y = D2/D (use determinant)
        else {
            double D = a11*a22 - a21*a12;
            double D1 = b1*a22 - b2*a12;
            double D2 = a11*b2 - a21*b1;
            double x = D1/D;
            double y = D2/D;
            JOptionPane.showMessageDialog(null, "The system has an unique solution (x,y) = (" + x + "," + y);
        }
    }
}