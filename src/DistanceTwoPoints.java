import java.util.Scanner;

public class DistanceTwoPoints {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        double x1,x2,y1,y2;
        System.out.print("Iput the latitude of coordinate 1 : ");
        x1= Math.toRadians(input.nextDouble());
        System.out.print("Iput the longitude of coordinate 1 : ");
        x2= Math.toRadians(input.nextDouble());
        System.out.print("Iput the latitude of coordinate 2 : ");
        y1= Math.toRadians(input.nextDouble());
        System.out.print("Iput the longitude of coordinate 2 : ");
        y2= Math.toRadians(input.nextDouble());

        double r= 6371.01, d;
        d = r * Math.acos(Math.sin(x1) * Math.sin(y1) + Math.cos(x1) * Math.cos(y1) * Math.cos(x2 - y2));


        System.out.println("The distance between two points :" +d);

    }
}
