package oslokommune.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import oslokommune.beans.Availability;
import oslokommune.beans.BikeStations;
import oslokommune.beans.Station;
import oslokommune.keys.EndpointKeys;
import oslokommune.util.UnirestClient;

import java.util.List;

@Controller
public class HomeController {

    private UnirestClient unirestClient = new UnirestClient();

    @Value("${client.secret}")
    private String clientsecret;

    @Autowired
    private Station station;

    @Autowired
    private Availability availability;

    @GetMapping("/Alle-stasjoner")
    public String AlleStasjoner(Model model) {

        List<Station> allStations = null;

        try {
            allStations = unirestClient.getAllStations("/stations",clientsecret).getStations();

            model.addAttribute("allstations",allStations);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Alle-stasjoner";
    }

    @GetMapping("/Ledige-sykler")
    public String LedigeSykler (@RequestParam(name="id", required=false, defaultValue="185") int id, Model model) throws Exception {


        try {
            availability = unirestClient.getAllAvailabilities("/stations/availability",clientsecret);
            if (id == availability.getId() && availability.getId() != 0) {
                model.addAttribute("bikes",availability.getBikes());
                model.addAttribute("locks",availability.getLocks());
            }
            model.addAttribute("availability",availability);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Ledige-sykler";
    }

}