public class Tpoints2 {
    public static void main(String[] args) {
        String str ="abc";
        try {
            int n = Integer.parseInt(str);
            System.out.println(n);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
}
