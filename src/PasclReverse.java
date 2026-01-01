import java.util.Scanner;

public class PasclReverse {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter a number : ");
            int n = input.nextInt();

            for (int row=n;row>=1;row--){
                for (int space =1;space<=n-row;space++){
                    System.out.print(" ");
                }
                int c=1;
                for (int col = 0;col<row;col++){
                    System.out.print(c+" ");
                    c = c*(row-col-1)/(col+1);
                }
                System.out.println("");
            }
        }
    }


