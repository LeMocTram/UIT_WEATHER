package com.example.sampleproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sampleproject.Adapter.AssetdescriptorAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AssetDescriptors extends AppCompatActivity {
    APIInterface apiInterface;
    public RecyclerView rcvAssetDescriptor;
    public List<com.example.sampleproject.Model.AssetDescriptors>  mlistDescriptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_descriptors);
        rcvAssetDescriptor = findViewById(R.id.rcv_assetDescriptor);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvAssetDescriptor.setLayoutManager(linearLayoutManager);

        DividerItemDecoration itemDecoration =new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvAssetDescriptor.addItemDecoration(itemDecoration);

        mlistDescriptor = new ArrayList<>();
        apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<List<com.example.sampleproject.Model.AssetDescriptors>> assetDescriptorsCall = apiInterface.getAssetDescriptors();
        assetDescriptorsCall.enqueue(new Callback<List<com.example.sampleproject.Model.AssetDescriptors>>() {
            @Override
            public void onResponse( Call<List<com.example.sampleproject.Model.AssetDescriptors>> call, Response< List<com.example.sampleproject.Model.AssetDescriptors>> response) {
                Log.d("API CALL", response.code() + "");
                mlistDescriptor = response.body();
                AssetdescriptorAdapter assetdescriptorAdapter = new AssetdescriptorAdapter(mlistDescriptor);
                rcvAssetDescriptor.setAdapter(assetdescriptorAdapter);
            }

            @Override
            public void onFailure(Call<List<com.example.sampleproject.Model.AssetDescriptors>> call, Throwable t) {
                Log.d("API CALL", t.getMessage().toString());
                Toast.makeText(AssetDescriptors.this, "onFailure",Toast.LENGTH_SHORT).show();
            }
        });
    }
}