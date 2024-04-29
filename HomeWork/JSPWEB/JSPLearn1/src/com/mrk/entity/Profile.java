package com.mrk.entity;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Profile {
    private String userId; // 用户编号
    private String langPref; // 母语
    private String favCategory; // 喜欢的种类
    private int myListOpt; // 选择标记
    private int bannerOpt; // 选择标记

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLangPref() {
        return langPref;
    }

    public void setLangPref(String langPref) {
        this.langPref = langPref;
    }

    public String getFavCategory() {
        return favCategory;
    }

    public void setFavCategory(String favCategory) {
        this.favCategory = favCategory;
    }

    public int getMyListOpt() {
        return myListOpt;
    }

    public void setMyListOpt(int myListOpt) {
        this.myListOpt = myListOpt;
    }

    public int getBannerOpt() {
        return bannerOpt;
    }

    public void setBannerOpt(int bannerOpt) {
        this.bannerOpt = bannerOpt;
    }
}
