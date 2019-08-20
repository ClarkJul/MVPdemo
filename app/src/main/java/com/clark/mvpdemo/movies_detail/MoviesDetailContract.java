package com.clark.mvpdemo.movies_detail;

import com.clark.mvpdemo.base.BasePresenter;
import com.clark.mvpdemo.base.BaseView;

public interface MoviesDetailContract {
    interface IView extends BaseView<Presenter>{
        void showCollapsingToolbarTitle(String title);

        void showGlideImage(String largeImagePath);

        void setMovieInfoToFragment(String movieInfo);

        void setMovieAltToFragment(String movieAlt);
    }
    interface Presenter extends BasePresenter{
        void loadMovieInfo();
        void loadMovieAlt();
    }
}
