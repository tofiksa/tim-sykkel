package oslokommune.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import oslokommune.keys.StationKeys;

import java.io.Serializable;
import java.util.List;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class StationAvailability implements Serializable{

    private static final long serialVersionUID = -7254576141070048691L;

    @JsonProperty(StationKeys.ID)
    private int id;

    @JsonProperty(StationKeys.UPDATED_AT)
    private String updated_at;

    @JsonProperty(StationKeys.REFRESH_RATE)
    private double refresh_rate;

    @JsonProperty(StationKeys.AVAILABILITY)
    private List<Bike> bike;


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

    public List<Bike> getBike() {
        return bike;
    }

    public void setBike(List<Bike> bike) {
        this.bike = bike;
    }

    @Override
    public String toString() {
        return "StationAvailability{" +
                "id=" + id +
                ", updated_at='" + updated_at + '\'' +
                ", refresh_rate=" + refresh_rate +
                ", bike=" + bike +
                '}';
    }
}
