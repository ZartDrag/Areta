package com.example.alarmingo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        AlarmList.start_alarm_tone();
//        Intent myIntent = new Intent(context,AlarmPuzzle1.class);
//        context.startActivity(myIntent);
//        context.startActivity(new Intent(context, AlarmPuzzle1.class));
        Intent i = new Intent(context, AlarmRingScreen.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
//        mp.setLooping(true);
    }
}
