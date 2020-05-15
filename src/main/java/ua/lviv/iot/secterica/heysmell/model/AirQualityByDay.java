package ua.lviv.iot.secterica.heysmell.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;

//class for getting information from collection "air_quality_by_day"
@Document(collection = "air_quality_by_day")
public class AirQualityByDay {
    @MongoId
//    private String _id;//id of transaction
    private ObjectId _id;
    private double temperature;//temperature
    private double humidity;//humidity
    private double co;
    private double co2;
    private double lpg;//liquid petroleum gas
    private double smoke;//smoke
    private double dust;//dust
    private int aqi;// air quality index
    private String sensor_id;// location_id
    private LocalDate date;// date and time)

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getDust() {
        return dust;
    }

    public void setDust(double dust) {
        this.dust = dust;
    }

    public String getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(String sensor_id) {
        this.sensor_id = sensor_id;
    }

    @Override
    public String toString() {
        return "AirQuality{" +
                "id='" + _id + '\'' +
                ", tmp=" + temperature +
                ", hum=" + humidity +
                ", co=" + co +
                ", co2=" + co2 +
                ", lpg=" + lpg +
                ", smk=" + smoke +
                ", dst=" + dust +
                ", locationId=" + sensor_id +
//                ", date=" + date +
//                ", time=" + time +
                '}';
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getCo() {
        return co;
    }

    public void setCo(double co) {
        this.co = co;
    }

    public double getCo2() {
        return co2;
    }

    public void setCo2(double co2) {
        this.co2 = co2;
    }

    public double getLpg() {
        return lpg;
    }

    public void setLpg(double lpg) {
        this.lpg = lpg;
    }

    public double getSmoke() {
        return smoke;
    }

    public void setSmoke(double smoke) {
        this.smoke = smoke;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

}
