package com.example.property;
import android.app.Application;

public class glob extends Application {

    private String City;
    private Double latmin;
    private Double lngmin;
    private Double latmax;
    private Double lngmax;
    private Double lat;
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    private Double lng;


    public Double getLatmin() {
        return latmin;
    }

    public void setLatmin(Double latmin) {
        this.latmin = latmin;
    }

    public Double getLngmin() {
        return lngmin;
    }

    public void setLngmin(Double lngmin) {
        this.lngmin = lngmin;
    }

    public Double getLatmax() {
        return latmax;
    }

    public void setLatmax(Double latmax) {
        this.latmax = latmax;
    }

    public Double getLngmax() {
        return lngmax;
    }

    public void setLngmax(Double lngmax) {
        this.lngmax = lngmax;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

}
