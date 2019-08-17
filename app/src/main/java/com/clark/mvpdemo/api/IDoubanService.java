package com.clark.mvpdemo.api;

import com.clark.mvpdemo.bean.HotMoviesInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IDoubanService {
    String hot_movies_url="&city={city}&start={start}&count={count}&client=&udid=";
    @GET(hot_movies_url)
    Call<HotMoviesInfo> searchHotMovies(@Path("city") String city,
                                        @Path("start") String start,
                                        @Path("count") String count);
}
