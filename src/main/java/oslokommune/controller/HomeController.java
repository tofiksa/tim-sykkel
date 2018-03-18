package oslokommune.controller;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import oslokommune.beans.Center;
import oslokommune.beans.Station;
import oslokommune.beans.StationAvailability;
import oslokommune.util.UnirestClient;

import java.util.List;

@Controller
public class HomeController {

    private UnirestClient unirestClient = new UnirestClient();

    @Value("${client.secret}")
    private String clientsecret;

    @Value("${google.api.key}")
    private String googleapikey;

    @Autowired
    private Station station;

    @Autowired
    private StationAvailability stationAvailability;



    @GetMapping("/Alle-stasjoner")
    public String AlleStasjoner(Model model) {

        List<Station> stations = getStations();
        model.addAttribute("allstations",stations);

        return "Alle-stasjoner";
    }

    public List<Station> getStations() {

        List<Station> allStations = null;
        List<Station> filtered = Lists.newArrayList();

        try {
            allStations = unirestClient.getAllStations("/stations",clientsecret).getStations();


            for(Station p : allStations) {

                filtered.add(p);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return filtered;
    }

    public List<StationAvailability> getStationAvailability() {

        List<StationAvailability> allBikes = null;
        List<StationAvailability> filt = Lists.newArrayList();

        try {
            allBikes = unirestClient.getAllAvailabilities("/stations/availability",clientsecret).getStationAvailability();


            for(StationAvailability p : allBikes) {
                filt.add(p);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return filt;
    }

    @GetMapping("/Ledige-sykler")
    public String LedigeSykler (@RequestParam(name="id", required=false, defaultValue="185") int id, Model model) {

        List<StationAvailability> allAvailabilities = getStationAvailability();
        List<Station> stations = getStations();
        List<Center> centers;
        String BASE_GOOGLE_API_URL = "https://maps.googleapis.com/maps/api/js?key="+googleapikey+"&callback=initMap&language=no&region=NO";

        for(StationAvailability sa : allAvailabilities) {
                if (id == sa.getId()) {
                    model.addAttribute("allAvailabilities", sa);

                    for (Station s : stations) {
                        if (id == s.getId()) {
                            model.addAttribute("stations", s);

                            model.addAttribute("lat", s.getCenter().getLatitude());
                            model.addAttribute("lng", s.getCenter().getLongtitude());
                        }
                    }

                }
        }
        model.addAttribute("apikey",BASE_GOOGLE_API_URL);


        return "Ledige-sykler";
    }

}