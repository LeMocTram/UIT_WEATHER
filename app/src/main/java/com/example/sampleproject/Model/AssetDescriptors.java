package com.example.sampleproject.Model;

public class AssetDescriptors {
    public String descriptorType;
    public String name;
    public String icon;
    public String colour;
    public String assetDiscovery;
    public String assetImport;
    public String agentLinkType;

    public AssetDescriptors(String descriptorType, String name, String icon, String colour, String assetDiscovery, String assetImport, String agentLinkType) {
        this.descriptorType = descriptorType;
        this.name = name;
        this.icon = icon;
        this.colour = colour;
        this.assetDiscovery = assetDiscovery;
        this.assetImport = assetImport;
        this.agentLinkType = agentLinkType;
    }

    public String getDescriptorType() {
        return descriptorType;
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

    public String getAssetDiscovery() {
        return assetDiscovery;
    }

    public String getAssetImport() {
        return assetImport;
    }

    public String getAgentLinkType() {
        return agentLinkType;
    }

    @Override
    public String toString() {
        return "AssetDescriptors{" +
                "descriptorType='" + descriptorType + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", colour='" + colour + '\'' +
                ", assetDiscovery=" + assetDiscovery +
                ", assetImport=" + assetImport +
                ", agentLinkType='" + agentLinkType + '\'' +
                '}';
    }
}
