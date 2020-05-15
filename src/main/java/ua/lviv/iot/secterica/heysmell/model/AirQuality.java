package ua.lviv.iot.secterica.heysmell.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

//class for getting information from collection "air_quality" AKA mean air qualities for whole days
@Document(collection = "air_quality")
public class AirQuality {
    @MongoId
//    private String _id;//id of transaction
    private ObjectId _id;
    private double tmp;//temperature
    private double hum;//humanity
    private double co;
    private double co2;
    private double lpg;//liquid petroleum gas
    private double smk;//smoke
    private double dus;//dust
    private int aqi;// air quality index
    private String id;// location_id
    private LocalDateTime dateTime;// date and time)

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getDus() {
        return dus;
    }

    public void setDus(double dus) {
        this.dus = dus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AirQuality{" +
                "id='" + _id + '\'' +
                ", tmp=" + tmp +
                ", hum=" + hum +
                ", co=" + co +
                ", co2=" + co2 +
                ", lpg=" + lpg +
                ", smk=" + smk +
                ", dst=" + dus +
                ", locationId=" + id +
//                ", date=" + date +
//                ", time=" + time +
                '}';
    }

    public double getTmp() {
        return tmp;
    }

    public void setTmp(double tmp) {
        this.tmp = tmp;
    }

    public double getHum() {
        return hum;
    }

    public void setHum(double hum) {
        this.hum = hum;
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

    public double getSmk() {
        return smk;
    }

    public void setSmk(double smk) {
        this.smk = smk;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

}
