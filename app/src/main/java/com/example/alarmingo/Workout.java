package com.example.alarmingo;

class Workout {
    String Name;
    int Reps;
    int Duration;
    boolean HasReps;

    Workout(String name, int reps, boolean has_reps){
        Name = name;
        HasReps = has_reps;
        if(HasReps){
            Reps = reps;
        } else {
            Duration = reps;
        }
    }

    public String getName() {
        return Name;
    }

    public boolean getHasReps() {
        return HasReps;
    }

    public int getReps() {
        if (HasReps)
            return Reps;
        else
            return Duration;
    }
}

