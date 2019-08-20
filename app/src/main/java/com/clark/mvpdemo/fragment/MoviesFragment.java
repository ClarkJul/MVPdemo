package com.clark.mvpdemo.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.clark.mvpdemo.Constant;
import com.clark.mvpdemo.R;
import com.clark.mvpdemo.bean.Movies;
import com.clark.mvpdemo.movies.MoviesContract;
import com.clark.mvpdemo.movies_detail.MoviesDetailActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MoviesFragment extends Fragment implements MoviesContract.IView {
    private static final String TAG=Constant.APP_TAG+MoviesFragment.class.getSimpleName();

    private List<Movies> moviesInfoList=new ArrayList<>();
    private RecyclerView rvHotMovies;
    private ProgressBar pbLoadingView;
    private MoviesAdapter adapter;

    private MoviesContract.IPresenter presenter;

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
        View view=inflater.inflate(R.layout.fragment_movies, container, false);
        Log.d(TAG, "onCreateView: ");
        initView(view);
        return view;
    }

    private void initView(View view) {
        rvHotMovies = view.findViewById(R.id.recycler_hot_movies);
        pbLoadingView=view.findViewById(R.id.pb_loading);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        if (rvHotMovies!=null){
            adapter = new MoviesAdapter();
            GridLayoutManager manager=new GridLayoutManager(getActivity(),2);
            rvHotMovies.setLayoutManager(manager);
            rvHotMovies.setAdapter(adapter);
        }
    }

    @Override
    public void onAttach(Context context) {
        Log.d(TAG, "-->onAttach: "+context.getClass().getSimpleName());
        super.onAttach(context);
        if (presenter!=null){
            presenter.start();
        }
    }

    @Override
    public void showMovies(List<Movies> movies) {
        if (moviesInfoList.size()>0){
            moviesInfoList.clear();
        }
        moviesInfoList=movies;
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showNoMovies() {

    }

    @Override
    public void setLoading(boolean active) {
        if (pbLoadingView==null) return;
        if (active){
            //显示loadingView
            pbLoadingView.setVisibility(View.VISIBLE);
        }else {
            //隐藏loadingView
            pbLoadingView.setVisibility(View.GONE);
        }
    }

    @Override
    public void setPresenter(MoviesContract.IPresenter presenter) {
        //结合Presenter类的presenter
        this.presenter=presenter;
    }


    class MoviesAdapter extends RecyclerView.Adapter{

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view=LayoutInflater.from(getActivity()).inflate(R.layout.recyclerview_movies_item,viewGroup,false);
            MoviesHolder holder=new MoviesHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            Movies m=moviesInfoList.get(i);
            MoviesHolder holder= (MoviesHolder) viewHolder;
            holder.movieTitle.setText(m.getTitle());
            holder.ratingStar.setNumStars((int) (m.getRating().getAverage()/2));
            holder.movieAverage.setText(m.getRating().getAverage()+"");
            Glide.with(getActivity()).load(m.getImages().getLarge()).into(holder.movieCover);
            holder.itemView.setOnClickListener(view->{
                Context context = getContext();
                if (context == null) return;
                Intent intent = new Intent(context, MoviesDetailActivity.class);
                intent.putExtra("movies", (Serializable) m);
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;

                    Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, holder.movieAverage, "cover").toBundle();
                    ActivityCompat.startActivity(activity, intent, bundle);
                }
            });
        }

        @Override
        public int getItemCount() {
            return moviesInfoList==null?0:moviesInfoList.size();
        }
    }

    class MoviesHolder extends RecyclerView.ViewHolder{
        public ImageView movieCover;
        public TextView movieTitle;
        public RatingBar ratingStar;
        public TextView movieAverage;

        public MoviesHolder(@NonNull View itemView) {
            super(itemView);
            movieCover = itemView.findViewById( R.id.movie_cover );
            movieTitle = itemView.findViewById( R.id.movie_title );
            ratingStar = itemView.findViewById( R.id.rating_star );
            movieAverage = itemView.findViewById( R.id.movie_average );
        }
    }
}
