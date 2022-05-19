package com.example.alarmingo;

class Workout {
    public Workout(String _id, String name, String reps, String has_reps) {
        this.name = name;
        this.reps = reps;
        this.has_reps = has_reps;
    }

    String name, reps, has_reps;


    public String getName() {
        return name;
    }

    public String getReps() {
        return reps;
    }

    public String getHas_reps() {
        return has_reps;
    }
}

