public class CatchExercise {
    public static void main(String[] args) {
        try {
            int a[] = new int[5];
            a[5]= 30/5;
        }
        catch (ArithmeticException e){
            System.out.println("ArithmeticException occurs! ");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(" ArrayIndexOutOfBoundsException! ");
        }
        System.out.println("Code runs");
    }
}
