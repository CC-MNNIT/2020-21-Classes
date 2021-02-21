# Java Class 3

### February 20<sup>th</sup>, 2021

## Table of Contents

- [Class recording](#class-recording)
- [Resources](#resources)
- [Class content](#class-content)

## Class Recording

### [Combined Panel](https://drive.google.com/file/d/1FgNBbPW2YGqGnR2eZ59Je_x5I349kk65/view?usp=sharing)

## Resources

- [Learning Resources](../../Java/Common%20Resources#resources): Link to all books and online learning resoruces for Java.
- [Softablitz 2k20 Classes](https://github.com/CC-MNNIT/2020-21-Classes/tree/master/Java): Softablitz is the software development event which targets building solutions for problem statements using Java.
- [Git Basics Book](https://github.com/progit/progit2/releases/download/2.1.277/progit.pdf): Book to cover git basics. Getting well versed with git and github is important, you will use git in all your projects.

>Explore as much as you can, go through all the recordings and resources. Wishing you all the best!!

## Class Content

#### **[12.java](12.java)**
```java
// Demonstrating some String methods.
class StringDemo2 {
    public static void main(String args[]) {
        String strOb1 = "First String";
        String strOb2 = "Second String";
        String strOb3 = strOb1;

        System.out.println("Length of strOb1: " + strOb1.length());

        System.out.println("Char at index 3 in strOb1: " + strOb1.charAt(3));

        if (strOb1.equals(strOb2))
            System.out.println("strOb1 == strOb2");
        else
            System.out.println("strOb1 != strOb2");

        if (strOb1.equals(strOb3))
            System.out.println("strOb1 == strOb3");
        else
            System.out.println("strOb1 != strOb3");
    }
}
```

#### **[13.java](13.java)**
```java
// Demonstrate method overloading.
class OverloadDemo {
    void test() {
        System.out.println("No parameters");
    }

    // Overload test for one integer parameter.
    void test(int a) {
        System.out.println("a: " + a);
    }

    // Overload test for two integer parameters.
    void test(int a, int b) {
        System.out.println("a and b: " + a + " " + b);
    }

    // overload test for a double parameter
    double test(double a) {
        System.out.println("double a: " + a);
        return a * a;
    }
}

class Overload {
    public static void main(String args[]) {
        OverloadDemo ob = new OverloadDemo();
        double result;

        // call all versions of test()
        ob.test();
        ob.test(10);
        ob.test(10, 20);
        result = ob.test(123.25);
        System.out.println("Result of ob.test(123.25): " + result);
    }
}
```

#### **[14.java](14.java)**
```java
// Automatic type conversions apply to overloading.
class OverloadDemo {
    void test() {
        System.out.println("No parameters");
    }

    // Overload test for two integer parameters.
    void test(int a, int b) {
        System.out.println("a and b: " + a + " " + b);
    }

    // overload test for a double parameter and return type
    void test(double a) {
        System.out.println("Inside test(double) a: " + a);
    }
}

class Overload {
    public static void main(String args[]) {
        OverloadDemo ob = new OverloadDemo();
        int i = 88;

        ob.test();
        ob.test(10, 20);

        ob.test(i); // this will invoke test(double)
        ob.test(123.2); // this will invoke test(double)
    }
}
```

#### **[15.java](15.java)**
```java
/* Here, Box defines three constructors to initialize
   the dimensions of a box various ways.
*/
class Box {
    double width;
    double height;
    double depth;
  
    // constructor used when all dimensions specified
    Box(double w, double h, double d) {
      width = w;
      height = h;
      depth = d;
    }
  
    // constructor used when no dimensions specified
    Box() {
      width = -1;  // use -1 to indicate
      height = -1; // an uninitialized
      depth = -1;  // box
    }
  
    // constructor used when cube is created
    Box(double len) {
      width = height = depth = len;
    }
  
    // compute and return volume
    double volume() {
      return width * height * depth;
    }
  }
    
  class OverloadCons {
    public static void main(String args[]) {
      // create boxes using the various constructors
      Box mybox1;
      mybox1 = new Box(10, 20, 15);
      Box mybox2 = new Box();
      Box mycube = new Box(7);
  
      double vol;
  
      // get volume of first box
      vol = mybox1.volume();
      System.out.println("Volume of mybox1 is " + vol);
  
      // get volume of second box
      vol = mybox2.volume();
      System.out.println("Volume of mybox2 is " + vol);
  
      // get volume of cube
      vol = mycube.volume();
      System.out.println("Volume of mycube is " + vol);
    }
  }
```

#### **[16.java](16.java)**
```java
// Objects may be passed to methods.
class Test {
    int a, b;

    Test(int i, int j) {
        a = i;
        b = j;
    }

    // return true if o is equal to the invoking object
    boolean equalTo(Test o) {
        if (o.a == a && o.b == b)
            return true;
        else
            return false;
    }
}

class PassOb {
    public static void main(String args[]) {
        Test ob1 = new Test(100, 22);
        Test ob2 = new Test(100, 22);
        Test ob3 = new Test(-1, -1);

        System.out.println("ob1 == ob2: " + ob1.equalTo(ob2));

        System.out.println("ob1 == ob3: " + ob1.equalTo(ob3));
    }
}
```

#### **[17.java](17.java)**
```java
// Simple Types are passed by value.
class Test {
    void meth(int i, int j) {
        i *= 2;
        j /= 2;
    }
}

class CallByValue {
    public static void main(String args[]) {
        Test ob = new Test();
        int a = 15, b = 20;

        System.out.println("a and b before call: " + a + " " + b);

        ob.meth(a, b);

        System.out.println("a and b after call: " + a + " " + b);
    }
}
```

#### **[18.java](18.java)**
```java
// Objects are passed through their references.

class Test {
    int a, b;

    Test(int i, int j) {
        a = i;
        b = j;
    }

    // pass an object
    void meth(Test o) {
        o.a *= 2;
        o.b /= 2;
    }
}

class PassObjRef {
    public static void main(String args[]) {
        Test ob = new Test(15, 20);

        System.out.println("ob.a and ob.b before call: " + ob.a + " " + ob.b);

        ob.meth(ob);

        System.out.println("ob.a and ob.b after call: " + ob.a + " " + ob.b);
    }
}
```

> We encourage you to run the shared code and feel free to experiment with it. In case of any doubt just ping any of the co-ordinators we are always here to help :)

{% include disqus.html %}