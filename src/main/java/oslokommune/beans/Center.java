package oslokommune.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import oslokommune.keys.StationKeys;

import java.io.Serializable;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Center implements Serializable {

    @JsonProperty(StationKeys.LATITUDE)
    private double latitude;

    @JsonProperty(StationKeys.LONGITUDE)
    private double longtitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    @Override
    public String toString() {
        return "Center{" +
                "latitude=" + latitude +
                ", longtitude=" + longtitude +
                '}';
    }
}
