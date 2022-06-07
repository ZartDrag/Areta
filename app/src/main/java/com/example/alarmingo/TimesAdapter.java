package com.example.alarmingo;

import android.app.TimePickerDialog;
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

import java.util.ArrayList;

public class TimesAdapter extends ArrayAdapter<Times> implements TimePickerDialog.OnTimeSetListener {
    FragmentActivity con;

    public TimesAdapter(Context context, ArrayList<Times> times) {
        super(context, 0, times);
        con = (FragmentActivity) context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.alarm_list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Times currentTime = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID alarm_time
        TextView timeTextView = listItemView.findViewById(R.id.alarm_time);
        timeTextView.setText(currentTime.getTime());
        timeTextView.setOnClickListener(v -> AlarmList.TimeDialog(con));

        SwitchCompat alarmStatus = listItemView.findViewById(R.id.alarm_switch);

        alarmStatus.setChecked(currentTime.getStatus());
        return listItemView;
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {

    }
}
