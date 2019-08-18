package com.clark.mvpdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

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
    private RecyclerView rvHotMovies;
    private MoviesAdapter adapter;

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
                if (moviesInfoList!=null){
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<HotMoviesInfo> call, Throwable t) {
                //获取电影数据失败
                Log.d(TAG, "-->onFailure:Thread.id= "+Thread.currentThread().getId() +",Error:"+t.getMessage());

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
