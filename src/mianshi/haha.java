package mianshi;

public class haha {
    public static  void main(String[] args) {
        Object a = new A();
        Object b = new B();
        System.out.print(B.c);
    }

    static class A {
        static {
            System.out.print("A");
        }
    }

    static class B extends A {
        static {
            System.out.print("B");
        }
        public static String c = "C";
    }
}
