package ua.lviv.iot.secterica.heysmell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.secterica.heysmell.model.AirQuality;
import ua.lviv.iot.secterica.heysmell.model.Location;
import ua.lviv.iot.secterica.heysmell.repository.AirQualityRepository;
import ua.lviv.iot.secterica.heysmell.repository.LocationRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirQualityService {

    @Autowired
    private AirQualityRepository airQualityRepository;
    @Autowired
    private AirQualityRepository airQualityByNameRepository;
    @Autowired
    private LocationRepository locationRepository;

    public List<AirQuality> getAllAirQualities() {
        //getting info from database
        return airQualityRepository.findAll();
    }


//    public AirQuality getAirQuality(int id){
////        getting info from database
//        Optional<AirQuality> called = airQualityRepository.findById(String.valueOf(id));
//        AirQuality quality = new AirQuality();
//        quality.setDate(LocalDate.now());
//        return called.orElse(quality);
//    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public ResponseEntity<AirQuality> addNewAirQualityInfo(AirQuality quality) {
        airQualityRepository.save(quality);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public void deleteAll() {
//        airQualityRepository.deleteAll();
        List<AirQuality> qualities = airQualityRepository.findAll();
        for (AirQuality quality:qualities) {
            airQualityRepository.delete(quality);
        }
    }

    private List<AirQuality> getAirQualitiesForSpecificTime(String locationId, LocalDateTime localDate) {
        List<AirQuality> listOfSuitableAirQualities = new ArrayList<>();
        try{
            listOfSuitableAirQualities = airQualityRepository
                    .findAllById(locationId)
                    .stream()
                    .filter(info -> info.getDateTime().isAfter(localDate))
                    .collect(Collectors.toList());
        }catch (Exception e){
            e.printStackTrace();
        }
        return listOfSuitableAirQualities;
    }

    public List<AirQuality> getAirQualitiesForDay(String id) {
        return airQualityByNameRepository
                .findAll()
                .stream()
                .filter(info -> info.getId().equals(id))
                .collect(Collectors.toList());
    }

    public List<AirQuality> getAirQualitiesForWeek(String id) {
        return getAirQualitiesForSpecificTime(id, LocalDateTime.now().minusWeeks(1));
    }

    public List<AirQuality> getAirQualitiesForMonth(String id) {
        return getAirQualitiesForSpecificTime(id, LocalDateTime.now().minusMonths(1));
    }

    public List<AirQuality> getAirQualitiesForYear(String id) {
        return getAirQualitiesForSpecificTime(id, LocalDateTime.now().minusYears(1));
    }

    public ResponseEntity<Location> addLocation(Location location) {
        return ResponseEntity.status(HttpStatus.OK).body(locationRepository.save(location));
    }
}
