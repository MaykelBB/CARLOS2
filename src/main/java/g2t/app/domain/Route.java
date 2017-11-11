package g2t.app.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "ruta")
@SequenceGenerator(name="seq",sequenceName="ruta_seq", allocationSize=1)
public class Route {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private long id;
    @NotNull
    @Column(name = "fecha")
    private Date date;
    @Version
    private Long version;
    @ManyToOne
    @JoinColumn(name = "rut")
    private Employee employee;
    @OneToMany(mappedBy = "route")
    private List<Record> records;

    @SuppressWarnings("unused") private Route() { }

    @SuppressWarnings("unused")
    public Route(Date date, Employee employee) {
        this.date = date;
        this.employee = employee;
    }

    @SuppressWarnings("unused") public long getId() { return id; }

    @SuppressWarnings("unused") public void setId(long id) { this.id = id; }

    @SuppressWarnings("unused") public Date getDate() { return date; }

    @SuppressWarnings("unused") public void setDate(Date date) { this.date = date; }

    @SuppressWarnings("unused") public Long getVersion() { return version; }

    @SuppressWarnings("unused") public void setVersion(Long version) { this.version = version; }

    @SuppressWarnings("unused") public Employee getEmployee() { return employee; }

    @SuppressWarnings("unused") public void setEmployee(Employee employee) { this.employee = employee; }

    @SuppressWarnings("unused") public List<Record> getRecords() { return records; }

    @SuppressWarnings("unused") public void setRecords(List<Record> records) { this.records = records; }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", date=" + date +
                ", employee=" + employee.getRut() +
                '}';
    }
}
