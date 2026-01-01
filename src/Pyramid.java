import java.util.Scanner;

public class Pyramid {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int num= input.nextInt();
        int row,col;
        for(row=1;row<=num;row++){

            for (col=1;col<=num-row;col++){
                System.out.print(" ");
            }
            for (col=1;col<=row;col++){
                System.out.print("  *");
            }
            System.out.println();
        }
    }
}
