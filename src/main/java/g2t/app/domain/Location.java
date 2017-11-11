package g2t.app.domain;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "locacion")
@SequenceGenerator(name="seq",sequenceName="locacion_seq", allocationSize=1)
public class Location {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "registro")
    private Date regDate;
    @NotNull
    @DecimalMin("-90.0")
    @DecimalMax("90.0")
    @Column(name = "latitud")
    private double latitude;
    @NotNull
    @DecimalMin("-180.0")
    @DecimalMax("180.0")
    @Column(name = "longitud")
    private double longitude;
    @NotNull
    @Column(name = "activo")
    private boolean active = true;
    @Version
    private Long version;

    @SuppressWarnings("unused") private Location() { }

    @SuppressWarnings("unused")
    public Location(String name, Date regDate, double latitude, double longitude) {
        this.name = name;
        this.regDate = regDate;
        this.latitude = latitude;
        this.longitude = longitude;
        this.active = true;
    }

    @SuppressWarnings("unused")
    public Location(String name, Date regDate, double latitude, double longitude, boolean active) {
        this.name = name;
        this.regDate = regDate;
        this.latitude = latitude;
        this.longitude = longitude;
        this.active = active;
    }

    @SuppressWarnings("unused") public long getId() { return id; }

    @SuppressWarnings("unused") public void setId(long id) { this.id = id; }

    @SuppressWarnings("unused") public String getName() { return name; }

    @SuppressWarnings("unused") public void setName(String name) { this.name = name; }

    @SuppressWarnings("unused") public Date getRegDate() { return regDate; }

    @SuppressWarnings("unused") public void setRegDate(Date regDate) { this.regDate = regDate; }

    @SuppressWarnings("unused") public double getLatitude() { return latitude; }

    @SuppressWarnings("unused") public void setLatitude(double latitude) { this.latitude = latitude; }

    @SuppressWarnings("unused") public double getLongitude() { return longitude; }

    @SuppressWarnings("unused") public void setLongitude(double longitude) { this.longitude = longitude; }

    @SuppressWarnings("unused") public boolean isActive() { return active; }

    @SuppressWarnings("unused") public void setActive(boolean active) { this.active = active; }

    @SuppressWarnings("unused") public Long getVersion() { return version; }

    @SuppressWarnings("unused") public void setVersion(Long version) { this.version = version; }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", regDate=" + regDate +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", active=" + active +
                '}';
    }
}
