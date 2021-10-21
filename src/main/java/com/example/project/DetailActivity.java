package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project.adapters.AnimeAdapter;
import com.example.project.adapters.NameAdapter;
import com.example.project.entities.Anime;
import com.example.project.services.GitHubService;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Log.i("MAIN_APP","Iniciando Segunda Actividad");

//        Intent intent = getIntent();
//        String value = intent.getStringExtra("value");

        //SIEMPRE ES IGUAL
        RecyclerView rv = findViewById(R.id.rvNames);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fleccat3.free.beeceptor.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        service.allAnimes().enqueue(new Callback<List<Anime>>() {
            @Override
            public void onResponse(Call<List<Anime>> call, Response<List<Anime>> response) {
                Log.i("MAIN_APP",String.valueOf(response.code()));
                if(response.code() == 200){
                    AnimeAdapter adapter = new AnimeAdapter(response.body());
                    rv.setAdapter(adapter);

                }



            }

            @Override
            public void onFailure(Call<List<Anime>> call, Throwable t) {
                Log.i("MAIN_APP","No hubo comunicación con el servidor");

            }


        });

        //ImageView ivAnime = findViewById(R.id.ivAnime);
        //ImageView ivImgRate = findViewById(R.id.ivImgRate);

        //Picasso.get().load(String.valueOf(ivAnime)).into(ivAnime);
        //Picasso.get().load(String.valueOf(ivImgRate)).into(ivImgRate);







    }
}