package com.example.sampleproject;

import com.example.sampleproject.Model.Agent;
import com.example.sampleproject.Model.Asset;
import com.example.sampleproject.Model.AssetDescriptors;
import com.example.sampleproject.Model.AssetInfos;
import com.example.sampleproject.Model.Map;
import com.example.sampleproject.Model.MetaItemDescriptors;
import com.example.sampleproject.Model.User;
import com.example.sampleproject.Model.ValueDescriptors;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface APIInterface {
    @GET("api/master/asset/{assetID}")
    Call<Asset> getAsset(@Path("assetID") String assetID);//, @Header("Authorization") String auth);
    @GET("api/master/map")
    Call<Map> getMap();
    @GET("api/master/model/assetDescriptors")
    Call<List<AssetDescriptors>> getAssetDescriptors();
    @GET("api/master/model/assetInfos")
    Call<AssetInfos> getAssetInfos();
    @GET("api/master/model/metaItemDescriptors")
    Call<List<MetaItemDescriptors>> getMetaItemDescriptors();
    @GET("api/master/model/valueDescriptors")
    Call<List<ValueDescriptors>> getValueDescriptors();
    @GET("api/master/user/user")
    Call<User> getUser();
    @GET("api/master/asset/{assetID}")
    Call<Agent> getAgent(@Path("assetID") String assetID);

}
