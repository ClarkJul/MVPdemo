package com.clark.mvpdemo.api;

import com.clark.mvpdemo.bean.HotMoviesInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IDoubanService {
    String hot_movies_url="in_theaters";
    //?apikey="+Constant.DOUBAN_APIKEY +"&city={city}&start={start}&count={count}&client=&udid=";
    @GET(hot_movies_url)
    Call<HotMoviesInfo> searchHotMovies(/*@QueryMap Map<String,String> map*/
                                        @Query("apikey") String apikey,
                                        @Query("city") String city,
                                        @Query("start") int start,
                                        @Query("count") int count,
                                        @Query("client") String client,
                                        @Query("udid") String udid);
}
