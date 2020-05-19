package ua.lviv.iot.secterica.heysmell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.secterica.heysmell.model.AirQualityDuringDay;
import ua.lviv.iot.secterica.heysmell.model.AirQualityForDays;
import ua.lviv.iot.secterica.heysmell.model.Location;
import ua.lviv.iot.secterica.heysmell.repository.AirQualityDuringDayRepository;
import ua.lviv.iot.secterica.heysmell.repository.AirQualityForDaysRepository;
import ua.lviv.iot.secterica.heysmell.repository.LocationRepository;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirQualityService {

    @Autowired
    private AirQualityForDaysRepository airQualityForDaysRepository;
    @Autowired
    private AirQualityDuringDayRepository airQualityDuringDayRepository;
    @Autowired
    private LocationRepository locationRepository;

    public List<AirQualityForDays> getAllAirQualities() {
        //getting info from database
        return airQualityForDaysRepository.findAll();
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

    public ResponseEntity<AirQualityDuringDay> addNewAirQualityInfo(AirQualityForDays quality) {
        airQualityForDaysRepository.save(quality);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public void deleteAll() {
//        airQualityRepository.deleteAll();
        List<AirQualityForDays> qualities = airQualityForDaysRepository.findAll();
        for (AirQualityForDays quality:qualities) {
            airQualityForDaysRepository.delete(quality);
        }
    }

    private List<AirQualityForDays> getAirQualitiesForSpecificTime(String locationId, LocalDateTime localDate) {
        List<AirQualityForDays> listOfSuitableAirQualities = new ArrayList<>();
        try{
            listOfSuitableAirQualities = airQualityForDaysRepository
                    .findAllById(locationId)
                    .stream()
                    .filter(info -> info.getDate().isAfter(ChronoLocalDate.from(localDate)))
                    .collect(Collectors.toList());
        }catch (Exception e){
            e.printStackTrace();
        }
        return checkIfListWithDataIsEmptyAndReturnAnyOtherNotEmptyList(localDate, listOfSuitableAirQualities);
    }

    private List<AirQualityForDays> checkIfListWithDataIsEmptyAndReturnAnyOtherNotEmptyList(LocalDateTime localDate, List<AirQualityForDays> listOfSuitableAirQualities) {
        if (listOfSuitableAirQualities.isEmpty()){
            for (Location location: getAllLocations()){
                List<AirQualityForDays> list = getAirQualitiesForSpecificTime(location.getId(), localDate);
                if (!list.isEmpty()){
                    return list;
                }
            }
            return new ArrayList<>();
        }else return listOfSuitableAirQualities;
    }

    public List<AirQualityDuringDay> getAirQualitiesForDay(String id) {
        List<AirQualityDuringDay> listOfAirQualities = airQualityDuringDayRepository.findAllById(id);
        if (listOfAirQualities.isEmpty()){
            for (Location location: getAllLocations()){
                List<AirQualityDuringDay> list = getAirQualitiesForDay(location.getId());
                if (!list.isEmpty()){
                    return list;
                }
            }
            return new ArrayList<>();

        } else return listOfAirQualities;
    }

    public List<AirQualityForDays> getAirQualitiesForWeek(String id) {
        return getAirQualitiesForSpecificTime(id, LocalDateTime.now().minusWeeks(1));
    }

    public List<AirQualityForDays> getAirQualitiesForMonth(String id) {
        return getAirQualitiesForSpecificTime(id, LocalDateTime.now().minusMonths(1));
    }

    public List<AirQualityForDays> getAirQualitiesForYear(String id) {
        return getAirQualitiesForSpecificTime(id, LocalDateTime.now().minusYears(1));
    }

    public ResponseEntity<Location> addLocation(Location location) {
        return ResponseEntity.status(HttpStatus.OK).body(locationRepository.save(location));
    }
}
