package g2t.app.repositories;

import g2t.app.domain.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
    List<Employee> findByActive(boolean active);

    @Query(nativeQuery = true,
            value = "SELECT * FROM trabajador t WHERE  t.rut NOT IN (SELECT a.rut FROM asignacion a WHERE a.activo = TRUE) AND t.activo = TRUE")
    List<Employee> findAvailable();
}
