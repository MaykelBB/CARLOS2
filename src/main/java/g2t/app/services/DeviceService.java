package g2t.app.services;

import g2t.app.domain.Device;
import g2t.app.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeviceService {
    private DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Device getDevice(long imei){ return deviceRepository.findOne(imei); }

    public Device saveDevice(Device device){ return deviceRepository.save(device); }

    public List<Device> getActiveDevices(){
        return deviceRepository.findByActive(true);
    }
}
