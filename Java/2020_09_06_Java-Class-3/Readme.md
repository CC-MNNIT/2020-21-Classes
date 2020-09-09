# Java Class 3

#### September 6th, 2020

### Softablitz Class 3 [Recording](https://drive.google.com/file/d/1FqqSQ9k9gh_kvPRxuMURz1V2gKMMKOix/view?usp=sharing)

## Class Content :-

### Method Overriding :-
- In a class hierarchy, when a method in a subclass has the same name and type signature as a method in its superclass, then the method in the subclass is said to override the method in the superclass.
- When an overridden method is called from within its subclass, it will always refer to the version of that method defined by the subclass. The version of the method defined by the superclass will be hidden.
- Method overriding occurs only when the names and the type signatures of the two methods are identical. If they are not, then the two methods are simply overloaded.
- Static Methods are never overrided, they are simply hidden.

#### **[1.java](1.java)**
```java
// Method overriding.
class A {
    int i, j;

    A(int a, int b) {
        i = a;
        j = b;
    }

    // display i and j
    void show() {
        System.out.println("i and j: " + i + " " + j);
    }
}

class B extends A {
    int k;

    B(int a, int b, int c) {
        super(a, b);
        k = c;
    }

    // display k -- this overrides show() in A
    void show() {
        System.out.println("k: " + k);
    }
}
  
class Override {
    public static void main(String args[]) {
        B subOb = new B(1, 2, 3);

        subOb.show(); // this calls show() in B
    }
}
```

#### **[2.java](2.java)**
```java
// Methods with differing type signatures are overloaded -- not overridden.
class A {
    int i, j;

    A(int a, int b) {
        i = a;
        j = b;
    }

    // display i and j
    void show() {
        System.out.println("i and j: " + i + " " + j);
    }
}

// Create a subclass by extending class A.
class B extends A {
    int k;

    B(int a, int b, int c) {
        super(a, b);
        k = c;
    }

    // overload show()
    void show(String msg) {
        System.out.println(msg + k);
    }
}
  
class Override {
    public static void main(String args[]) {
        B subOb = new B(1, 2, 3);

        subOb.show("This is k: "); // this calls show() in B
        subOb.show(); // this calls show() in A
    }
}
```

### Dynamic Method Dispatch :-
- Dynamic method dispatch is the mechanism by which a call to an overridden method is resolved at run time, rather than compile time.
- Dynamic method dispatch is important because this is how Java implements run-time polymorphism.
- A superclass reference variable can refer to a subclass object.
    ![Class Casting](1.png)
- It is the type of the object being referred to (not the type of the reference variable) that determines which version of an overridden method will be executed. 
- It allows a general class to specify methods that will be common to all of its derivatives, while allowing subclasses to define the specific implementation of some or all of those methods.

#### **[3.java](3.java)**
```java
// Using run-time polymorphism.
class Figure {
    double dim1;
    double dim2; 

    Figure(double a, double b) {
        dim1 = a;
        dim2 = b;
    }

    double area() {
        System.out.println("Area for Figure is undefined.");
        return 0;
    }
}

class Rectangle extends Figure {
    Rectangle(double a, double b) {
        super(a, b);
    }

    // override area for rectangle
    double area() {
        System.out.println("Inside Area for Rectangle.");
        return dim1 * dim2;
    }
}

class Triangle extends Figure {
    Triangle(double a, double b) {
        super(a, b);
    }

    // override area for right triangle
    double area() {
        System.out.println("Inside Area for Triangle.");
        return dim1 * dim2 / 2;
    }
}

class FindAreas {
    public static void main(String args[]) {
        Figure f = new Figure(10, 10);
        Rectangle r = new Rectangle(9, 5);
        Triangle t = new Triangle(10, 8);
        
        Figure figref;

        figref = r;
        System.out.println("Area is " + figref.area());
        
        figref = t;
        System.out.println("Area is " + figref.area());
        
        figref = f;
        System.out.println("Area is " + figref.area());
    }
}
```

### Object Class :-

