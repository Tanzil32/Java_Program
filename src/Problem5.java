
import java.util.Scanner;
abstract class Shape {
    abstract void RectangleArea(double length, double breadth);

    abstract void SquareArea(double side);

    abstract void CircleArea(double radius);
}
   class Area extends Shape{
      @Override
      void RectangleArea(double length, double breadth){
          double area = length*breadth;
          System.out.println("Area of rectangle: "+area);
      }
      void SquareArea(double side){
          double area= side*side;
          System.out.println("Area of Square: "+area);
      }
      void CircleArea(double radius){
          double area = Math.PI * radius * radius;
          System.out.println("Area of Circle: "+area);
      }
   }

public class Problem5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Area a = new Area();
        // 4 rectangle
        for (int i=1;i<=4;i++){
            System.out.print("Enter a length : ");
            double length = input.nextDouble();
            System.out.print("Enter a breadth : ");
            double breadth = input.nextDouble();
            a.RectangleArea(length,breadth);
        }
        // 4 Squares
        for (int i=1;i<=4;i++){
            System.out.print("Enter a side : ");
            double side = input.nextDouble();
            a.SquareArea(side);
        }


    }
}
