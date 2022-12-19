package com.example.sampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
//import android.widget.SearchView;
import androidx.appcompat.widget.SearchView;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    APIInterface apiInterface;
    private MapView mapView;
    private IMapController mapController;
    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.search);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            List<Address> addressList = null;
            @Override
            public boolean onQueryTextSubmit(String query) {
                try {
                    String s1 = "Weather asset";
                    String s2 = "Weather asset 2";
                    String s3 = "Weather asset 3";
                    String location = searchView.getQuery().toString();
                  if (location.equals(s1))
                  {
                      Call<Asset> call = apiInterface.getAsset("6H4PeKLRMea1L0WsRXXWp9");//, "Bearer "+ token);
                      call.enqueue(new Callback<Asset>() {
                          @Override
                          public void onResponse(Call<Asset> call, Response<Asset> response) {
                              Asset asset = response.body();
                              Double longitude = asset.attributes.location.value.coordinates[0];
                              Double latitude = asset.attributes.location.value.coordinates[1];
                              GeoPoint startPoint = new GeoPoint(latitude, longitude);
                              mapView = findViewById(R.id.uitMap);
                              mapController = mapView.getController();
                              mapController.setCenter(startPoint);
                              Marker marker = new Marker(mapView);
                              marker.setPosition(startPoint);
                              mapView.getOverlays().add(marker);
                              marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
                              marker.setIcon(getResources().getDrawable(R.drawable.marker_icon));
//                              marker1.setTitle(asset.name);
                              mapController.setZoom(20);
                              marker.setOnMarkerClickListener(new Marker.OnMarkerClickListener() {
                                  @Override
                                  public boolean onMarkerClick(Marker marker, MapView mapView) {
                                      Toast.makeText(MainActivity.this, "Clicked location is " , Toast.LENGTH_SHORT).show();
                                      Dialog dialog = new Dialog(MainActivity.this);
                                      dialog.setContentView(R.layout.layout_dialog_asset);
                                      TextView tvName = (TextView) dialog.findViewById(R.id.title_asset);
                                      TextView tvHumidity = (TextView) dialog.findViewById(R.id.humidity);
                                      TextView tvTemperature = (TextView) dialog.findViewById(R.id.temperature);
                                      TextView tvWD = (TextView) dialog.findViewById(R.id.wDirection);
                                      TextView tvWS = (TextView) dialog.findViewById(R.id.wSpeed);
                                      TextView tvRainfall = (TextView) dialog.findViewById(R.id.rainfall);
                                      TextView tvSun_altitude = (TextView) dialog.findViewById(R.id.sun_altitude);
                                      TextView tvSun_azimuth = (TextView) dialog.findViewById(R.id.sun_azimuth);
                                      tvName.setText(asset.getName());
                                      tvHumidity.setText(asset.attributes.humidity.getValue()+"%");
                                      tvTemperature.setText(String.valueOf(asset.attributes.temperature.getValue())+"℃");
                                      tvWD.setText(String.valueOf(asset.attributes.windDirection.value));
                                      tvWS.setText(String.valueOf(asset.attributes.windSpeed.value)+"km/h");
                                      tvRainfall.setText(String.valueOf(asset.attributes.rainfall.value)+"mm");
                                      tvSun_altitude.setText(String.valueOf(asset.attributes.sunAltitude.value));
                                      tvSun_azimuth.setText(String.valueOf(asset.attributes.sunAzimuth.value));
                                      dialog.show();
                                      return true;
                                  }
                              });

                          }
                          @Override
                          public void onFailure(Call<Asset> call, Throwable t) {
                              Log.d("API CALL", t.getMessage().toString());

                              //t.printStackTrace();

                          }
                      });
                  }else if (location.equals(s2)){
                      Call<Asset> call1 = apiInterface.getAsset("2UZPM2Mvu11Xyq5jCWNMX1");//, "Bearer "+ token);
                      call1.enqueue(new Callback<Asset>() {
                          @Override
                          public void onResponse(Call<Asset> call1, Response<Asset> response) {
                              Asset asset = response.body();
                              Double longitude = asset.attributes.location.value.coordinates[0];
                              Double latitude = asset.attributes.location.value.coordinates[1];
                              GeoPoint startPoint = new GeoPoint(latitude, longitude);
                              mapView = findViewById(R.id.uitMap);
                              mapController = mapView.getController();
                              mapController.setCenter(startPoint);
                              Marker marker = new Marker(mapView);
                              marker.setPosition(startPoint);
                              mapView.getOverlays().add(marker);
                              marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
                              marker.setIcon(getResources().getDrawable(R.drawable.marker_icon));
//                              marker1.setTitle(asset.name);
                              mapController.setZoom(20);
                              marker.setOnMarkerClickListener(new Marker.OnMarkerClickListener() {
                                  @Override
                                  public boolean onMarkerClick(Marker marker, MapView mapView) {
                                      Toast.makeText(MainActivity.this, "Clicked location is " , Toast.LENGTH_SHORT).show();
                                      Dialog dialog = new Dialog(MainActivity.this);
                                      dialog.setContentView(R.layout.layout_dialog_asset);
                                      TextView tvName = (TextView) dialog.findViewById(R.id.title_asset);
                                      TextView tvHumidity = (TextView) dialog.findViewById(R.id.humidity);
                                      TextView tvTemperature = (TextView) dialog.findViewById(R.id.temperature);
                                      TextView tvWD = (TextView) dialog.findViewById(R.id.wDirection);
                                      TextView tvWS = (TextView) dialog.findViewById(R.id.wSpeed);
                                      TextView tvRainfall = (TextView) dialog.findViewById(R.id.rainfall);
                                      TextView tvSun_altitude = (TextView) dialog.findViewById(R.id.sun_altitude);
                                      TextView tvSun_azimuth = (TextView) dialog.findViewById(R.id.sun_azimuth);
                                      tvName.setText(asset.getName());
                                      tvHumidity.setText(asset.attributes.humidity.getValue()+"%");
                                      tvTemperature.setText(String.valueOf(asset.attributes.temperature.getValue())+"℃");
                                      tvWD.setText(String.valueOf(asset.attributes.windDirection.value));
                                      tvWS.setText(String.valueOf(asset.attributes.windSpeed.value)+"km/h");
                                      tvRainfall.setText(String.valueOf(asset.attributes.rainfall.value)+"mm");
                                      tvSun_altitude.setText(String.valueOf(asset.attributes.sunAltitude.value));
                                      tvSun_azimuth.setText(String.valueOf(asset.attributes.sunAzimuth.value));
                                      dialog.show();
                                      return true;
                                  }
                              });

                          }
                          @Override
                          public void onFailure(Call<Asset> call1, Throwable t) {
                              Log.d("API CALL", t.getMessage().toString());

                              //t.printStackTrace();

                          }
                      });
                  }else if(location.equals(s3)){
                      Call<Asset> call2 = apiInterface.getAsset("4cdWlxEvmDRBBDEc2HRsaF");//, "Bearer "+ token);
                      call2.enqueue(new Callback<Asset>() {
                          @Override
                          public void onResponse(Call<Asset> call2, Response<Asset> response) {
                              Asset asset = response.body();
                              Double longitude = asset.attributes.location.value.coordinates[0];
                              Double latitude = asset.attributes.location.value.coordinates[1];
                              GeoPoint startPoint = new GeoPoint(latitude, longitude);
                              mapView = findViewById(R.id.uitMap);
                              mapController = mapView.getController();
                              mapController.setCenter(startPoint);
                              Marker marker = new Marker(mapView);
                              marker.setPosition(startPoint);
                              mapView.getOverlays().add(marker);
                              marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
                              marker.setIcon(getResources().getDrawable(R.drawable.marker_icon));
//                              marker1.setTitle(asset.name);
                              mapController.setZoom(20);
                              marker.setOnMarkerClickListener(new Marker.OnMarkerClickListener() {
                                  @Override
                                  public boolean onMarkerClick(Marker marker, MapView mapView) {
                                      Toast.makeText(MainActivity.this, "Clicked location is " , Toast.LENGTH_SHORT).show();
                                      Dialog dialog = new Dialog(MainActivity.this);
                                      dialog.setContentView(R.layout.layout_dialog_asset);
                                      TextView tvName = (TextView) dialog.findViewById(R.id.title_asset);
                                      TextView tvHumidity = (TextView) dialog.findViewById(R.id.humidity);
                                      TextView tvTemperature = (TextView) dialog.findViewById(R.id.temperature);
                                      TextView tvWD = (TextView) dialog.findViewById(R.id.wDirection);
                                      TextView tvWS = (TextView) dialog.findViewById(R.id.wSpeed);
                                      TextView tvRainfall = (TextView) dialog.findViewById(R.id.rainfall);
                                      TextView tvSun_altitude = (TextView) dialog.findViewById(R.id.sun_altitude);
                                      TextView tvSun_azimuth = (TextView) dialog.findViewById(R.id.sun_azimuth);
                                      tvName.setText(asset.getName());
                                      tvHumidity.setText(asset.attributes.humidity.getValue()+"%");
                                      tvTemperature.setText(String.valueOf(asset.attributes.temperature.getValue())+"℃");
                                      tvWD.setText(String.valueOf(asset.attributes.windDirection.value));
                                      tvWS.setText(String.valueOf(asset.attributes.windSpeed.value)+"km/h");
                                      tvRainfall.setText(String.valueOf(asset.attributes.rainfall.value)+"mm");
                                      tvSun_altitude.setText(String.valueOf(asset.attributes.sunAltitude.value));
                                      tvSun_azimuth.setText(String.valueOf(asset.attributes.sunAzimuth.value));
                                      dialog.show();
                                      return true;
                                  }
                              });
                          }


                          @Override
                          public void onFailure(Call<Asset> call2, Throwable t) {
                              Log.d("API CALL", t.getMessage().toString());
                              //t.printStackTrace();
                          }
                      });
                  }
                } catch (Exception ex)
                {
                    Log.d("callAssetError",ex.getMessage() );
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        Button mybutton1 = findViewById(R.id.chart);
        mybutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Chart = new Intent(getApplicationContext(),ChartActivity.class);
                startActivity(Chart);
            }
        });

        Button mybutton4 = findViewById(R.id.user);
        mybutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent UserInfor = new Intent(getApplicationContext(),UserActivity.class);
                startActivity(UserInfor);
            }
        });


        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<Map> mapCall = apiInterface.getMap();
        mapCall.enqueue(new Callback<Map>() {
            @Override
            public void onResponse(Call<Map> call, Response<Map> response) {
                    Map map = response.body();
                    TextView textView = findViewById(R.id.info);
                    Gson gson = new Gson();
                    String json = gson.toJson(map.options);
                    Options optionsObj = gson.fromJson(json, Options.class);
                    json = gson.toJson(optionsObj._default);
                    Default defaultObj = gson.fromJson(json, Default.class);
                    Double zoom = defaultObj.zoom;
                    Double longitude = defaultObj.center[0];
                    Double latitude = defaultObj.center[1];

                    mapView = findViewById(R.id.uitMap);
                    mapView.setTileSource(TileSourceFactory.MAPNIK);
                    mapView.setBuiltInZoomControls(true);
                    mapView.setMultiTouchControls(true);
                    mapController = mapView.getController();
                    mapController.setZoom(zoom);
                    GeoPoint startPoint = new GeoPoint(latitude, longitude);
                    mapController.setCenter(startPoint);
                    mapController.setZoom(15);
//                    Marker marker = new Marker(mapView);
//                    marker.setPosition(startPoint);
//                    mapView.getOverlays().add(marker);
//                    marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
//                    marker.setIcon(getResources().getDrawable(R.drawable.marker_icon));

            }

            @Override
            public void onFailure(Call<Map> call, Throwable t) {
                t.printStackTrace();
            }
        });
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<Asset> call = apiInterface.getAsset("6H4PeKLRMea1L0WsRXXWp9");//, "Bearer "+ token);
        call.enqueue(new Callback<Asset>() {
            @Override
            public void onResponse(Call<Asset> call, Response<Asset> response) {
                Asset asset = response.body();
                Double longitude = asset.attributes.location.value.coordinates[0];
                Double latitude = asset.attributes.location.value.coordinates[1];
                GeoPoint startPoint = new GeoPoint(latitude, longitude);
                mapView = findViewById(R.id.uitMap);
                mapController = mapView.getController();
                mapController.setCenter(startPoint);
                Marker marker = new Marker(mapView);
                marker.setPosition(startPoint);
                mapView.getOverlays().add(marker);
                marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
                marker.setIcon(getResources().getDrawable(R.drawable.marker_icon));
                marker.setOnMarkerClickListener(new Marker.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker, MapView mapView) {
                        Toast.makeText(MainActivity.this, "Clicked location is " , Toast.LENGTH_SHORT).show();
                        Dialog dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.layout_dialog_asset);
                        TextView tvName = (TextView) dialog.findViewById(R.id.title_asset);
                        TextView tvHumidity = (TextView) dialog.findViewById(R.id.humidity);
                        TextView tvTemperature = (TextView) dialog.findViewById(R.id.temperature);
                        TextView tvWD = (TextView) dialog.findViewById(R.id.wDirection);
                        TextView tvWS = (TextView) dialog.findViewById(R.id.wSpeed);
                        TextView tvRainfall = (TextView) dialog.findViewById(R.id.rainfall);
                        TextView tvSun_altitude = (TextView) dialog.findViewById(R.id.sun_altitude);
                        TextView tvSun_azimuth = (TextView) dialog.findViewById(R.id.sun_azimuth);
                        tvName.setText(asset.getName());
                        tvHumidity.setText(asset.attributes.humidity.getValue()+"%");
                        tvTemperature.setText(String.valueOf(asset.attributes.temperature.getValue())+"℃");
                        tvWD.setText(String.valueOf(asset.attributes.windDirection.value));
                        tvWS.setText(String.valueOf(asset.attributes.windSpeed.value)+"km/h");
                        tvRainfall.setText(String.valueOf(asset.attributes.rainfall.value)+"mm");
                        tvSun_altitude.setText(String.valueOf(asset.attributes.sunAltitude.value));
                        tvSun_azimuth.setText(String.valueOf(asset.attributes.sunAzimuth.value));
                        dialog.show();
                        return true;
                    }
                });

            }
            @Override
            public void onFailure(Call<Asset> call, Throwable t) {
                Log.d("API CALL", t.getMessage().toString());

                //t.printStackTrace();

            }
        });
        Call<Asset> call1 = apiInterface.getAsset("2UZPM2Mvu11Xyq5jCWNMX1");//, "Bearer "+ token);
        call1.enqueue(new Callback<Asset>() {
            @Override
            public void onResponse(Call<Asset> call1, Response<Asset> response) {
                Asset asset = response.body();
                Double longitude = asset.attributes.location.value.coordinates[0];
                Double latitude = asset.attributes.location.value.coordinates[1];
                GeoPoint startPoint = new GeoPoint(latitude, longitude);
                mapView = findViewById(R.id.uitMap);
                mapController = mapView.getController();
                mapController.setCenter(startPoint);
                Marker marker = new Marker(mapView);
                marker.setPosition(startPoint);
                mapView.getOverlays().add(marker);
                marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
                marker.setIcon(getResources().getDrawable(R.drawable.marker_icon));
                marker.setOnMarkerClickListener(new Marker.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker, MapView mapView) {
                        Toast.makeText(MainActivity.this, "Clicked location is " , Toast.LENGTH_SHORT).show();
                        Dialog dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.layout_dialog_asset);
                        TextView tvName = (TextView) dialog.findViewById(R.id.title_asset);
                        TextView tvHumidity = (TextView) dialog.findViewById(R.id.humidity);
                        TextView tvTemperature = (TextView) dialog.findViewById(R.id.temperature);
                        TextView tvWD = (TextView) dialog.findViewById(R.id.wDirection);
                        TextView tvWS = (TextView) dialog.findViewById(R.id.wSpeed);
                        TextView tvRainfall = (TextView) dialog.findViewById(R.id.rainfall);
                        TextView tvSun_altitude = (TextView) dialog.findViewById(R.id.sun_altitude);
                        TextView tvSun_azimuth = (TextView) dialog.findViewById(R.id.sun_azimuth);
                        tvName.setText(asset.getName());
                        tvHumidity.setText(asset.attributes.humidity.getValue()+"%");
                        tvTemperature.setText(String.valueOf(asset.attributes.temperature.getValue())+"℃");
                        tvWD.setText(String.valueOf(asset.attributes.windDirection.value));
                        tvWS.setText(String.valueOf(asset.attributes.windSpeed.value)+"km/h");
                        tvRainfall.setText(String.valueOf(asset.attributes.rainfall.value)+"mm");
                        tvSun_altitude.setText(String.valueOf(asset.attributes.sunAltitude.value));
                        tvSun_azimuth.setText(String.valueOf(asset.attributes.sunAzimuth.value));
                        dialog.show();
                        return true;
                    }
                });
            }
            @Override
            public void onFailure(Call<Asset> call1, Throwable t) {
                Log.d("API CALL", t.getMessage().toString());

                //t.printStackTrace();

            }
        });
        Call<Asset> call2 = apiInterface.getAsset("4cdWlxEvmDRBBDEc2HRsaF");//, "Bearer "+ token);
        call2.enqueue(new Callback<Asset>() {
            @Override
            public void onResponse(Call<Asset> call2, Response<Asset> response) {
                Asset asset = response.body();
                Double longitude = asset.attributes.location.value.coordinates[0];
                Double latitude = asset.attributes.location.value.coordinates[1];
                GeoPoint startPoint = new GeoPoint(latitude, longitude);
                mapView = findViewById(R.id.uitMap);
                mapController = mapView.getController();
                mapController.setCenter(startPoint);
                Marker marker = new Marker(mapView);
                marker.setPosition(startPoint);
                mapView.getOverlays().add(marker);
                marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
                marker.setIcon(getResources().getDrawable(R.drawable.marker_icon));

                marker.setOnMarkerClickListener(new Marker.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker, MapView mapView) {
                        Toast.makeText(MainActivity.this, "Clicked location is " , Toast.LENGTH_SHORT).show();
                        Dialog dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.layout_dialog_asset);
                        TextView tvName = (TextView) dialog.findViewById(R.id.title_asset);
                        TextView tvHumidity = (TextView) dialog.findViewById(R.id.humidity);
                        TextView tvTemperature = (TextView) dialog.findViewById(R.id.temperature);
                        TextView tvWD = (TextView) dialog.findViewById(R.id.wDirection);
                        TextView tvWS = (TextView) dialog.findViewById(R.id.wSpeed);
                        TextView tvRainfall = (TextView) dialog.findViewById(R.id.rainfall);
                        TextView tvSun_altitude = (TextView) dialog.findViewById(R.id.sun_altitude);
                        TextView tvSun_azimuth = (TextView) dialog.findViewById(R.id.sun_azimuth);
                        tvName.setText(asset.getName());
                        tvHumidity.setText(asset.attributes.humidity.getValue()+"%");
                        tvTemperature.setText(String.valueOf(asset.attributes.temperature.getValue())+"℃");
                        tvWD.setText(String.valueOf(asset.attributes.windDirection.value));
                        tvWS.setText(String.valueOf(asset.attributes.windSpeed.value)+"km/h");
                        tvRainfall.setText(String.valueOf(asset.attributes.rainfall.value)+"mm");
                        tvSun_altitude.setText(String.valueOf(asset.attributes.sunAltitude.value));
                        tvSun_azimuth.setText(String.valueOf(asset.attributes.sunAzimuth.value));
                        dialog.show();
                        return true;
                    }
                });

            }


            @Override
            public void onFailure(Call<Asset> call2, Throwable t) {
                Log.d("API CALL", t.getMessage().toString());

                //t.printStackTrace();

            }

        });

    }
    public Marker addMarker(GeoPoint p, MapView osm) {

        Marker marker = new Marker(osm);
        marker.setPosition(p);
        osm.getOverlays().add(marker);
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
//        marker.setTitle("Marker");
//        marker.setSnippet("Snippet marker");
//        marker.setSubDescription("SubDescription marker");
        return marker;

    }
}