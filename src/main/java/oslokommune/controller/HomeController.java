package oslokommune.controller;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import oslokommune.beans.Station;
import oslokommune.beans.StationAvailability;
import oslokommune.util.UnirestClient;

import java.util.List;

@Controller
public class HomeController {

    private UnirestClient unirestClient = new UnirestClient();

    @Value("${client.secret}")
    private String clientsecret;

    @Autowired
    private Station station;

    @GetMapping("/Alle-stasjoner")
    public String AlleStasjoner(Model model) {

        List<Station> allStations = null;


        try {
            allStations = unirestClient.getAllStations("/stations",clientsecret).getStations();
            List<Station> filtered = Lists.newArrayList();

            for(Station p : allStations) {

                filtered.add(p);
            }

            model.addAttribute("allstations",filtered);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Alle-stasjoner";
    }

    @GetMapping("/Ledige-sykler")
    public String LedigeSykler (@RequestParam(name="id", required=false, defaultValue="185") int id, Model model) throws Exception {

        List<StationAvailability> allBikes = null;

        try {
            allBikes = unirestClient.getAllStations("/stations/availability",clientsecret).getStationAvailability();

            model.addAttribute("availability",allBikes);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Ledige-sykler";
    }

}