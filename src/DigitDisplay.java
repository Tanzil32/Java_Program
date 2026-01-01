public class DigitDisplay {
    public static void main(String[] args) {
        int count =0;
        for (int a=1;a<=5;a++){
            for (int b=1;b<=5;b++){
                for (int c=1;c<=5;c++){
                    for (int d=1;d<=5;d++){
                        for (int e=1;e<=5;e++){
                            if(a!=b && a!=c && a!=d && a!=e
                                 && b!=c && b!= d && b!=e &&
                                c!=d && c!= e && d!=e){
                                int num = a * 10000 + b * 1000 + c * 100 + d * 10 + e;
                                System.out.println(num);
                                count++;
                            }

                        }
                    }
                }
            }
        }
        System.out.println("Count : "+count);
    }
}
