package g2t.app.repositories;

import g2t.app.domain.Section;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SectionRepository extends CrudRepository<Section, Long> {
    List<Section> findByActive(boolean active);
}
