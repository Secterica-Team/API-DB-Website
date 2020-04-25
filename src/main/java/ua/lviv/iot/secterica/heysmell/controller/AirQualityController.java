package ua.lviv.iot.secterica.heysmell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.secterica.heysmell.model.AirQuality;
import ua.lviv.iot.secterica.heysmell.model.Location;
import ua.lviv.iot.secterica.heysmell.service.AirQualityService;

import java.util.List;

@RequestMapping("/air-quality")
@RestController
//@RequiredArgsConstructor
@CrossOrigin("*")
public class AirQualityController {
    @Autowired
    private AirQualityService airQualityService;

    @GetMapping("/")
    public List<AirQuality> getAirQualitiesFor() {
        // getting info about air quality for some period of time
        // return airQualityService.getAirQualitiesFor(Integer.parseInt(String.valueOf(id)), Integer.parseInt(String.valueOf(first)));

        return airQualityService.getAllAirQualities();
    }

    @GetMapping("/last_week")
    public List<AirQuality> getForWeek(@RequestParam(name = "location") Integer id) {
        return airQualityService.getForWeek(id);
    }

    @GetMapping("/last_month")
    public List<AirQuality> getForMonth(@RequestParam(name = "location") Integer id) {
        return airQualityService.getForMonth(id);
    }

    @GetMapping("/last_year")
    public List<AirQuality> getForYear(@RequestParam(name = "location") Integer id) {
        return airQualityService.getForYear(id);
    }

    @GetMapping("/last_day")
    public List<AirQuality> getForDay(@RequestParam(name = "location") Integer id){
        return airQualityService.getAirQualitiesForDay(id);
    }

    @GetMapping("/help")
    public String getHelp() {
        return "lol, help yourself by your own!\n Joking, it's just not implemented, sorry";
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<AirQuality> getAirQuality(@PathVariable(name = "id") Integer id) {
//        // getting info about certain air quality
//        // not implemented yet
//        return ResponseEntity.status(HttpStatus.OK).body(airQualityService.getAirQuality(id));
//    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AirQuality> addNewAirQuality(@RequestBody AirQuality quality) {
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

//    @DeleteMapping
//    public void deleteAll() {
//        airQualityService.deleteAll();
//    }
}
