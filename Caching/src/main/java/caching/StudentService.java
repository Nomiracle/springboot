package caching;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Cacheable("student")
    public Student getStudentById(String id){
        try{
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        return new Student(id,"Sajal" ,"V");
    }
}
