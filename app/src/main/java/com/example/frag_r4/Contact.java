package com.example.frag_r4;

public class Contact {
    private String name;
    private String phone;
    private String location;
    private String url;

    public Contact() {
    }

    public Contact(String name, String phone, String location, String url) {
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}