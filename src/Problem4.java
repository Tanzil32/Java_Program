import java.util.Scanner;
public class Problem4 {
    static void Excep(int n) throws Exception{
        if(n%2 !=0){
            throw new Exception("The number "+n+"is odd");
        }
        else {
            System.out.println("The number " + n + " is even");
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter a number : ");
            int num = input.nextInt();
            Excep(num);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
