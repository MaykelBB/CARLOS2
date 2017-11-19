package g2t.app.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dispositivo")
public class Device {
    @Id
    @Range(min=100000000000000L, max=9999999999999999L)
    private long imei;
    @NotEmpty
    @Column(name="marca")
    private String brand;
    @Column(name = "modelo")
    private String model;
    private String serial;
    @Column(name = "activo")
    private boolean active = true;
    @Version
    private Long version;
    @OneToMany(mappedBy = "device")
    private List<Assignment> assignments;

    @SuppressWarnings("unused") public Device(){ }

    @SuppressWarnings("unused")
    public Device(long imei, String brand, String model, String serial, boolean active) {
        this.imei = imei;
        this.brand = brand;
        this.model = model;
        this.serial = serial;
        this.active = active;
    }

    @SuppressWarnings("unused")
    public Device(long imei, String brand, String model, String serial) {
        this.imei = imei;
        this.brand = brand;
        this.model = model;
        this.serial = serial;
        this.active = true;
    }

    @SuppressWarnings("unused") public long getImei() { return imei; }

    @SuppressWarnings("unused") public void setImei(long imei) { this.imei = imei; }

    @SuppressWarnings("unused") public String getBrand() { return brand; }

    @SuppressWarnings("unused") public void setBrand(String brand) { this.brand = brand; }

    @SuppressWarnings("unused") public String getModel() { return model; }

    @SuppressWarnings("unused") public void setModel(String model) { this.model = model; }

    @SuppressWarnings("unused") public String getSerial() { return serial; }

    @SuppressWarnings("unused") public void setSerial(String serial) { this.serial = serial; }

    @SuppressWarnings("unused") public boolean isActive() { return active; }

    @SuppressWarnings("unused") public void setActive(boolean active) { this.active = active; }

    @SuppressWarnings("unused") public Long getVersion() { return version; }

    @SuppressWarnings("unused") public void setVersion(Long version) { this.version = version; }

    @SuppressWarnings("unused") public List<Assignment> getAssignments() { return assignments; }

    @SuppressWarnings("unused") public void setAssignments(List<Assignment> assignments) { this.assignments = assignments; }

    @Override
    public String toString() {
        return "Device{" +
                "imei=" + imei +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", serial='" + serial + '\'' +
                ", active=" + active +
                '}';
    }
}
