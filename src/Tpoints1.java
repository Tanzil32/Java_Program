public class Tpoints1 {
    public static void main(String[] args) {
        String str = null;
        try {
            int length= str.length();
            System.out.println("Result"+length);
        }
        catch (NullPointerException e){
            System.out.println("String length is null");
        }
    }
}
