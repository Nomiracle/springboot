public class B extends A{
    String name = "B";
    void call(){
        System.out.println(name);
    }
    public static void main(String[] args) {
        A c = new B();
        System.out.println(c.name);

    }
}