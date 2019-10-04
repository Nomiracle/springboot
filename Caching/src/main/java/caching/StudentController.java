package caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/student")
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping(value = "/{id}")
    public Student findStudentById(@PathVariable("id")String id){
        System.out.println("Searching by ID  : " + id);
        return studentService.getStudentById(id);
    }
}
