package IOExample;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadConsoleInput {
    //1) Read console input using java.io.Console instance
    //bug on idea
    static void usingConsoleReader(){
        Console console;
        String inputString;
        console = System.console();
        if(console!=null){
            inputString = console.readLine("input sth: ");
            System.out.println("input:"+inputString);
        }
    }
    //2) Read console input using BufferedReader instance
    static void usingBufferedReader(){
        System.out.println("Read console input using BufferedReader instance");
        BufferedReader bufferedReader
                = new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
        );
        try {
            String inputString = bufferedReader.readLine();
            System.out.println("Name entered : " + inputString);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //3) Read console input using Scanner instance
    static void usingScanner(){
        System.out.println("Read console input using Scanner instance");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        System.out.println("Name entered : " + inputString);
        //Type unsafe way of reading input.ex:ten
        int age = scanner.nextInt();
        System.out.println("Your age is " + age);


        System.out.print("Enter your age > ");
        //Typesafe way of reading input from console using Scanner
        while (!scanner.hasNextInt()){
            scanner.nextLine(); //clear the invalid input before prompting again
            System.out.print("Please enter your age in natural positive number > ");
        }

         age = scanner.nextInt();
        System.out.println("Your age is " + age);
        scanner.close();

    }

    public static void main(String[] args) {
        ReadConsoleInput.usingConsoleReader();
        ReadConsoleInput.usingBufferedReader();
        ReadConsoleInput.usingScanner();
    }
}
