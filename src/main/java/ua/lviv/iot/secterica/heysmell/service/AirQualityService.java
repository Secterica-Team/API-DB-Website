package ua.lviv.iot.secterica.heysmell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.secterica.heysmell.model.AirQuality;
import ua.lviv.iot.secterica.heysmell.model.Location;
import ua.lviv.iot.secterica.heysmell.repository.AirQualityRepository;
import ua.lviv.iot.secterica.heysmell.repository.LocationRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirQualityService {

    @Autowired
    private AirQualityRepository airQualityRepository;
    @Autowired
    private LocationRepository locationRepository;

    public List<AirQuality> getAllAirQualities(){
        //getting info from database
        return  airQualityRepository.findAll();
    }



//    public AirQuality getAirQuality(int id){
////        getting info from database
//        Optional<AirQuality> called = airQualityRepository.findById(String.valueOf(id));
//        AirQuality quality = new AirQuality();
//        quality.setDate(LocalDate.now());
//        return called.orElse(quality);
//    }

    public List<Location> getAllLocations(){
        return locationRepository.findAll();
    }

    public ResponseEntity<AirQuality> addNewAirQualityInfo(AirQuality quality) {
        airQualityRepository.save(quality);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

//    public void deleteAll() {
////        airQualityRepository.deleteAll();
//        List<AirQuality> qualities = airQualityRepository.findAll();
//        for (AirQuality quality:qualities) {
//            airQualityRepository.delete(quality);
//        }
//    }

    private List<AirQuality> getAirQualitiesForSpecificTime(Integer location_id, LocalDate localDate) {
        return airQualityRepository
                .findAllByLocationId(location_id)
                .stream()
                .filter(info -> info.getDate().isAfter(localDate))
                .collect(Collectors.toList());
    }

    public List<AirQuality> getForWeek(Integer id) {
        List<AirQuality> l = getAirQualitiesForSpecificTime(id, LocalDate.now().minusWeeks(1));
        System.out.println("lol");
        System.out.println(LocalDate.now().minusWeeks(1));
        for(AirQuality a:l){
            System.out.println(a);
        }
        return l;
    }

    public List<AirQuality> getForMonth(Integer id) {
        return getAirQualitiesForSpecificTime(id, LocalDate.now().minusMonths(1));
    }

    public List<AirQuality> getForYear(Integer id) {
        return getAirQualitiesForSpecificTime(id, LocalDate.now().minusYears(1));
    }

    public List<AirQuality> getAirQualitiesForDay(Integer id) {
        return airQualityRepository
                .findAllByLocationId(id)
                .stream()
                .filter(info -> {
                    if (info.getTime()==null) return false;
                    return info.getDate().equals(LocalDate.now()) ||
                            (info.getDate().equals(LocalDate.now().minusDays(1)) &&
                                    info.getTime().isAfter(LocalTime.now()));
                })
                .collect(Collectors.toList());
    }

    public ResponseEntity<Location> addLocation(Location location) {
        return ResponseEntity.status(HttpStatus.OK).body(locationRepository.save(location));
    }
}
