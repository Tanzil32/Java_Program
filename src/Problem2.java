import java.util.InputMismatchException;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter a real number: ");
            double num = input.nextDouble();

            if (num<0){
                System.out.println("Cannot compute the square root of a negative number");

            }
            else {
                double result = Math.sqrt(num);
                System.out.println("The square root of " + num + " is" + result);
            }
        }
        catch(InputMismatchException e){
            System.out.println("Error: Invalid input. Please enter a valid real number.");
        }
    }
}
