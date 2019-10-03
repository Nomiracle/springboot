package Callable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class HelloWorldCallableController {
    @GetMapping(value="/testCallable")
    public Callable<String>echoHello(){
        return ()->{
            Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
            return "Hello world!";
        };
    }
}
