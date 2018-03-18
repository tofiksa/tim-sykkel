package oslokommune.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import oslokommune.keys.StationKeys;

import java.io.Serializable;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bounds implements Serializable {


    private static final long serialVersionUID = -3571013560761079882L;

    @JsonProperty(StationKeys.LONGITUDE)
    private double longtidude;

    @JsonProperty(StationKeys.LATITUDE)
    private double latitude;

    public double getLongtidude() {
        return longtidude;
    }

    public void setLongtidude(double longtidude) {
        this.longtidude = longtidude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Bounds{" +
                "longtidude=" + longtidude +
                ", latitude=" + latitude +
                '}';
    }
}
