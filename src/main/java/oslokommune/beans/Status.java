package oslokommune.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import oslokommune.keys.StationKeys;

import java.io.Serializable;
import java.lang.reflect.Array;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Status implements Serializable {

    private static final long serialVersionUID = 260029942637004220L;

    @JsonProperty(StationKeys.ALL_STATIONS_CLOSED)
    private boolean all_stations_closed;

    @JsonProperty(StationKeys.STATIONS_CLOSED)
    private Array stations_closed;

    public boolean isAll_stations_closed() {
        return all_stations_closed;
    }

    public void setAll_stations_closed(boolean all_stations_closed) {
        this.all_stations_closed = all_stations_closed;
    }

    public Array getStations_closed() {
        return stations_closed;
    }

    public void setStations_closed(Array stations_closed) {
        this.stations_closed = stations_closed;
    }

    @Override
    public String toString() {
        return "StationStatus{" +
                "all_stations_closed=" + all_stations_closed +
                ", stations_closed=" + stations_closed +
                '}';
    }


}
