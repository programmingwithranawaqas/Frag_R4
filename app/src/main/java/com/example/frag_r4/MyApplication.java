package com.example.frag_r4;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {
    public static ArrayList<Contact> contacts;

    @Override
    public void onCreate() {
        super.onCreate();
        contacts = new ArrayList<>();
        contacts.add(new Contact("Ali Raza", "03234677035", "Wapda Town Goll Chakkar", "https://www.ucp.edu.pk"));
        contacts.add(new Contact("Khadim Hussain", "03444677035", "Emporium Mall", "https://www.ucp.edu.pk"));
        contacts.add(new Contact("Rana Farhan", "03334677035", "Gajju Matta Lahore", "https://www.ucp.edu.pk"));


    }
}
