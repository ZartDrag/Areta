package com.example.alarmingo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        AlarmList.start_alarm_tone();
        Intent i = new Intent(context, AlarmRingScreen.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
