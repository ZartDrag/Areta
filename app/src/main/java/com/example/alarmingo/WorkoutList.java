package com.example.alarmingo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;

public class WorkoutList extends AppCompatActivity {

    JSONreciever JRec;
    List<Workout> WList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://us-east-1.aws.data.mongodb-api.com/app/areta-rihyq/endpoint/exercise/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JRec = retrofit.create(JSONreciever.class);
        getMonday();

    }

    public void getMonday(){
        Call<List<Workout>> call = JRec.getMonday();
        call.enqueue(new Callback<List<Workout>>() {
            @Override
            public void onResponse(@NonNull Call<List<Workout>> call, @NonNull Response<List<Workout>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(WorkoutList.this, response.code(), Toast.LENGTH_LONG).show();
                    Log.i("Responded", Integer.toString(response.code()));
                    return;
                }
                WList = response.body();
                Log.i("reached here", "onResponse: hello");

                // adapter knows how to create list items for each item in the list.
                WorkoutAdapter adapter = new WorkoutAdapter(WorkoutList.this, WList);
                ListView listView = findViewById(R.id.workout_list);
                // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
                // {@link ListView} will display list items for each {@link Word} in the list.

                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(@NonNull Call<List<Workout>> call, @NonNull Throwable t) {
                Toast.makeText(WorkoutList.this, t.getMessage() , Toast.LENGTH_LONG).show();
                Log.i("No response", t.getMessage());
            }
        });
    }


}