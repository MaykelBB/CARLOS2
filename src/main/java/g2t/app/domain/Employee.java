package g2t.app.domain;

import g2t.app.domain.enums.Genre;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "trabajador")
public class Employee {
    @Id
    private Long rut;
    @NotNull
    @Column(name = "nombres")
    private String names;
    @NotNull
    @Column(name = "apellido_paterno")
    private String pSurName;
    @Column(name = "apellido_materno")
    private String mSurName;
    @NotNull
    @Column(name = "fecha_nacimiento")
    private Date birthDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "genero")
    private Genre genre;
    @Column(name = "rol")
    private String role;
    @NotNull
    @Column(name = "activo")
    private boolean active = true;
    @Version
    private Long version;
    @ManyToOne
    @JoinColumn(name = "seccion_id")
    private Section section;
    @OneToMany(mappedBy = "employee")
    private List<Assignment> assignments;
    @OneToMany(mappedBy = "employee")
    private List<Route> routes;

    @SuppressWarnings("unused") public Employee() { }

    @SuppressWarnings("unused")
    public Employee(Long rut, String names, String pSurName, String mSurName, Date birthDate, Genre genre, String role, Section section) {
        this.rut = rut;
        this.names = names;
        this.pSurName = pSurName;
        this.mSurName = mSurName;
        this.birthDate = birthDate;
        this.genre = genre;
        this.role = role;
        this.section = section;
    }

    @SuppressWarnings("unused")
    public Employee(Long rut, String names, String pSurName, String mSurName, Date birthDate, Genre genre, String role, boolean active, Section section) {
        this.rut = rut;
        this.names = names;
        this.pSurName = pSurName;
        this.mSurName = mSurName;
        this.birthDate = birthDate;
        this.genre = genre;
        this.role = role;
        this.active = active;
        this.section = section;
    }

    @SuppressWarnings("unused") public Long getRut() { return rut; }

    @SuppressWarnings("unused") public void setRut(Long rut) { this.rut = rut; }

    @SuppressWarnings("unused") public String getNames() { return names; }

    @SuppressWarnings("unused") public void setNames(String names) { this.names = names; }

    @SuppressWarnings("unused") public String getpSurName() { return pSurName; }

    @SuppressWarnings("unused") public void setpSurName(String pSurName) { this.pSurName = pSurName; }

    @SuppressWarnings("unused") public String getmSurName() { return mSurName; }

    @SuppressWarnings("unused") public void setmSurName(String mSurName) { this.mSurName = mSurName; }

    @SuppressWarnings("unused") public Date getBirthDate() { return birthDate; }

    @SuppressWarnings("unused") public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    @SuppressWarnings("unused") public Genre getGenre() { return genre; }

    @SuppressWarnings("unused") public void setGenre(Genre genre) { this.genre = genre; }

    @SuppressWarnings("unused") public String getRole() { return role; }

    @SuppressWarnings("unused") public void setRole(String role) { this.role = role; }

    @SuppressWarnings("unused") public boolean isActive() { return active; }

    @SuppressWarnings("unused") public void setActive(boolean active) { this.active = active; }

    @SuppressWarnings("unused") public Long getVersion() { return version; }

    @SuppressWarnings("unused") public void setVersion(Long version) { this.version = version; }

    @SuppressWarnings("unused") public Section getSection() { return section; }

    @SuppressWarnings("unused") public void setSection(Section section) { this.section = section; }

    @SuppressWarnings("unused") public List<Assignment> getAssignments() { return assignments; }

    @SuppressWarnings("unused") public void setAssignments(List<Assignment> assignments) { this.assignments = assignments; }

    @SuppressWarnings("unused") public List<Route> getRoutes() { return routes; }

    @SuppressWarnings("unused") public void setRoutes(List<Route> routes) { this.routes = routes; }

    @SuppressWarnings("unused")
    public String getRutFormat(){
        long numb = rut / 100;
        int dv = (int)(rut % 100);
        String dvText;
        switch (dv) {
            case 10:
                dvText = "0";
                break;
            case 11:
                dvText = "K";
                break;
            default:
                dvText = Integer.toString(dv);
                break;
        }
        return Long.toString(numb) + "-" + dvText;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "rut=" + rut +
                ", names='" + names + '\'' +
                ", pSurName='" + pSurName + '\'' +
                ", mSurName='" + mSurName + '\'' +
                ", birthDate=" + birthDate +
                ", genre='" + genre + '\'' +
                ", role='" + role + '\'' +
                ", active=" + active +
                ", section=" + section.getName() +
                '}';
    }
}
