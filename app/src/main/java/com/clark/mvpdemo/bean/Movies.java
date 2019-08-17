package com.clark.mvpdemo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movies {
    /**
     * rating : {"max":10,"average":5.9,"details":{"1":141,"3":805,"2":367,"5":109,"4":351},"stars":"30","min":0}
     * genres : ["动作","犯罪"]
     * title : 沉默的证人
     * casts : [{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1382184082.17.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1382184082.17.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1382184082.17.jpg"},"name_en":"Nick Cheung","name":"张家辉","alt":"https://movie.douban.com/celebrity/1037273/","id":"1037273"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417797081.77.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417797081.77.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417797081.77.jpg"},"name_en":"Zi Yang","name":"杨紫","alt":"https://movie.douban.com/celebrity/1314124/","id":"1314124"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p59065.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p59065.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p59065.jpg"},"name_en":"Richie Jen","name":"任贤齐","alt":"https://movie.douban.com/celebrity/1009888/","id":"1009888"}]
     * durations : ["94分钟"]
     * collect_count : 24813
     * mainland_pubdate : 2019-08-16
     * has_video : false
     * original_title : 沉默的证人
     * subtype : movie
     * directors : [{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21181.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21181.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21181.jpg"},"name_en":"Renny Harlin","name":"雷尼·哈林","alt":"https://movie.douban.com/celebrity/1032052/","id":"1032052"}]
     * pubdates : ["2019-03-18(香港国际电影节)","2019-08-16(中国大陆)","2019-08-22(香港)"]
     * year : 2019
     * images : {"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2564369311.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2564369311.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2564369311.jpg"}
     * alt : https://movie.douban.com/subject/26816090/
     * id : 26816090
     */

    private RatingBean rating;
    private String title;
    private int collect_count;
    private String mainland_pubdate;
    private boolean has_video;
    private String original_title;
    private String subtype;
    private String year;
    private ImagesBean images;
    private String alt;
    private String id;
    private List<String> genres;
    private List<CastsBean> casts;
    private List<String> durations;
    private List<DirectorsBean> directors;
    private List<String> pubdates;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public String getMainland_pubdate() {
        return mainland_pubdate;
    }

    public void setMainland_pubdate(String mainland_pubdate) {
        this.mainland_pubdate = mainland_pubdate;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<String> getDurations() {
        return durations;
    }

    public void setDurations(List<String> durations) {
        this.durations = durations;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<String> getPubdates() {
        return pubdates;
    }

    public void setPubdates(List<String> pubdates) {
        this.pubdates = pubdates;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 5.9
         * details : {"1":141,"3":805,"2":367,"5":109,"4":351}
         * stars : 30
         * min : 0
         */

        private int max;
        private double average;
        private DetailsBean details;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public DetailsBean getDetails() {
            return details;
        }

        public void setDetails(DetailsBean details) {
            this.details = details;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public static class DetailsBean {
            /**
             * 1 : 141.0
             * 3 : 805.0
             * 2 : 367.0
             * 5 : 109.0
             * 4 : 351.0
             */

            @SerializedName("1")
            private double _$1;
            @SerializedName("3")
            private double _$3;
            @SerializedName("2")
            private double _$2;
            @SerializedName("5")
            private double _$5;
            @SerializedName("4")
            private double _$4;

            public double get_$1() {
                return _$1;
            }

            public void set_$1(double _$1) {
                this._$1 = _$1;
            }

            public double get_$3() {
                return _$3;
            }

            public void set_$3(double _$3) {
                this._$3 = _$3;
            }

            public double get_$2() {
                return _$2;
            }

            public void set_$2(double _$2) {
                this._$2 = _$2;
            }

            public double get_$5() {
                return _$5;
            }

            public void set_$5(double _$5) {
                this._$5 = _$5;
            }

            public double get_$4() {
                return _$4;
            }

            public void set_$4(double _$4) {
                this._$4 = _$4;
            }
        }
    }

    public static class ImagesBean {
        /**
         * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2564369311.jpg
         * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2564369311.jpg
         * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2564369311.jpg
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class CastsBean {
        /**
         * avatars : {"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1382184082.17.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1382184082.17.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1382184082.17.jpg"}
         * name_en : Nick Cheung
         * name : 张家辉
         * alt : https://movie.douban.com/celebrity/1037273/
         * id : 1037273
         */

        private AvatarsBean avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean {
            /**
             * small : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1382184082.17.jpg
             * large : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1382184082.17.jpg
             * medium : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1382184082.17.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class DirectorsBean {
        /**
         * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21181.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21181.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21181.jpg"}
         * name_en : Renny Harlin
         * name : 雷尼·哈林
         * alt : https://movie.douban.com/celebrity/1032052/
         * id : 1032052
         */

        private AvatarsBeanX avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBeanX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanX avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBeanX {
            /**
             * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21181.jpg
             * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21181.jpg
             * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21181.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }
}