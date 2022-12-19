package com.example.sampleproject.Model;

import java.util.ArrayList;

public class ValueDescriptors {
    public String name;
    public String type;
    public String jsonType;

    public ValueDescriptors(String name, String type, String jsonType) {
        this.name = name;
        this.type = type;
        this.jsonType = jsonType;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getJsonType() {
        return jsonType;
    }

    @Override
    public String toString() {
        return "ValueDescriptors{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", jsonType='" + jsonType + '\'' +
                '}';
    }
}
