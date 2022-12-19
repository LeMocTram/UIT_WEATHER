package com.example.sampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sampleproject.Model.Asset;
import com.example.sampleproject.Model.Default;
import com.example.sampleproject.Model.Map;
import com.example.sampleproject.Model.Options;
import com.google.gson.Gson;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainAsset extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        TextView tv_attribute = findViewById(R.id.tv1);
        TextView tv_humidity = findViewById(R.id.tv3);
        TextView tv_timestamp = findViewById(R.id.tv5);


        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<Asset> call = apiInterface.getAsset("6H4PeKLRMea1L0WsRXXWp9");//, "Bearer "+ token);
        call.enqueue(new Callback<Asset>() {
            @Override
            public void onResponse(Call<Asset> call, Response<Asset> response) {
                try {
                Log.d("API CALL", response.code() + "");
                //Log.d ("API CALL", response.toString());
                Asset asset = response.body();
                tv_attribute.setText(asset.attributes.humidity.getName());
                tv_humidity.setText(String.valueOf(asset.attributes.humidity.value));
                tv_timestamp.setText(String.valueOf(asset.attributes.humidity.timestamp));
                //txttype.setText(asset.type);
                }
                catch (Exception ex)
                {
                    Log.d("callAssetError",ex.getMessage() );
                }
            }
            @Override
            public void onFailure(Call<Asset> call, Throwable t) {
                Log.d("API CALL", t.getMessage().toString());

                //t.printStackTrace();

            }


        });
    }
}