package JavaConcurrency.CallableFutureExample;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialCalculator
        implements Callable<Integer> {
    private int number;
    private static int index = 0;
    public FactorialCalculator(Integer number) {
        this.number = number;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        int result = 1;
        if ((number == 0) || (number == 1)) {
            result = 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(20);
            }
        }
        System.out.println((index++) +",Result for number : " + number
                + "->" + result);
        return result;
    }
}
