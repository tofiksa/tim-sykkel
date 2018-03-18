package oslokommune.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import oslokommune.keys.StationKeys;

import java.util.List;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class AvailableStations {

    @JsonProperty(StationKeys.STATIONS)
    private List<StationAvailability> StationAvailability;

    public List<StationAvailability> getStationAvailability() {
        return StationAvailability;
    }

    public void setStationAvailability(List<StationAvailability> stationAvailability) {
        StationAvailability = stationAvailability;
    }

    @Override
    public String toString() {
        return "AvailableStations{" +
                "StationAvailability=" + StationAvailability +
                '}';
    }
}
