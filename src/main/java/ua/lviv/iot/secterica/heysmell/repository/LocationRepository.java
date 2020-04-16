package ua.lviv.iot.secterica.heysmell.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.lviv.iot.secterica.heysmell.model.Location;

public interface LocationRepository extends MongoRepository<Location, Integer> {
}
