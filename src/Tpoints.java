public class Tpoints {
    public static void main(String[] args) {
        try {
            int a=50/0;
        }
        catch (ArithmeticException e){
            System.out.println(e);
        }
        System.out.println("Rest of code");
    }
}
