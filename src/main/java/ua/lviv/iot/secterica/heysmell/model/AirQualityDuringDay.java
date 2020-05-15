package ua.lviv.iot.secterica.heysmell.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

//class for getting information from collection "air_quality" AKA mean air qualities during whole day
@Document(collection = "air_quality")
public class AirQualityDuringDay extends AirQuality {
    private LocalDateTime dateTime;// date and time

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

}
