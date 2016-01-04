package kevin.demo;
 
public class Demo {
    public static void main(String[] args) {
       new Derived().display();
    }
}

class bash {
    int a;
    static int b;
    static int c = 1;
 
    static {
       b=2;
       c = 3;
       System.out.println("Base:static init block invoked..");
    }
 
    void display() {
       System.out.println("Base:a=" + a + ",b=" + b + ",c=" + c);
    }
 
}
 
class Derived extends bash {
    int d;
    static int e = 4;
 
    static {
       e= 5;
       System.out.println("Derived:static init block invoked...");
    }
 
    void display() {
       super.display();
       System.out.println("Derived:d=" + d + ",e=" + e);
    }
}

