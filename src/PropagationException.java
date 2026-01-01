public class PropagationException {
    void n(){
        int num = 50/0;
    }
    void m(){
        n();
    }
    void p()
    {
        try {
            n();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        PropagationException obj = new PropagationException();
        obj.p();
        System.out.println("Rest of code");
    }
}
