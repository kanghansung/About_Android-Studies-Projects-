package com.example.sunghyun_dev.seoulspot.SpotItemCustomListView;

import android.graphics.drawable.Drawable;

public class SpotListViewItem {
    private Drawable spotIcon;
    private String spotTitle;
    private String spotDetailAddress;
    private String spotRates;

    public void setSpotIcon(Drawable spotIcon) {
        this.spotIcon = spotIcon;
    }

    public void setSpotDetailAddress(String spotDetailAddress) {
        this.spotDetailAddress = spotDetailAddress;
    }

    public void setSpotRates(String spotRates) {
        this.spotRates = spotRates;
    }

    public void setSpotTitle(String spotTitle) {
        this.spotTitle = spotTitle;
    }

    public Drawable getSpotIcon() {
        return spotIcon;
    }

    public String getSpotDetailAddress() {
        return spotDetailAddress;
    }

    public String getSpotRates() {
        return spotRates;
    }

    public String getSpotTitle() {
        return spotTitle;
    }
}
