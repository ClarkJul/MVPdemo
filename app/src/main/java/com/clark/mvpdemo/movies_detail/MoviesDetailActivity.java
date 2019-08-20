package com.clark.mvpdemo.movies_detail;

import android.graphics.Movie;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.clark.mvpdemo.R;
import com.clark.mvpdemo.bean.Movies;
import com.clark.mvpdemo.fragment.MoviesDetailFragment;

import java.util.ArrayList;
import java.util.List;

public class MoviesDetailActivity extends AppCompatActivity implements MoviesDetailContract.IView{

    private static final String TAG = MoviesDetailActivity.class.getSimpleName();

    private MoviesDetailContract.Presenter mPresenter;

    private String mMovieInfo = null;
    private String mMovieAlt = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_detail);

        new MovieDetailPresenter((Movies) getIntent().getSerializableExtra("movies"), this);

        //setup view pager
        ViewPager viewPager = (ViewPager) findViewById(R.id.movie_viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.movie_sliding_tabs);
        if (tabLayout != null) {
            tabLayout.addTab(tabLayout.newTab());
            tabLayout.addTab(tabLayout.newTab());
            tabLayout.setupWithViewPager(viewPager);
        }
    }
    private void setupViewPager(ViewPager viewPager) {
        /* 通过Presenter获取Movies相关的Alt，以及MovieInfo， 然后将得到的信息回传到当前Activity中 mMovieInfo， mMovieAlt
            用于创建MovieDetailFragment。
            老实说，这是很扯的方法， 绕了一圈子，就是不让Activity， MovieDetailFragment直接接触Movie数据。
            这里，为了套MVP模式，暂且这么弄。
         */
        mPresenter.loadMovieAlt();
        mPresenter.loadMovieInfo();

//        Log.e(HomeActivity.TAG, "\n\n mMovieInfo = " + mMovieInfo + ", mMovieAlt = " + mMovieAlt);
        MovieDetailPagerAdapter adapter = new MovieDetailPagerAdapter(getSupportFragmentManager());
        MoviesDetailFragment movieInfoFragment = MoviesDetailFragment.createInstance(mMovieInfo, 0);
        MoviesDetailFragment movieWebsiteFragment = MoviesDetailFragment.createInstance(mMovieAlt, 1);

        adapter.addFragment(movieInfoFragment, getString(R.string.movie_info));
        adapter.addFragment(movieWebsiteFragment, getString(R.string.movie_description));
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    public void showCollapsingToolbarTitle(String title) {
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.movie_collapsing_toolbar);
        collapsingToolbar.setTitle(title);
    }

    @Override
    public void showGlideImage(String largeImagePath) {
        ImageView movieImage = (ImageView) findViewById(R.id.movie_image);
        Glide.with(movieImage.getContext())
                .load(largeImagePath)
                .into(movieImage);
    }

    @Override
    public void setMovieInfoToFragment(String movieInfo) {
        mMovieInfo = movieInfo;
    }

    @Override
    public void setMovieAltToFragment(String movieAlt) {
        mMovieAlt = movieAlt;
    }

    @Override
    public void setPresenter(MoviesDetailContract.Presenter presenter) {
        if (presenter!=null)
        mPresenter =presenter;
    }

    static class MovieDetailPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MovieDetailPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
