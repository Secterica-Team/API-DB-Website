package ua.lviv.iot.secterica.heysmell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.secterica.heysmell.model.AirQualityDuringDay;
import ua.lviv.iot.secterica.heysmell.model.AirQualityForDays;
import ua.lviv.iot.secterica.heysmell.model.Location;
import ua.lviv.iot.secterica.heysmell.service.AirQualityService;

import java.util.List;

@RequestMapping("/air-quality")
@RestController
@CrossOrigin(value = "*", origins = "*", allowedHeaders = "*", maxAge = 3L)
public class AirQualityController {

    @Autowired
    private AirQualityService airQualityService;

    @GetMapping
    public List<AirQualityForDays> getAirQualitiesFor() {
        // getting info about air quality for some period of time
        return airQualityService.getAllAirQualities();
    }

    @GetMapping("/last_week")
    public List<AirQualityForDays> getForWeek(@RequestParam(name = "location") String id) {
        return airQualityService.getAirQualitiesForWeek(id);
    }

    @GetMapping("/last_month")
    public List<AirQualityForDays> getForMonth(@RequestParam(name = "location") String id) {
        return airQualityService.getAirQualitiesForMonth(id);
    }

    @GetMapping("/last_year")
    public List<AirQualityForDays> getForYear(@RequestParam(name = "location") String id) {
        return airQualityService.getAirQualitiesForYear(id);
    }

    @GetMapping("/last_day")
    public List<AirQualityDuringDay> getForDay(@RequestParam(name = "location") String id){
        return airQualityService.getAirQualitiesForDay(id);
    }

    @GetMapping("/help")
    public String getHelp() {
        return "lol, help yourself by your own!\n Joking, it's just not implemented, sorry";
    }


    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AirQualityDuringDay> addNewAirQuality(@RequestBody AirQualityForDays quality) {
        return airQualityService.addNewAirQualityInfo(quality);
    }

    @GetMapping("/locations")
    public List<Location> getAllLocations() {
        return airQualityService.getAllLocations();
    }

    @PostMapping("/locations")
    public ResponseEntity<Location> addLocation(@RequestBody Location location) {
        return airQualityService.addLocation(location);
    }

    @DeleteMapping
    public void deleteAll() {
        airQualityService.deleteAll();
    }
}
