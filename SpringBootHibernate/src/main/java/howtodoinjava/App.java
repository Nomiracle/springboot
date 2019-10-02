package howtodoinjava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class App implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EmployeeRepository repository;
    @Override
    public void run(String... args){
        Optional<EmployeeEntity> emp = repository.findById(2L);

            logger.info("Employee id 2 -> {}", emp.get());
            emp.get().setName("hahahah");

        emp = repository.findById(2L);
        logger.info("Employee id 2 -> {}", emp.get());
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
