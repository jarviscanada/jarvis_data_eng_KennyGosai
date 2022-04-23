package ca.jrvs.apps.twitter.model;

public class Coordinates {
    private double longitude;
    private double latitude;
    private String type;

    public Coordinates() {
        this.longitude = longitude;
        this.latitude = latitude;
        this.type = type;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
