package ua.lviv.iot.secterica.heysmell.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.lviv.iot.secterica.heysmell.model.AirQualityDuringDay;

import java.util.List;

public interface AirQualityDuringDayRepository extends MongoRepository<AirQualityDuringDay, String> {
    List<AirQualityDuringDay> findAllById(String sensorId);
}
