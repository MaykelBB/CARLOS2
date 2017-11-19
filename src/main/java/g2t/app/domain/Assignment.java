package g2t.app.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "asignacion")
@SequenceGenerator(name="seq",sequenceName="asignacion_seq", allocationSize=1)
public class Assignment {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private long id;
    @NotNull
    @Column(name = "fecha_asignacion")
    private Date assignDate;
    @NotNull
    @Column(name = "activo")
    private boolean active = true;
    @Version
    private Long version;
    @ManyToOne
    @JoinColumn(name = "rut")
    @NotNull
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "imei")
    @NotNull
    private Device device;

    @SuppressWarnings("unused") public Assignment() { }

    @SuppressWarnings("unused")
    public Assignment(Date assignDate, Employee employee, Device device) {
        this.assignDate = assignDate;
        this.employee = employee;
        this.device = device;
        this.active = true;
    }

    @SuppressWarnings("unused")
    public Assignment(Date assignDate, boolean active, Employee employee, Device device) {
        this.assignDate = assignDate;
        this.active = active;
        this.employee = employee;
        this.device = device;
    }

    @SuppressWarnings("unused") public long getId() { return id; }

    @SuppressWarnings("unused") public void setId(long id) { this.id = id; }

    @SuppressWarnings("unused") public Date getAssignDate() { return assignDate; }

    @SuppressWarnings("unused") public void setAssignDate(Date assignDate) { this.assignDate = assignDate; }

    @SuppressWarnings("unused") public boolean isActive() { return active; }

    @SuppressWarnings("unused") public void setActive(boolean active) { this.active = active; }

    @SuppressWarnings("unused") public Long getVersion() { return version; }

    @SuppressWarnings("unused") public void setVersion(Long version) { this.version = version; }

    @SuppressWarnings("unused") public Employee getEmployee() { return employee; }

    @SuppressWarnings("unused") public void setEmployee(Employee employee) { this.employee = employee; }

    @SuppressWarnings("unused") public Device getDevice() { return device; }

    @SuppressWarnings("unused") public void setDevice(Device device) { this.device = device; }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", assignDate=" + assignDate +
                ", active=" + active +
                ", employee=" + employee.getRut() +
                ", device=" + device.getImei() +
                '}';
    }
}
