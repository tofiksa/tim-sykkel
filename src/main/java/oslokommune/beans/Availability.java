package oslokommune.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import oslokommune.keys.StationKeys;

import java.io.Serializable;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Availability implements Serializable{

    private static final long serialVersionUID = -7254576141070048691L;

    @JsonProperty(StationKeys.ID)
    private int id;

    @JsonProperty(StationKeys.BIKES)
    private int bikes;

    @JsonProperty(StationKeys.LOCKS)
    private int locks;

    @JsonProperty(StationKeys.UPDATED_AT)
    private String updated_at;

    @JsonProperty(StationKeys.REFRESH_RATE)
    private double refresh_rate;

    public int getBikes() {
        return bikes;
    }

    public void setBikes(int bikes) {
        this.bikes = bikes;
    }

    public int getLocks() {
        return locks;
    }

    public void setLocks(int locks) {
        this.locks = locks;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public double getRefresh_rate() {
        return refresh_rate;
    }

    public void setRefresh_rate(double refresh_rate) {
        this.refresh_rate = refresh_rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Availability{" +
                "id=" + id +
                ", bikes=" + bikes +
                ", locks=" + locks +
                ", updated_at='" + updated_at + '\'' +
                ", refresh_rate=" + refresh_rate +
                '}';
    }
}
