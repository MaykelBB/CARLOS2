package g2t.app.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "seccion")
@SequenceGenerator(name="seq",sequenceName="seccion_seq", allocationSize=1)
public class Section {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private long id;
    @NotNull
    @Column(name = "nombre")
    private String name;
    @NotNull
    @Column(name = "activo")
    private boolean active = true;
    @Version
    private Long version;
    @OneToMany(mappedBy = "section")
    private List<Employee> employees;

    @SuppressWarnings("unused")
    public Section() { }

    @SuppressWarnings("unused")
    public Section(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public Section(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    @SuppressWarnings("unused") public long getId() { return id; }

    @SuppressWarnings("unused") public void setId(long id) { this.id = id; }

    @SuppressWarnings("unused") public String getName() { return name; }

    @SuppressWarnings("unused") public void setName(String name) { this.name = name; }

    @SuppressWarnings("unused") public boolean isActive() { return active; }

    @SuppressWarnings("unused") public void setActive(boolean active) { this.active = active; }

    @SuppressWarnings("unused") public Long getVersion() { return version; }

    @SuppressWarnings("unused") public void setVersion(Long version) { this.version = version; }

    @SuppressWarnings("unused") public List<Employee> getEmployees() { return employees; }

    @SuppressWarnings("unused") public void setEmployees(List<Employee> employees) { this.employees = employees; }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                '}';
    }
}
