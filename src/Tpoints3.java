public class Tpoints3 {
    static  void valid(int age){
        if(age<18){
            throw new ArithmeticException("Not valid");
        }
        else {
            System.out.println("Valid");
        }
    }

    public static void main(String[] args) {
        try {
            int age=13;
            valid(age);
        }
        catch (ArithmeticException e){
            System.out.println(e);
        }
        System.out.println("Rest of code");
    }
}
