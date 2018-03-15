package oslokommune.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import oslokommune.keys.StationKeys;

import java.util.List;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class BikeStations {

    @JsonProperty(StationKeys.STATIONS)
    private List<Station> stations;

    @JsonProperty(StationKeys.AVAILABILITY)
    private Availability availabilities;


    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public Availability getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(Availability availabilities) {
        this.availabilities = availabilities;
    }

    @Override
    public String toString() {
        return "BikeStations{" +
                "stations=" + stations +
                ", availabilities=" + availabilities +
                '}';
    }
}
