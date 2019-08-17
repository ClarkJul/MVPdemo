package com.clark.mvpdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clark.mvpdemo.Constant;
import com.clark.mvpdemo.R;
import com.clark.mvpdemo.api.DouBanManager;
import com.clark.mvpdemo.api.IDoubanService;
import com.clark.mvpdemo.bean.HotMoviesInfo;
import com.clark.mvpdemo.bean.Movies;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MoviesFragment extends Fragment {
    private static final String TAG=Constant.APP_TAG+MoviesFragment.class.getSimpleName();

    private List<Movies> moviesInfoList=new ArrayList<>();

    public MoviesFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onAttach(Context context) {
        Log.d(TAG, "-->onAttach: "+context.getClass().getSimpleName());
        loadMovies(new Callback<HotMoviesInfo>() {
            @Override
            public void onResponse(Call<HotMoviesInfo> call, Response<HotMoviesInfo> response) {
                //获取电影数据成功
                Log.d(TAG,"-->onResponse:Thread.id= "+Thread.currentThread().getId());
                moviesInfoList=response.body().getMovies();

                Log.e(TAG,  "onResponse: size= "+moviesInfoList.size());
                for (Movies m: moviesInfoList) {
                    Log.d(TAG, "onResponse: "+m.getTitle());
                }
            }

            @Override
            public void onFailure(Call<HotMoviesInfo> call, Throwable t) {
                //获取电影数据失败
                Log.d(TAG, "-->onFailure:Thread.id= "+Thread.currentThread().getId()
                        +",Error:"+t.getMessage());

            }
        });
        super.onAttach(context);
    }

    /**
     * 请求电影数据的方法
     * @param callback
     */
    private void loadMovies(Callback<HotMoviesInfo> callback){
        Log.d(TAG, "loadMovies: ");
        IDoubanService moviesService=DouBanManager.createDoubanService();
        moviesService.searchHotMovies(Constant.DOUBAN_APIKEY,"深圳",0,10,null,null).enqueue(callback);
    }
}
