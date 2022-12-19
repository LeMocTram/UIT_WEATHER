package com.example.sampleproject.Model;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class AssetInfos {
    AssetDescriptor AssetDescriptorObject;
    ArrayList< Object > attributeDescriptors = new ArrayList < Object > ();
    ArrayList < Object > metaItemDescriptors = new ArrayList < Object > ();
    ArrayList < Object > valueDescriptors = new ArrayList < Object > ();

    static class AssetDescriptor{
        public String name;
        public String icon;
        public String colour;
        public String descriptorType;

        public AssetDescriptor(String name, String icon, String colour, String descriptorType) {
            this.name = name;
            this.icon = icon;
            this.colour = colour;
            this.descriptorType = descriptorType;
        }

        public String getName() {
            return name;
        }

        public String getIcon() {
            return icon;
        }

        public String getColour() {
            return colour;
        }

        public String getDescriptorType() {
            return descriptorType;
        }
    }

    public AssetInfos(AssetDescriptor assetDescriptorObject, ArrayList<Object> attributeDescriptors, ArrayList<Object> metaItemDescriptors, ArrayList<Object> valueDescriptors) {
        AssetDescriptorObject = assetDescriptorObject;
        this.attributeDescriptors = attributeDescriptors;
        this.metaItemDescriptors = metaItemDescriptors;
        this.valueDescriptors = valueDescriptors;
    }

    public AssetDescriptor getAssetDescriptorObject() {
        return AssetDescriptorObject;
    }

    public ArrayList<Object> getAttributeDescriptors() {
        return attributeDescriptors;
    }

    public ArrayList<Object> getMetaItemDescriptors() {
        return metaItemDescriptors;
    }

    public ArrayList<Object> getValueDescriptors() {
        return valueDescriptors;
    }

    @NonNull
    @Override
    public String toString() {
        return "AssetInfos{" +
                "AssetDescriptorObject=" + AssetDescriptorObject +
                ", attributeDescriptors=" + attributeDescriptors +
                ", metaItemDescriptors=" + metaItemDescriptors +
                ", valueDescriptors=" + valueDescriptors +
                '}'+"\n\n";
    }
}
