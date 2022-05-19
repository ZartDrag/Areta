package com.example.alarmingo;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONreciever {
    @GET("monday")
    Call<List<Workout>> getMonday();

    @GET("tuesday")
    Call<List<Workout>> getMondayTuesday();

    @GET("wednesday")
    Call<List<Workout>> getWednesday();

    @GET("friday")
    Call<List<Workout>> getFriday();

    @GET("saturday")
    Call<List<Workout>> getSaturday();

    @GET("stretching")
    Call<List<Workout>> getStretches();

}