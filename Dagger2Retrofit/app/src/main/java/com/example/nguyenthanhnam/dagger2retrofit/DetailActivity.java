package com.example.nguyenthanhnam.dagger2retrofit;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.nguyenthanhnam.dagger2retrofit.MyApplication;
import com.example.nguyenthanhnam.dagger2retrofit.R;
import com.example.nguyenthanhnam.dagger2retrofit.Components.ApplicationComponent;
import com.example.nguyenthanhnam.dagger2retrofit.Components.DetailActivityComponent;
import com.example.nguyenthanhnam.dagger2retrofit.Components.DaggerDetailActivityComponent;
import com.example.nguyenthanhnam.dagger2retrofit.qualifiers.ApplicationContext;
import com.example.nguyenthanhnam.dagger2retrofit.pojo.Film;
import com.example.nguyenthanhnam.dagger2retrofit.retrofit.APIInterface;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class DetailActivity extends AppCompatActivity {
    DetailActivityComponent detailActivityComponent;

    @Inject
    public APIInterface apiInterface;

    @Inject
    @ApplicationContext
    public Context mContext;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textView = findViewById(R.id.textView);

        String url = getIntent().getStringExtra("url");

        ApplicationComponent applicationComponent = MyApplication.get(this).getApplicationComponent();
        detailActivityComponent = DaggerDetailActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .build();

        detailActivityComponent.inject(this);

        apiInterface.getFilmData(url, "json").enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                Film films = response.body();
                String text = "Film name:\n" + films.title + "\nDirector:\n" + films.director;
                textView.setText(text);
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {

            }
        });
    }
}

