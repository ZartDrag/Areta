package com.example.alarmingo;

import java.util.ArrayList;

public class Times {

    private int Hour, Minutes;
    private String Label;
    private boolean Status; //to know if the alarm is active
    private ArrayList<String> Days; //The days of the week come here

    public Times(int hour, int minute, String label, boolean status, ArrayList<String> days){
        Hour = hour;
        Minutes = minute;
        Label = label;
        Status = status;
        Days = days;
    }

    public Times(int hour, int minute, String label, boolean status) {
        Hour = hour;
        Minutes = minute;
        Label = label;
        Status = status;
    }

    public String getTime() { return ((Hour/10==0)?"0"+Hour:Hour)+":"+((Minutes/10==0)?"0"+Minutes:Minutes); } //to add a 0 if its a single digit number

    public int getHours(){ return Hour; }

    public int getMinutes(){ return Minutes; }

    public String getLabel(){ return Label; }

    public boolean getStatus(){ return Status; }

    public ArrayList<String> getDays(){ return Days; }

    public void updateHours(int newVal){ Hour = newVal; }

    public void updateMinutes(int newVal){ Minutes = newVal; }

    public void updateLabel(String newVal){ Label = newVal; }

    public void updateStatus(boolean newVal){ Status = newVal; }

    public void updateDays(ArrayList<String> newVal){ Days = newVal; }


}


