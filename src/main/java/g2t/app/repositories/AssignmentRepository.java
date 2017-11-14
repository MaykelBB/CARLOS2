package g2t.app.repositories;

import g2t.app.domain.Assignment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssignmentRepository extends CrudRepository<Assignment, Long> {
    List<Assignment> findByActive(boolean active);
}