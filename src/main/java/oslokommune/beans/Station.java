package oslokommune.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import oslokommune.keys.StationKeys;

import java.io.Serializable;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Station implements Serializable {

    private static final long serialVersionUID = 6758484675955383078L;

    @JsonProperty(StationKeys.ID)
    private int id;

    @JsonProperty(StationKeys.IN_SERVICE)
    private boolean in_service;

    @JsonProperty(StationKeys.TITLE)
    private String title;

    @JsonProperty(StationKeys.SUBTITLE)
    private String subtitle;

    @JsonProperty(StationKeys.NUMBER_OF_LOCKS)
    private int number_of_locks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIn_service() {
        return in_service;
    }

    public void setIn_service(boolean in_service) {
        this.in_service = in_service;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getIn_service() {
        return in_service;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getNumber_of_locks() {
        return number_of_locks;
    }

    public void setNumber_of_locks(int number_of_locks) {
        this.number_of_locks = number_of_locks;
    }



    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", in_service=" + in_service +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", number_of_locks=" + number_of_locks +
                '}';
    }
}
