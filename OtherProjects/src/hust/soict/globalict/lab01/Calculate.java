package hust.soict.globalict.lab01;
//+ - * 
import javax.swing.JOptionPane;
public class Calculate {
  public static void main(String[] args) {
      //variable declaration
      String strNum1, strNum2;
      double num1, num2;

      //input variable
      strNum1 = JOptionPane.showInputDialog(null, "Please enter the first number", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
      strNum2 = JOptionPane.showInputDialog(null, "Please enter the second number", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
      
      //convert string to double
      num1 = Double.parseDouble(strNum1);
      num2 = Double.parseDouble(strNum2);

      //math operation
      double sum = num1 + num2;
      double difference = num1 - num2;
      double product = num1 * num2;
      double quotient = num1 / num2;

      //output
      JOptionPane.showMessageDialog(null, num1 + " + " + num2 + " = " + sum);
      JOptionPane.showMessageDialog(null, num1 + " - " + num2 + " = " + difference);
      JOptionPane.showMessageDialog(null, num1 + " * " + num2 + " = " + product);
      JOptionPane.showMessageDialog(null, num1 + " / " + num2 + " = " + quotient);

      System.exit(0);
  }
  
}