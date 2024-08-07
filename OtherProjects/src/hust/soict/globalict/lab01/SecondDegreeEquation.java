package hust.soict.globalict.lab01;


import javax.swing.JOptionPane;
import java.lang.Math; 


public class SecondDegreeEquation {
  public static void main(String[] args) {
      //input
      String stra, strb, strc;
      stra = JOptionPane.showInputDialog(null, "Please enter a: ", "Input a", JOptionPane.INFORMATION_MESSAGE);
      strb = JOptionPane.showInputDialog(null, "Please enter b: ", "Input b", JOptionPane.INFORMATION_MESSAGE);
      strc = JOptionPane.showInputDialog(null, "Please enter c: ", "Input c", JOptionPane.INFORMATION_MESSAGE);

      //convert string to double
      double a = Double.parseDouble(stra);
      double b = Double.parseDouble(strb);
      double c = Double.parseDouble(strc);


      if (a == 0) {
          if (b == 0) {
              //a = b = c = 0 then many solutions
              //a = b = 0, c != 0 then no solution
              if (c == 0) JOptionPane.showMessageDialog(null, "The equation has infinitely many solutions");
              else JOptionPane.showMessageDialog(null, "The equation has no solutions");
          }
          else {
              //linear equation
              double x = -c/b;
              JOptionPane.showMessageDialog(null, "The equation has 1 solution x = " + x);
          }
      }
      else {
          //use delta --> 3 cases
          double delta = b*b - 4*a*c;
          if (delta < 0) JOptionPane.showMessageDialog(null, "The equation has no solutions");
          else if (delta == 0) JOptionPane.showMessageDialog(null, "The equation has one solution x = " + -b/(2*a));
          else {
              JOptionPane.showMessageDialog(null, "The equation has two solutions: \n x1 = " + ((-b + Math.sqrt(delta))/(2*a)) + "\nx2 = " + ((-b - Math.sqrt(delta))/(2*a)));
          }
      }
  }
}