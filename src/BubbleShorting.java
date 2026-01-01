import java.util.Scanner;

public class BubbleShorting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter an array elements : ");
        for (int i=0;i<n;i++){
            arr[i]=input.nextInt();
        }
        System.out.print("Original Array : ");
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        //Ascending order
        for (int i=0;i<n-1;i++){
            for (int j= i+1;j<n;j++){
                if (arr[j]<arr[i]){
                    int temp = arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        System.out.println("Ascending order array : ");
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        input.close();

    }
}
