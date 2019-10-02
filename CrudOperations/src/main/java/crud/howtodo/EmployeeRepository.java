package crud.howtodo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
interface EmployeeRepository
        extends JpaRepository<EmployeeEntity,Integer> {
}
