package com.example.mybook.Fragments;


import com.example.mybook.Notifications.MyResponse;
import com.example.mybook.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService
{
    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAAY3UfOao:APA91bGBn9GYeyvbZ_rvsJRisH4GYa2PadAxFKISKU0IqOQPvuTCNK_uX9J5sDU-Mnj2Re9JVTeKBlZtN1mtKVRJvrBSA00PJjQH2MiavsTvw8aHfoMagVLYm1kDjQtjUwTu81qsCKJ8"
    })

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
