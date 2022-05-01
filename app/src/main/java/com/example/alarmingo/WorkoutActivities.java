package com.example.alarmingo;

import java.util.ArrayList;

class Workout{
    String Name;
    int Reps;
    int Duration;
    boolean reps;
    float calories;

    Workout(String n, int R, int D, boolean r, float c){
        Name = n;
        Reps = R;
        Duration = D;
        reps = r;
        calories = c;
    }

    public String getName() {
        return Name;
    }

    public int getReps() {
        if(reps)
            return Reps;
        else
            return Duration;
    }

    public float getCalories() {
        return calories;
    }
}
public class WorkoutActivities {

    ArrayList<Workout> items = new ArrayList<>();


}
