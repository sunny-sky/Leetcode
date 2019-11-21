package thinkInJAVA;

public class Page84 {
    public static void main(String[] args) {
        Leaf x = new Leaf();
        x.increment().increment().print();
    }
}

class Leaf {
    int i = 0;
    Leaf increment() {
        i++;
        return this;
    }
    void print() {
        System.out.println("i = " + i);
    }
}