package genericprogram;

public class TestGeneric {
    public static < T > T getMiddle ( T ... a )
    {
        return a [ a . length / 2 ] ;
    }

    public static void main(String[] args){
        double middle = TestGeneric . getMiddle( 3.14 , 1729.0 , 0.0 ) ;
    }
}
