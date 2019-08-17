package com.clark.mvpdemo.api;

import com.clark.mvpdemo.Constant;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DouBanManager {
    private static IDoubanService doubanService;
    public synchronized static IDoubanService createDoubanService(){
        if (doubanService==null){
//            Retrofit retrofit=new Retrofit.Builder()
//                    .baseUrl(Constant.DOUBAN_BASE_URL)
//                    .build();

            Retrofit retrofit=createRetrofit();

            doubanService=retrofit.create(IDoubanService.class);
        }
        return doubanService;
    }
    private static Retrofit createRetrofit(){
        OkHttpClient httpClient;
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient=new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();

        return new Retrofit.Builder()
                .baseUrl(Constant.DOUBAN_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
    }
}
