package com.example.alarmingo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class AlarmList extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private ArrayList<Times> savedAlarms = new ArrayList<>();
    static final int ALARM_REQ_CODE = 100;
    static MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_list);

        Button buttonTimePicker = findViewById(R.id.SetAlarmButton);
        buttonTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onTimeSet(TimePicker timePicker, int intHourOfDay, int intMinute) {
        //--------< onTimeSet() >--------
        //*get Time after Picked in Dialog
        //*comes from:..Activity implements TimePickerDialog.OnTimeSetListener
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, intHourOfDay);
        c.set(Calendar.MINUTE, intMinute);
        c.set(Calendar.SECOND, 0);

        updateAlarmList(intHourOfDay,intMinute);
        startAlarm(c);

//        TextView textViewPicked=(TextView) findViewById(R.id.txtViewAlarm);
//        textViewPicked.setText((intHourOfDay + ":" + intMinute ));
        //--------</ onTimeSet() >--------
    }

    private void updateAlarmList(int intHourOfDay, int intMinute){
        // adapter knows how to create list items for each item in the list.
        TimesAdapter adapter = new TimesAdapter(this, savedAlarms);

        Times testTime = new Times(intHourOfDay, intMinute, "Label", true);

        String message = "Alarm Set for " + ((intHourOfDay/10==0)?"0"+intHourOfDay:intHourOfDay) + ":" + ((intMinute/10==0)?"0"+intMinute:intMinute.toString());
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        savedAlarms.add(testTime);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.

        ListView listView = (ListView) findViewById(R.id.alarm_list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.

        listView.setAdapter(adapter);
    }

    private void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, ALARM_REQ_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent );
        mp = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);

    }

    public static void start_alarm_tone(){
        mp.setLooping(true);
        mp.start();
    }

    public static void stop_alarm_tone(){
        mp.pause();
    }

}