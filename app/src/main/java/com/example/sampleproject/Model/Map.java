package com.example.sampleproject.Model;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;

import java.util.ArrayList;

public class Map {
    @SerializedName("options")
    public Object options;
    @SerializedName("version")
    public Integer version;
    @SerializedName("sources")
    public Object sources;
    @SerializedName("sprite")
    public String sprite;
    @SerializedName("glyphs")
    public String glyphs;
    @SerializedName("layers")
    public Object layers[];
}

