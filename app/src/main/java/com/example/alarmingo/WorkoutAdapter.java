package com.example.alarmingo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class WorkoutAdapter extends ArrayAdapter<Workout>{

    public WorkoutAdapter(Context context, ArrayList<Workout> times) {
        super(context, 0, times);
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
        TextView snoTextView = (TextView) listItemView.findViewById(R.id.Sno);
        String text = Integer.toString(position + 1);
        snoTextView.setText(text);

        // Find the TextView in the list_item.xml layout with the ID workout_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.workout_name);
        nameTextView.setText(currentWk.getName());

        // Find the TextView in the list_item.xml layout with the ID duration.
        TextView durationTextView = (TextView) listItemView.findViewById(R.id.duration);

        if(currentWk.getHasReps()) {
            text = "X" + currentWk.getReps();
        } else {
            text = currentWk.getReps() + " seconds";
        }
        durationTextView.setText(text);

        return listItemView;
    }
}
