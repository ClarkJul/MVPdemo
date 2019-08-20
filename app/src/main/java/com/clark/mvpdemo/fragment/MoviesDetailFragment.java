package com.clark.mvpdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.clark.mvpdemo.HomeActivity;
import com.clark.mvpdemo.R;
import com.clark.mvpdemo.movies_detail.WebViewActivity;

public class MoviesDetailFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = MoviesDetailFragment.class.getSimpleName();

    private String mUrl;

    public MoviesDetailFragment() {
        // Required empty public constructor
    }

    public static MoviesDetailFragment createInstance(String info, int type) {
        MoviesDetailFragment movieDetailFragment = new MoviesDetailFragment();
        Bundle args = new Bundle();
        args.putString("info", info);
        args.putInt("type", type);//0: 影片信息Tab; 1: 简介Tab
        movieDetailFragment.setArguments(args);
//        Log.d(TAG, "\n info: " + info + " type: " + type);
        return movieDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_detail, container, false);
        TextView textInfo = (TextView) view.findViewById(R.id.tvInfo);
        textInfo.setText(getArguments().getString("info"));

        if(1 == getArguments().getInt("type")) {
            textInfo.setOnClickListener(this);
            mUrl = textInfo.getText().toString();
        }
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvInfo:
                Log.e(HomeActivity.TAG, "===> website click!!!!");
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("website", mUrl);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
