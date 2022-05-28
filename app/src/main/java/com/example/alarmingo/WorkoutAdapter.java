package com.example.alarmingo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class WorkoutAdapter extends ArrayAdapter<Workout>{

    Context superActivity; //To call intent

    public WorkoutAdapter(Context context, List<Workout> times) {
        super(context, 0, times);
        superActivity = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.workout_list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Workout currentWk = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID Sno
        TextView snoTextView = listItemView.findViewById(R.id.Sno);
        String Sno = Integer.toString(position + 1);
        snoTextView.setText(Sno);

        // Find the TextView in the list_item.xml layout with the ID workout_name
        TextView nameTextView = listItemView.findViewById(R.id.workout_name);
        nameTextView.setText(currentWk.getName());

        // Find the TextView in the list_item.xml layout with the ID duration.
        TextView durationTextView = listItemView.findViewById(R.id.duration);

        String Dur;

        if(currentWk.getHas_reps().equals("true")) {
            Dur = "X" + currentWk.getReps();
        } else {
            Dur = currentWk.getReps() + " seconds";
        }
        durationTextView.setText(Dur);

        listItemView.setOnClickListener(view -> {
            Intent myIntent;
            if(currentWk.getHas_reps().equals("true")) {
                myIntent = new Intent(superActivity, WorkoutDeetsReps.class);
            } else {
                myIntent = new Intent(superActivity, WorkoutDeetsTime.class);
            }
            myIntent.putExtra("name", currentWk.getName());
            myIntent.putExtra("reps",currentWk.getReps());
            superActivity.startActivity(myIntent);
        });

        return listItemView;
    }
}
