public class test {
    public static void main(String[] args) {

        for (int i=1;i<=31847;i++){
            int pow = 1;
            for(int j=0;j<i;j++){
                pow = pow*7;
                if(pow>31847){
                    pow = pow%31847;
                }

            }
            if(pow == 18074){
                System.out.println("result:i==>"+i);
            }
        }


    }
}
