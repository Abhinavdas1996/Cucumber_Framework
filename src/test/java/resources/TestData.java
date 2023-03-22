package resources;

import org.example.AddPlaceAPI;
import org.example.Location;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public AddPlaceAPI requestPayload(String uname, Double lat, String userPhNo, String language, int placeAccuracy) {

        AddPlaceAPI ap = new AddPlaceAPI();
        ap.setAccuracy(placeAccuracy);
        ap.setAddress("29, side layout, cohen 09");
        ap.setName(uname);
        ap.setPhone_number(userPhNo);

        Location l = new Location();
        l.setLat(lat);
        l.setLng(33.427362);
        ap.setLocation(l);

        List<String> a = new ArrayList<>();
        a.add("Rose");
        a.add("Apple");
        ap.setTypes(a);

        ap.setWebsite("https://rahulshettyacademy.com");
        ap.setLanguage(language);


        return ap;
    }


    public String deletePlaceAPI(String updatePlace_id){

        return "{\n" +
                "    \"place_id\": \""+updatePlace_id+"\"\n" +
                "}";
    }
}
