package thinkInJAVA;

class Test1 {
    Test1() {
//        this.name = "HL";
        name = "HL";
    }
    int age;
    String sex = "男";
    String name;
}

public class Page77 {
    public static void main(String[] args) {
        Test1 temp = new Test1();
        System.out.println(temp.sex);
        System.out.println(temp.name);
        System.out.println(temp.toString());

    }
}
