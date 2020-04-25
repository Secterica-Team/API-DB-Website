package ua.lviv.iot.secterica.heysmell.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.secterica.heysmell.model.AirQuality;

import java.time.LocalDate;
import java.util.List;


@Repository

public interface AirQualityRepository extends MongoRepository<AirQuality, String> {
    List<AirQuality> findAllByLocationId(Integer locationId);
    List<AirQuality> findAllByLocationIdAndDate(Integer locationId, LocalDate date);
}
