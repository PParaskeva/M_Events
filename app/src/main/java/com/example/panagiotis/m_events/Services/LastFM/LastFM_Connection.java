package com.example.panagiotis.m_events.Services.LastFM;

import com.example.panagiotis.m_events.Constants.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class LastFM_Connection {

    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;

    public static IData_LastFM getLastFMConnection(){
        HttpLoggingInterceptor interceptor= new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient= new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit=new Retrofit.Builder()
                .baseUrl(Constants.BASE_LastFM_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(IData_LastFM.class);

    }
}
