package oslokommune.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;

import oslokommune.beans.AvailableStations;
import oslokommune.beans.Bike;
import oslokommune.beans.BikeStations;
import oslokommune.beans.StationAvailability;


import java.io.IOException;

public class UnirestClient {

    private static final String BASE_URI = "https://oslobysykkel.no/api/v1";

    public UnirestClient() {
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public BikeStations getAllStations(String endpoint, String clientsecret) throws Exception {
        HttpResponse<BikeStations> response = Unirest.get(BASE_URI+endpoint)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Client-Identifier",clientsecret)
                .asObject(BikeStations.class);
        BikeStations bikeStations = response.getBody();

        return bikeStations;

    }

    public AvailableStations getAllAvailabilities(String endpoint, String clientsecret) throws Exception {
        HttpResponse<AvailableStations> response = Unirest.get(BASE_URI+endpoint)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Client-Identifier",clientsecret)
                .asObject(AvailableStations.class);
        AvailableStations availability = response.getBody();
        return availability;
    }

    public BikeStations getAllBikestations (String endpoint,String clientsecret) throws Exception {

        HttpResponse<BikeStations> response = Unirest.get(BASE_URI+endpoint)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Client-Identifier","67d7bfde8e9ff85c510c4200555bfa36")
                .asObject(BikeStations.class);
        BikeStations bikeStations = response.getBody();
        return bikeStations;

    }



}