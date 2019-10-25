package Ehcache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.cache.annotation.CacheRemove;
import java.util.HashMap;

@Service
public class EmployeeManager {
    static HashMap<Long, Employee> db = new HashMap<>();

    static {
        db.put(1L, new Employee(1L, "Alex", "Gussin"));
        db.put(2L, new Employee(2L, "Brian", "Schultz"));
    }
    @Cacheable(cacheNames = "employeeCache",key = "#id")
    public Employee getEmployeeById(Long id){
        System.out.println("Getting employee from DB");
        return db.get(id);
    }
   @CachePut(cacheNames = "employeeCache",key = "#id")
    public Employee updateEmployeeById(Long id,
                                       String firstName,
                                       String lastName){
        System.out.println("updating employee from DB");
        db.get(id).setFirstName(firstName);
        db.get(id).setLastName(lastName);
        return db.get(id);
    }
    @CacheEvict(cacheNames = "employeeCache",key = "#id")
    public Employee evictEmployeeById(Long id){
        System.out.println("evicting employee from DB");
        Employee evictEmp = db.get(id);
        db.remove(id);
        return evictEmp;
    }
}
