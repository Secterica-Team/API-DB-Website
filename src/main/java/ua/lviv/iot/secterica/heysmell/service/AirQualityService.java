package ua.lviv.iot.secterica.heysmell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.secterica.heysmell.model.AirQuality;
import ua.lviv.iot.secterica.heysmell.model.Location;
import ua.lviv.iot.secterica.heysmell.repository.AirQualityRepository;
import ua.lviv.iot.secterica.heysmell.repository.LocationRepository;

import java.util.List;

@Service
public class AirQualityService {

    @Autowired
    private AirQualityRepository airQualityRepository;
    @Autowired
    private LocationRepository locationRepository;

    public List<AirQuality> getAirQualitiesFor(int id, int first){
        //getting info from database
        //not implemented yet
        System.out.println(id);
        return  airQualityRepository.findAll();
    }



    public AirQuality getAirQuality(int id){
//        getting info from database
//        not implemented yet
        if (airQualityRepository.findById(id).isPresent()){
            return airQualityRepository.findById(id).get();
        }
        return null;
    }

    public List<Location> getAllLocations(){
        return locationRepository.findAll();
    }

    public ResponseEntity addNewAirQualityInfo(AirQuality quality) {
        airQualityRepository.save(quality);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public void deleteAll() {
//        airQualityRepository.deleteAll();
        List<AirQuality> qualities = getAirQualitiesFor(1,1);
        for (AirQuality quality:qualities) {
            airQualityRepository.delete(quality);
        }
    }
}
