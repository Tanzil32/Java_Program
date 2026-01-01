import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = input.nextInt();
        for (int row= 1;row<=num;row++){
            for (int space=1;space<=num-row;space++){
                System.out.print(" ");
            }
            for (int col= 1;col<=row;col++){
                System.out.printf("%c",64+col);
            }
            for(int col= row-1;col>=1;col--){
                System.out.printf("%c",64+col);
            }
            System.out.println();
        }
        for (int row= num-1;row>=1;row--){
            for (int space=1;space<=num-row;space++){
                System.out.print(" ");
            }
            for (int col= 1;col<=row;col++){
                System.out.printf("%c",64+col);
            }
            for(int col= row-1;col>=1;col--){
                System.out.printf("%c",64+col);
            }
            System.out.println();
        }
    }
}
