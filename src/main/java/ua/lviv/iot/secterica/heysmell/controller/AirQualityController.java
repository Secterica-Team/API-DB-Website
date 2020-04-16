package ua.lviv.iot.secterica.heysmell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class AirQualityController {
    @Autowired
    private AirQualityService airQualityService;

    @GetMapping("/")
    public List<AirQuality> getAirQualitiesFor(@RequestParam(name = "day", required = false, defaultValue = "0") Integer days, @RequestParam(name = "month", required = false, defaultValue = "0") Integer months) {
        // getting info about air quality for some period of time
        // return airQualityService.getAirQualitiesFor(Integer.parseInt(String.valueOf(id)), Integer.parseInt(String.valueOf(first)));

        return null;
    }
    @GetMapping("/help")
    public String getHelp() {
        return "lol, help yourself by your own!\n Joking, it's just not implemented, sorry";
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirQuality> getAirQuality(@PathVariable(name = "id") Integer id) {
        // getting info about certain air quality
        // not implemented yet
        return ResponseEntity.status(HttpStatus.OK).body(airQualityService.getAirQuality(id));
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addNewAirQualityInfo(@RequestBody AirQuality quality) {
        return airQualityService.addNewAirQualityInfo(quality);
    }

    @GetMapping("/locations")
    public List<Location> getAllLocations() {
        return airQualityService.getAllLocations();
    }

    @DeleteMapping
    public void deleteAll() {
        airQualityService.deleteAll();
    }
}
