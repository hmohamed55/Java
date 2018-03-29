/*Assignment 2
 * ShapeTraits.Java
 * 
 * Author: Hanad Mohamed
 * Date: 02/12/2018
 * 
 * 
 * 
 * Answer to question 10.4: Polymorphism allows you to program "in the general" meaning you can write code that applies to
 * objects of multiple classes in a program, versus "In the specific" which means writing code that can only be applied to one class.
 * Programming "In the general" is convenient and efficient because you don't have to modifiy a method when using it in a different class.
 * 
 * Answer to question 10.8: Interfaces are usually used when classes that are not related must 
 * utilize common methods. Abstract classes, unlike interfaces, are classes. Methods of an abstract class can be defined with any visability
 * while interface methods must be defined using public.  
 * 
 * Answer to question 10.9:  If each added method within Interface defined with implementation then no implementing Class is affected. 
 * The implementing class overrides the default implementation provided by the interface so 
 * the class that implemented the original interface is not broken.
 * 
 * Answer to question 10.11: There would be two reasons to add static methods to interfaces. The first is
 * that you would have access to the utility methods that are general to all the types.  And the second reason would be 
 * to create an instance(s) of that interface.
 * 
 * Answer to question 10.12: There would be two reasons to add private methods to interfaces.
 * The first would be more code reusability since you don't need to write duplicate code. The second reason would be that 
 * it gives the user a chose as two which methods they would like exposed to the rest of the classes.
*/
public interface ShapeTraits

{
     //This class creates the array of shape references
     public static void main(String[] args)

     {

          Shape[] figures = {new Circle("Circle", 13), new Square("Square", 4),

                   new Triangle("Triangle", 5,7,8), new Sphere("Sphere",7),

                   new Cube("Cube", 12),new Tetrahedron("Tetrahedron", 6)};

          for(Shape s: figures)

          {

              System.out.println(s.toString());

              System.out.print("\n");

          }

     }

}
abstract class Shape

{

     //variable declaration

     private String type;

     //constructor

     public Shape(String type)

     {

          this.type=type;

     }
     public String getType()

     {

          return type;

     }
}
//The following class directs the program to find the area for two dimensional shapes
abstract class TwoDimensional extends Shape

{

     public TwoDimensional(String type)

     {

          super(type);

     }

     public abstract double getArea();

}
//The following class directs the program to find the surface area and volume for three dimensinal shapes
abstract class ThreeDimensional extends Shape

{

     public ThreeDimensional(String type)

     {

          super(type);

     }
     public abstract double getArea();

     public abstract double getVolume();

}
//The following class establishes how to find area of a circle using PI and radius
class Circle extends TwoDimensional

{


          private double radius;

          final double Pi;

          String shapeName;


          public Circle(String shapeName, double radius)

          {

              super(shapeName);

              this.radius = radius;

              Pi = 3.14159;

          }

          public double getRadius()

          {

              return radius;

          }

          public void setRadius(double radius)

          {

              this.radius = radius;

          }
          public double getArea()

          {

              return (Pi * radius * radius);

          }
          public String toString()

          {

              String s = getType() + "\nRadius: " + radius + "\nArea: " + getArea();

              return s;

          }

}
//The following class establishes how to find area of a square
class Square extends TwoDimensional

{
     private double side;

     String square;
     Square(String square, double side)

     {

          super(square);

          this.side = side;

     }

     public double getSide()

     {

          return side;

     }

     public void setSide(double side)

     {

          this.side = side;

     }
     public double getArea()

     {

          return (side * side);

     }
     public String toString()

     {

          String s = getType()+ "\nSide : " + side + "\nArea: " + getArea();
          return s;

     }

    }

//The following class find perimeter of a triangle in order to find area    
class Triangle extends TwoDimensional
{
     double side1;

     double side2, side3;

     String triangle;
     public Triangle(String triangle, double side1, double side2, double side3)

     {

          super(triangle);

          this.side1 = side1;

          this.side2 = side2;

          this.side3 = side3;

     }
     public double getSide1()

     {

          return side1;

     }

     public void setSide1(double side1)

     {

          this.side1 = side1;

     }

     public double getSide2()

     {

          return side2;

     }

     public void setSide2(double side2)

     {

          this.side2 = side2;

     }

     public double getSide3()

     {

          return side3;

     }

     public void setSide3(double side3)

     {

          this.side3 = side3;

     }
     public double getArea()

     {

          double p = getPerimeter() / 2;

          return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));

     }
     public double getPerimeter()

     {

          return (side1 + side2 + side3);

     }
     public String toString()

     {

          String s = getType() + "\nSide 1: " + side1 + " Side 2: " + side2

                   + " Side 3: " + side3 + "\nArea: " + getArea();
          return s;

     }
}
class Sphere extends ThreeDimensional

{
     private double radius;

     String shapeName;

     final double PI;

     public Sphere (String shapeName, double radius)

     {

          super(shapeName);

          this.radius = radius;

          PI = 3.14159;

     }
     public double getRadius()

     {

          return radius;

     }
     public void setRadius(double radius)

     {

          this.radius = radius;

     }
     public double getArea()

     {

          return (4 * PI * radius * radius);

     }
     public double getVolume()

     {

          return (4.0/3)*PI*radius*radius*radius;

     }
     public String toString()

     {
          String s = getType()+ "\nRadius: " + radius + "\nSurface Area: " + getArea()

                   + "\nVolume: " + getVolume();

          return s;
     }
}
//The following class finds surface area and volume of a cube
class Cube extends ThreeDimensional

{
    String cube; 
    private double side;

     
     public Cube (String cube, double side)

     {

          super(cube);

          this.side = side;

     }  
     public double getSide()

    {

          return side;

     }
     public void setSide(double side)

     {

          this.side = side;

     }
     public double getArea()

     {

          return 6*side*side;

     }
     public double getVolume()

     {

          return side*side*side;

     }
     public String toString()

     {

          String s = getType()+ "\nSide : " + side + "\nSurface Area: " + getArea() + "\nVolume: "

                   + getVolume();

          return s;

     }

}
//The following class finds surface area and volume of a Tetrahedron
class Tetrahedron extends ThreeDimensional

{

     private double side;

     String Tet;

    

     public Tetrahedron (String Tet, double side)

     {

          super(Tet);

          this.side = side;

     }  
     public double getSide()

     {

          return side;

     }
     public void setSide(double side)

     {

          this.side = side;

     }
     public double getArea()

     {

          return Math.sqrt(3)*side*side;

     }
     public double getVolume()

     {

          return ((side*side*side)/(6*(Math.sqrt(2))));

     }
     public String toString()

     {

          String s = getType()+ "\nSide : " + side + "\nSurface Area: " + getArea() + "\nVolume: "

                   + getVolume();

          return s;

     }

}