- **Object** class is the parent of every class in Java. All other classes are subclasses of Object. That is, Object is a superclass of all other classes. 
- A reference variable of type Object can refer to an object of any other class.
    ![Methods of Object Class](2.png)
- The `equals( )` method compares two objects. It returns true if the objects are equal, and false otherwise. The precise definition of equality can vary, depending on the type of objects being compared. 
- The `toString( )` method returns a string that contains a description of the object on which it is called. Also, this method is automatically called when an object is output using `println( )`. Many classes override this method. Doing so allows them to tailor a description specifically for the types of objects that they create.

#### **[4.java](4.java)**
```java
class Student{  
    int rollno;  
    String name;  
    String city;  
    
    Student(int rollno, String name, String city){  
        this.rollno=rollno;  
        this.name=name;  
        this.city=city;  
    }  
    
    public String toString(){//overriding the toString() method  
        return rollno+" "+name+" "+city;  
    }

    public static void main(String args[]){  
        Student s1=new Student(101,"Raj","lucknow");  
        Student s2=new Student(102,"Vijay","ghaziabad");  
        
        System.out.println(s1);//compiler writes here s1.toString()  
        System.out.println(s2);//compiler writes here s2.toString()  
    }  
} 
```


### Wrapper Class :-

- Java provides type wrappers, which are classes that encapsulate a primitive type within an object.
- The type wrappers are **Double**, **Float**, **Long**, **Integer**, **Short**, **Byte**, **Character**, and **Boolean**.
- These classes offer a wide array of methods that allow you to fully integrate the primitive types into Java’s object hierarchy.

    #### **[5.java](5.java)**
    ```java
    // Demonstrate a type wrapper.
    class Wrap {
        public static void main(String args[]) {
            Integer iOb = new Integer(100);
            int i = iOb.intValue();
            System.out.println(i + " " + iOb); // displays 100 100
        }
    }
    ```

- Autoboxing is the process by which a primitive type is automatically encapsulated (boxed) into its equivalent type wrapper whenever an object of that type is needed. There is no need to explicitly construct an object.
- Auto-unboxing is the process by which the value of a boxed object is automatically extracted (unboxed) from a type wrapper when its value is needed.

    #### **[6.java](6.java)**
    ```java
    // Demonstrate autoboxing/unboxing.
    class AutoBox {
        public static void main(String args[]) {
            Integer iOb = 100; // autobox an int
            int i = iOb; // auto-unbox
            System.out.println(i + " " + iOb);// displays 100 100
        }
    }
    ```
    


### Abstract Class

- You can require that certain methods be overridden by subclasses by specifying the abstract type modifier. A subclass must override them—it cannot simply use the version defined in the superclass.
- Any class that contains one or more abstract methods must also be declared abstract.
- There can be no objects of an abstract class.
- Any subclass of an abstract class must either implement all of the abstract methods in the superclass, or be declared abstract itself. 
- Although abstract classes cannot be used to instantiate objects, they can be used to create object references, because Java’s approach to run-time polymorphism is implemented through the use of superclass references 

#### **[7.java](7.java)**
```java
// Using abstract methods and classes.
abstract class Figure {
    double dim1;
    double dim2; 

    Figure(double a, double b) {
        dim1 = a;
        dim2 = b;
    }

    // area is now an an abstract method 
    abstract double area();
}

class Rectangle extends Figure {
    Rectangle(double a, double b) {
        super(a, b);
    }

    // override area for rectangle
    double area() {
        System.out.println("Inside Area for Rectangle.");
        return dim1 * dim2;
    }
}

class Triangle extends Figure {
    Triangle(double a, double b) {
        super(a, b);
    }

    // override area for right triangle
    double area() {
        System.out.println("Inside Area for Triangle.");
        return dim1 * dim2 / 2;
    }
}

class AbstractAreas {
    public static void main(String args[]) {
    // Figure f = new Figure(10, 10); // illegal now
        Rectangle r = new Rectangle(9, 5);
        Triangle t = new Triangle(10, 8);
        
        Figure figref; // this is OK, no object is created

        figref = r;
        System.out.println("Area is " + figref.area());
        
        figref = t;
        System.out.println("Area is " + figref.area());
    }
}
```
