package com.clark.mvpdemo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HotMoviesInfo {


    /**
     * count : 1
     * start : 0
     * total : 37
     * subjects : [{"rating":{"max":10,"average":5.9,"details":{"1":141,"3":805,"2":367,"5":109,"4":351},"stars":"30","min":0},"genres":["动作","犯罪"],"title":"沉默的证人","casts":[{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1382184082.17.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1382184082.17.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1382184082.17.jpg"},"name_en":"Nick Cheung","name":"张家辉","alt":"https://movie.douban.com/celebrity/1037273/","id":"1037273"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417797081.77.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417797081.77.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417797081.77.jpg"},"name_en":"Zi Yang","name":"杨紫","alt":"https://movie.douban.com/celebrity/1314124/","id":"1314124"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p59065.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p59065.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p59065.jpg"},"name_en":"Richie Jen","name":"任贤齐","alt":"https://movie.douban.com/celebrity/1009888/","id":"1009888"}],"durations":["94分钟"],"collect_count":24813,"mainland_pubdate":"2019-08-16","has_video":false,"original_title":"沉默的证人","subtype":"movie","directors":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21181.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21181.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21181.jpg"},"name_en":"Renny Harlin","name":"雷尼·哈林","alt":"https://movie.douban.com/celebrity/1032052/","id":"1032052"}],"pubdates":["2019-03-18(香港国际电影节)","2019-08-16(中国大陆)","2019-08-22(香港)"],"year":"2019","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2564369311.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2564369311.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2564369311.jpg"},"alt":"https://movie.douban.com/subject/26816090/","id":"26816090"}]
     * title : 正在上映的电影-深圳
     */

    private int count;
    private int start;
    private int total;
    private String title;
    @SerializedName("subjects")
    private List<Movies> movies;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Movies> getMovies() {
        return movies;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }


}
