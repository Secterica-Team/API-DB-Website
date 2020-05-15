package ua.lviv.iot.secterica.heysmell.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

//class for getting information from collection "air_quality_by_day"
@Document(collection = "air_quality_by_day")
public class AirQualityForDays extends AirQuality{
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
