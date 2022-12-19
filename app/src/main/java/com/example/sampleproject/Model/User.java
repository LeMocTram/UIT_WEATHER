package com.example.sampleproject.Model;

public class User {
    public String realm;
    public String realmId;
    public String id;
    public String enabled;
    public String createdOn;
    public String serviceAccount;
    public String username;

    public User(String realm, String realmId, String id, String enabled, String createdOn, String serviceAccount, String username) {
        this.realm = realm;
        this.realmId = realmId;
        this.id = id;
        this.enabled = enabled;
        this.createdOn = createdOn;
        this.serviceAccount = serviceAccount;
        this.username = username;
    }

    public String getRealm() {
        return realm;
    }

    public String getRealmId() {
        return realmId;
    }

    public String getId() {
        return id;
    }

    public String getEnabled() {
        return enabled;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public String getServiceAccount() {
        return serviceAccount;
    }

    public String getUsername() {
        return username;
    }
}
