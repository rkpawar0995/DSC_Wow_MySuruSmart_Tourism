package xyz.rkplap.dschack;

public class FoodData {

    private String key;
    private String time;
    private String location;
    private String type;
    private String photo;
    private String name;
    private String dec;


    public FoodData() {
    }

    public FoodData(String time, String location, String type, String photo, String name, String dec) {
        this.time = time;
        this.location = location;
        this.type = type;
        this.photo = photo;
        this.name = name;
        this.dec = dec;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }
}
