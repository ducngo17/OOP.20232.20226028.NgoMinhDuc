

//ax + b = 0

import javax.swing.JOptionPane;
public class LinearEquation {
 public static void main(String[] args) {
     //variable declaration
     String stra, strb;

     //input
     stra = JOptionPane.showInputDialog(null, "Please enter the coefficient a: ", "Input a", JOptionPane.INFORMATION_MESSAGE);
     strb = JOptionPane.showInputDialog(null, "Please enter the coefficient b: ", "Input b", JOptionPane.INFORMATION_MESSAGE);
     
     //convert string to double
     double a = Double.parseDouble(stra);
     double b = Double.parseDouble(strb);


     if (a == 0) {
         //a = 0 and b = 0 then infinite solution
         if (b == 0) JOptionPane.showMessageDialog(null, "The equation has infinitely many solutions");
         //a = 0 and b != 0 then no solution
         else JOptionPane.showMessageDialog(null, "The equation has no solutions");
     }
     else {
         //1 solution
         double x = -b/a;
         JOptionPane.showMessageDialog(null, "The equation has 1 solution x = " + x);
     }
 }
}