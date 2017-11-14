package g2t.app.repositories;

import g2t.app.domain.Device;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeviceRepository extends CrudRepository<Device, Long> {
    List<Device> findByActive(boolean active);

    @Query(nativeQuery = true,
            value = "SELECT * FROM dispositivo d WHERE d.imei NOT IN (SELECT a.imei FROM asignacion a WHERE a.activo = TRUE) AND d.activo = TRUE")
    List<Device> findAvailable();
}
