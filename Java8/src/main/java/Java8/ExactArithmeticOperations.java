package Java8;

public class ExactArithmeticOperations {
    public static void main(String[] args) {
        System.out.println(100000*100000);//0x‭2540BE400‬--->0x540BE400‬
        try{
            System.out.println(Math.multiplyExact(100000,100000));
        }catch(ArithmeticException a){

            a.printStackTrace();
        }
        System.out.println( 10 % 2 );
        System.out.println( 11 % 2 );
        System.out.println( -15 % 2 );
        System.out.println( -16 % 2 );

        System.out.println( Math.floorMod(10,2) );
        System.out.println( Math.floorMod(11,2));
        System.out.println( Math.floorMod(-15,2) );
        System.out.println(Math.floorMod(-16,2) );

        System.out.println( Long.MAX_VALUE );
        System.out.println( (int)Long.MAX_VALUE );
        System.out.println( Math.toIntExact(100_000_000) );
        try{
            System.out.println( Math.toIntExact(Long.MAX_VALUE) );
        }catch(ArithmeticException a){

            a.printStackTrace();
        }

    }
}
