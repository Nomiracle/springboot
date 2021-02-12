package proxyprogram;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class TestProxy {
    public static void main(String[] args) {
        Class<?>[] interfaces = new Class<?>[]{Comparable.class};

        Object[] elements = new Object[1000];
        for(int i=0;i< elements.length;i++){
            Integer va = i+1;
            elements[i]=Proxy.newProxyInstance(null,interfaces,new TraceHandler(va));
        }
        int result = Arrays.binarySearch(elements, 288);
        System.out.println("result:"+elements[result]);
    }
}


class TraceHandler implements InvocationHandler{

    final private Object target;
    TraceHandler(Object  target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("."+method.getName());
        if(args!=null){
            for(Object o:args){
                System.out.print(","+o);
            }
        }

        System.out.println();
        return method.invoke(target,args);
    }
}
