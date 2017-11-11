package g2t.app.repositories;

import g2t.app.domain.Assignment;
import org.springframework.data.repository.CrudRepository;

public interface AssignmentRepository extends CrudRepository<Assignment, Long> { }