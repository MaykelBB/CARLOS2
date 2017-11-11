package g2t.app.domain;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "registro")
@SequenceGenerator(name="seq",sequenceName="registro_seq", allocationSize=1)
public class Record {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private long id;
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
    @Column(name = "altitud")
    private Float altitude;
    @NotNull
    @Column(name = "timestamp")
    private Timestamp timestamp;
    @NotNull
    @Column(name = "velocidad")
    private float speed = -1F;
    @NotNull
    @Column(name = "enMovimiento")
    private boolean isMoving = false;
    @NotNull
    @Column(name = "precision")
    private int accuracy;
    @Column(name = "bateria")
    private Integer battery;
    @Version
    private Long version;
    @ManyToOne
    @JoinColumn(name = "ruta_id")
    private Route route;

    @SuppressWarnings("unused") private Record() { }

    @SuppressWarnings("unused")
    public Record(double latitude, double longitude, Timestamp timestamp, int accuracy, Route route) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
        this.accuracy = accuracy;
        this.route = route;
        this.isMoving = false;
        this.speed = -1F;
    }

    @SuppressWarnings("unused")
    public Record(double latitude, double longitude, Float altitude, Timestamp timestamp, int accuracy, Integer battery, Route route) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.timestamp = timestamp;
        this.accuracy = accuracy;
        this.battery = battery;
        this.route = route;
        this.isMoving = false;
        this.speed = -1F;
    }

    @SuppressWarnings("unused")
    public Record(double latitude, double longitude, Float altitude, Timestamp timestamp, float speed, boolean isMoving, int accuracy, Integer battery, Route route) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.timestamp = timestamp;
        this.speed = speed;
        this.isMoving = isMoving;
        this.accuracy = accuracy;
        this.battery = battery;
        this.route = route;
    }

    @SuppressWarnings("unused") public long getId() { return id; }

    @SuppressWarnings("unused") public void setId(long id) { this.id = id; }

    @SuppressWarnings("unused") public double getLatitude() { return latitude; }

    @SuppressWarnings("unused") public void setLatitude(double latitude) { this.latitude = latitude; }

    @SuppressWarnings("unused") public double getLongitude() { return longitude; }

    @SuppressWarnings("unused") public void setLongitude(double longitude) { this.longitude = longitude; }

    @SuppressWarnings("unused") public Float getAltitude() { return altitude; }

    @SuppressWarnings("unused") public void setAltitude(Float altitude) { this.altitude = altitude; }

    @SuppressWarnings("unused") public Timestamp getTimestamp() { return timestamp; }

    @SuppressWarnings("unused") public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }

    @SuppressWarnings("unused") public float getSpeed() { return speed; }

    @SuppressWarnings("unused") public void setSpeed(float speed) { this.speed = speed; }

    @SuppressWarnings("unused") public boolean isMoving() { return isMoving; }

    @SuppressWarnings("unused") public void setMoving(boolean moving) { isMoving = moving; }

    @SuppressWarnings("unused") public int getAccuracy() { return accuracy; }

    @SuppressWarnings("unused") public void setAccuracy(int accuracy) { this.accuracy = accuracy; }

    @SuppressWarnings("unused") public Integer getBattery() { return battery; }

    @SuppressWarnings("unused") public void setBattery(Integer battery) { this.battery = battery; }

    @SuppressWarnings("unused") public Long getVersion() { return version; }

    @SuppressWarnings("unused") public void setVersion(Long version) { this.version = version; }

    @SuppressWarnings("unused") public Route getRoute() { return route; }

    @SuppressWarnings("unused") public void setRoute(Route route) { this.route = route; }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", timestamp=" + timestamp +
                ", speed=" + speed +
                ", isMoving=" + isMoving +
                ", accuracy=" + accuracy +
                ", battery=" + battery +
                ", route=" + route.getId() +
                '}';
    }
}
