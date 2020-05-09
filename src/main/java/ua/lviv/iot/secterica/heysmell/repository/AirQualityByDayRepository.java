package ua.lviv.iot.secterica.heysmell.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.lviv.iot.secterica.heysmell.model.AirQualityByDay;

public interface AirQualityByDayRepository extends MongoRepository<AirQualityByDay, Integer> {
}
