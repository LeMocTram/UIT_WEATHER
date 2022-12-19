package com.example.sampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.sampleproject.Model.User;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        TextView tv_username = findViewById(R.id.username);
        TextView tv_serviceAccount = findViewById(R.id.serviceAccount);
        TextView tv_createdOn = findViewById(R.id.createdOn);
        TextView tv_enabled = findViewById(R.id.enabled);
        TextView tv_tvRealmID = findViewById(R.id.tvRealmID);
        TextView tv_Realm = findViewById(R.id.tvRealm);
        TextView tv_Id = findViewById(R.id.tvID);

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<User> userCall = apiInterface.getUser();
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                tv_Realm.setText(user.getRealm());
                tv_tvRealmID.setText(user.getRealmId());
                tv_enabled.setText(user.getEnabled());
                tv_createdOn.setText(user.getCreatedOn());
                tv_serviceAccount.setText(user.getServiceAccount());
                tv_username.setText(user.getUsername());
                tv_Id.setText(user.getId());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("API CALL", t.getMessage().toString());
            }
        });



    }
}