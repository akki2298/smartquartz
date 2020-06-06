package com.akshay.smartquartz.API;

import com.akshay.smartquartz.Bean.Bean_pass;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("SMART_CLOCK.php?methodname=SMART_CLOCK")
    Call<Bean_pass> getPassword();


}
