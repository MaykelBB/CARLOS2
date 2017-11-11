package g2t.app.repositories;

import g2t.app.domain.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
    List<Employee> findByActive(boolean active);
}
