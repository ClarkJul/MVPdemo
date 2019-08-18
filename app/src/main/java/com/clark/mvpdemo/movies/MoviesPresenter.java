package com.clark.mvpdemo.movies;

import android.util.Log;

import com.clark.mvpdemo.Constant;
import com.clark.mvpdemo.api.IDoubanService;
import com.clark.mvpdemo.bean.HotMoviesInfo;
import com.clark.mvpdemo.bean.Movies;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesPresenter implements MoviesContract.IPresenter {
    private static final String TAG = Constant.APP_TAG + MoviesPresenter.class.getSimpleName();
    private MoviesContract.IView moviesView;
    private IDoubanService doubanService;
    private boolean isfirstLoad = true;

    public MoviesPresenter(MoviesContract.IView moviesView, IDoubanService doubanService) {
        this.moviesView = moviesView;
        this.doubanService = doubanService;

        moviesView.setPresenter(this);
    }

    @Override
    public void loadMovies(boolean forceUpdate) {
        loadMovies(forceUpdate||isfirstLoad,true);
        isfirstLoad=false;

    }

    @Override
    public void start() {
        loadMovies(false);
    }

    private void loadMovies(boolean forceUpdate, final boolean showLoadingUi) {
        Log.d(TAG, "loadMovies: ");
        if (showLoadingUi) {
            moviesView.setLoading(true);
        }
        if (forceUpdate) {
            doubanService.searchHotMovies(Constant.DOUBAN_APIKEY, "深圳", 0, 10, null, null)
                    .enqueue(new Callback<HotMoviesInfo>() {
                        @Override
                        public void onResponse(Call<HotMoviesInfo> call, Response<HotMoviesInfo> response) {
                            //获取电影数据成功
                            Log.d(TAG, "-->onResponse:Thread.id= " + Thread.currentThread().getId());
                            List<Movies> moviesInfoList = response.body().getMovies();
                            Log.e(TAG, "onResponse: size= " + moviesInfoList.size());
                            for (Movies m : moviesInfoList) {
                                Log.d(TAG, "onResponse: " + m.getTitle());
                            }

                            //获取数据成功，loadingUI消失
                            if (showLoadingUi) {
                                moviesView.setLoading(false);
                            }

                            //View加载数据，刷新UI
                            processMovies(moviesInfoList);

                        }

                        @Override
                        public void onFailure(Call<HotMoviesInfo> call, Throwable t) {
                            //获取电影数据失败
                            Log.d(TAG, "-->onFailure:Thread.id= " + Thread.currentThread().getId() + ",Error:" + t.getMessage());
                        }
                    });
        }
    }

    private void processMovies(List<Movies> moviesInfoList) {
        if (moviesInfoList.isEmpty()){
            //数据为空，执行数据为空的方法
            processEmptyTask();
        }else {
            moviesView.showMovies(moviesInfoList);
        }
    }

    private void processEmptyTask() {
        moviesView.showNoMovies();
    }
}


