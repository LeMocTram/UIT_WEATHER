package com.example.sampleproject.Model;


import androidx.core.view.ViewCompat;

import java.util.ArrayList;

public class MetaItemDescriptors {

    public String name;
    public String type;

    public MetaItemDescriptors(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "MetaItemDescriptors{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}