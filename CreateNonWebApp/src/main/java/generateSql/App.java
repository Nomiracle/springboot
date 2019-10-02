package generateSql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {
    private GenerateSql generateSql;
    @Autowired
    App(GenerateSql generateSql){this.generateSql = generateSql;}
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
    @Override
    public void run(String... args) throws Exception {
        generateSql.generate();
    }
}
