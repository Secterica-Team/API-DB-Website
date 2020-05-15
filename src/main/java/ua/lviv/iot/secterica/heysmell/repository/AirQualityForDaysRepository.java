package ua.lviv.iot.secterica.heysmell.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.secterica.heysmell.model.AirQualityForDays;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface AirQualityForDaysRepository extends MongoRepository<AirQualityForDays, String> {
    List<AirQualityForDays> findAllById(String locationId);
    List<AirQualityForDays> findAllByIdAndDate(String locationId, LocalDate date);
}
