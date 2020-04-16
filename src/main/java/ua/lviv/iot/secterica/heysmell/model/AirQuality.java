package ua.lviv.iot.secterica.heysmell.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AirQuality {
    @Id
    private String id;
    private double tmp;//temperature
    private double hum;//humanity
    private double сo;
    private double сo2;
    private double lpg;//liquid petroleum gas
    private double smk;//smoke
    private double dst;//smoke
    private Location location;


    @Override
    public String toString() {
        return "AirQuality{" +
                "id='" + id + '\'' +
                ", temp=" + tmp +
                ", hum=" + hum +
                ", Co=" + сo +
                ", Co2=" + сo2 +
                ", CH4=" + lpg +
                ", alc=" + smk +
                ", location=" + location +
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

    public double getСo() {
        return сo;
    }

    public void setСo(double сo) {
        this.сo = сo;
    }

    public double getСo2() {
        return сo2;
    }

    public void setСo2(double сo2) {
        this.сo2 = сo2;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
