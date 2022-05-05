package com.example.alarmingo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class WorkoutList extends AppCompatActivity {

    ArrayList<Workout> WList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);

        //Try to store data in the mongocloud and fetch using API

        WList.add(new Workout("Plank",60, false));
        WList.add(new Workout("PushUp",15, true));

        // adapter knows how to create list items for each item in the list.
        WorkoutAdapter adapter = new WorkoutAdapter(this, WList);
        ListView listView = (ListView) findViewById(R.id.workout_list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.

        listView.setAdapter(adapter);
    }
}