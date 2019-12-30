public class A {
    String name = "A";
    void call(){
        System.out.println(name);
    }A(){
        call();
    }
//    static
//    class B extends A{
//        String name = "B";
//        void call(){
//            System.out.println(name);
//        }
//    }

    public static void main(String[] args) {
        A c = new B();
//                A c = new A();
        System.out.println(c.name);

    }
}
