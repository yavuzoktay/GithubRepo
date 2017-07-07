package com.yavuzoktay.GithubUser.ui.adapter.adapter.adapter.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.yavuzoktay.GithubUser.R;
import com.yavuzoktay.GithubUser.api.model.GithubRepo;
import com.yavuzoktay.GithubUser.api.service.GithubClient;
import com.yavuzoktay.GithubUser.ui.adapter.adapter.adapter.adapter.adapter.GithubRepoAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= (ListView) findViewById(R.id.pagination_list);

        Retrofit.Builder  builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com").addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit =builder.build();
        GithubClient client =retrofit.create(GithubClient.class);
        Call<List<GithubRepo>> call=client.repoForUser("yavuzoktay");

        call.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                List<GithubRepo> repos= response.body();

                listView.setAdapter((ListAdapter) new GithubRepoAdapter(MainActivity.this,repos));
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"error !!!",Toast.LENGTH_LONG).show();
            }
        });
    }
}
