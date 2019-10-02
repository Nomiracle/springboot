package crud.howtodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

     List<EmployeeEntity> getAllEmployees(){
        List<EmployeeEntity>employeeEntityList
                = employeeRepository.findAll();
        if(employeeEntityList.size()>0)
            return employeeEntityList;
        else
            return new ArrayList<>();
    }
     EmployeeEntity getEmployeeById(int id)throws Exception{
        Optional<EmployeeEntity>employeeEntity
                =employeeRepository.findById(id);
        if(employeeEntity.isPresent())return employeeEntity.get();
        else throw new Exception("No employee record exist for given id");
    }
     EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity){
        Optional<EmployeeEntity>employeeEntity
                =employeeRepository.findById(entity.getId());
        if(employeeEntity.isPresent()){
            EmployeeEntity newEmployee = employeeEntity.get();
            newEmployee.setName(employeeEntity.get().getName());
            newEmployee.setEmail(employeeEntity.get().getEmail());
            return newEmployee;
        }
        else{
            entity = employeeRepository.save(entity);
            return entity;
        }
    }
     void deleteEmployeeById(int id)throws Exception{
        Optional<EmployeeEntity>employeeEntity
                =employeeRepository.findById(id);
        if(employeeEntity.isPresent())
            employeeRepository.deleteById(id);
        else
            throw new Exception("No employee record exist for given id");
    }

}
