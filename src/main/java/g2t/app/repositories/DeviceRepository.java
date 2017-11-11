package g2t.app.repositories;

import g2t.app.domain.Device;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeviceRepository extends CrudRepository<Device, Long> {
    List<Device> findByActive(boolean active);
}
