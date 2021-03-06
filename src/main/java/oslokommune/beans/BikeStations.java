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

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }


    @Override
    public String toString() {
        return "BikeStations{" +
                "stations=" + stations +
                '}';
    }
}
