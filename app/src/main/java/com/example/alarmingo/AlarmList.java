package com.example.alarmingo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;

public class AlarmList extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private static final String KEY_ALARMS = "KEY_ALARMS";
    public static ArrayList<Times> savedAlarms = new ArrayList<>();
    static final int ALARM_REQ_CODE = 100;
    static MediaPlayer mp;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_list);

        Button buttonTimePicker = findViewById(R.id.SetAlarmButton);
        listView = findViewById(R.id.alarm_list);
        buttonTimePicker.setOnClickListener(v -> TimeDialog(this));
    }

    public static void TimeDialog(FragmentActivity con) {
        DialogFragment timePicker = new TimePickerFragment();
        timePicker.show(con.getSupportFragmentManager(), "time picker");
    }

    void saveData() {
        SharedPreferences sp = getSharedPreferences("AlarmPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String savedAlarmsJSONString = new Gson().toJson(savedAlarms);
        editor.putString(KEY_ALARMS, savedAlarmsJSONString);
        editor.apply();
    }

    void loadData() {

        SharedPreferences sharedPreferences = getSharedPreferences("AlarmPrefs", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(KEY_ALARMS, null);

        Type type = new TypeToken<ArrayList<Times>>() {
        }.getType();

        savedAlarms = gson.fromJson(json, type);

        if (savedAlarms == null) {
            savedAlarms = new ArrayList<>();
        }
        updateAlarmList();

    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
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

        updateAlarmList(intHourOfDay, intMinute);
        startAlarm(c);

//        TextView textViewPicked=(TextView) findViewById(R.id.txtViewAlarm);
//        textViewPicked.setText((intHourOfDay + ":" + intMinute ));
        //--------</ onTimeSet() >--------
    }

    private void updateAlarmList(int intHourOfDay, int intMinute) {
        // adapter knows how to create list items for each item in the list.
        TimesAdapter adapter = new TimesAdapter(this, savedAlarms);

        Times testTime = new Times(intHourOfDay, intMinute, "Label", true);

        String message = "Alarm Set for " + ((intHourOfDay / 10 == 0) ? "0" + intHourOfDay : intHourOfDay) + ":" + ((intMinute / 10 == 0) ? "0" + intMinute : intMinute);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        savedAlarms.add(testTime);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.

        ListView listView = findViewById(R.id.alarm_list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.

        listView.setAdapter(adapter);
    }

    public void updateAlarmList() {
        TimesAdapter adapter = new TimesAdapter(this, savedAlarms);
        listView.setAdapter(adapter);
    }

    private void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, AlertReceiver.class);
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent pendingIntent = PendingIntent.getBroadcast(this, ALARM_REQ_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
        mp = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);

    }

    public static void start_alarm_tone() {
        mp.setLooping(true);
        mp.start();
    }

    public static void stop_alarm_tone() {
        mp.pause();
    }

}