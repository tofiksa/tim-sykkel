package oslokommune.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import oslokommune.keys.StationKeys;

import java.io.Serializable;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bike implements Serializable {

    private static final long serialVersionUID = -2867920893130533553L;

    @JsonProperty(StationKeys.BIKES)
    private int bikes;

    @JsonProperty(StationKeys.LOCKS)
    private int locks;

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

    @Override
    public String toString() {
        return "Bike{" +
                "bikes=" + bikes +
                ", locks=" + locks +
                '}';
    }
}
