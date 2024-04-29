package com.mrk.entity;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class BannerData {
    private String favCategory; // 图书种类
    private String bannerName; // 图片路径

    public String getFavCategory() {
        return favCategory;
    }

    public void setFavCategory(String favCategory) {
        this.favCategory = favCategory;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }
}

