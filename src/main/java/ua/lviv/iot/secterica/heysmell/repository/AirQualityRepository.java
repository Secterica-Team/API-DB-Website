package ua.lviv.iot.secterica.heysmell.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.secterica.heysmell.model.AirQuality;


@Repository

public interface AirQualityRepository extends MongoRepository<AirQuality, Integer> {
}
