package oslokommune.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import oslokommune.keys.StationKeys;

import java.io.Serializable;


@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class StationStatus implements Serializable {

    @JsonProperty(StationKeys.STATUS)
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StationStatus{" +
                "status=" + status +
                '}';
    }
}
