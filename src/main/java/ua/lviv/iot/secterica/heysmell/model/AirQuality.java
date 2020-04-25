package ua.lviv.iot.secterica.heysmell.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.time.LocalTime;


@Document
public class AirQuality {
    @Id
    @MongoId
    private String id;
    private double tmp;//temperature
    private double hum;//humanity
    private double co;
    private double co2;
    private double lpg;//liquid petroleum gas
    private double smk;//smoke
    private double dst;//dust
    private Integer locationId;
    private LocalDate date;
    private LocalTime time;


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }


    public double getDst() {
        return dst;
    }

    public void setDst(double dst) {
        this.dst = dst;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "AirQuality{" +
                "id='" + id + '\'' +
                ", tmp=" + tmp +
                ", hum=" + hum +
                ", co=" + co +
                ", co2=" + co2 +
                ", lpg=" + lpg +
                ", smk=" + smk +
                ", dst=" + dst +
//                ", locationId=" + locationId +
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
