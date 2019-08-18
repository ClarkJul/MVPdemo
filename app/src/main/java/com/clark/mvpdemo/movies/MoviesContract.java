package com.clark.mvpdemo.movies;

import com.clark.mvpdemo.base.BasePresenter;
import com.clark.mvpdemo.base.BaseView;
import com.clark.mvpdemo.bean.Movies;

import java.util.List;

public interface MoviesContract {
    interface IView extends BaseView<IPresenter>{
        void showMovies(List<Movies> movies);
        void showNoMovies();
        void setLoading(boolean active);

    }
    interface IPresenter extends BasePresenter{
        void loadMovies(boolean forceUpdate);
    }
}
