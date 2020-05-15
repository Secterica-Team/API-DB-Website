package ua.lviv.iot.secterica.heysmell.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

public class AirQuality {
    @MongoId
    protected ObjectId _id;
    protected double tmp;//temperature
    protected double hum;//humanity
    protected double co;
    protected double co2;
    protected double lpg;//liquid petroleum gas
    protected double smk;//smoke
    protected double dus;//dust
    protected int aqi;// air quality index
    protected String id;// location id

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
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
