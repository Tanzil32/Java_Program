import java.util.Scanner;

public class Prattern {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number= input.nextInt();
        int k=1;
        for (int row=1;row<=number;row++){
            for(int col=1;col<=row;col++){
                System.out.print(k*k+" ");
                  k++;

            }
            System.out.println();

        }
    }
}
