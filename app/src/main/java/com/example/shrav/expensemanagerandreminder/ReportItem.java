package com.example.shrav.expensemanagerandreminder;

/**
 * Created by shrav on 11/15/2016.
 */
public class ReportItem {
    public String name;
    public String amouunt;
    public String date;
    public String image;

    public ReportItem(String name, String amouunt, String date, String image) {
        this.name = name;
        this.amouunt = amouunt;
        this.date = date;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmouunt() {
        return amouunt;
    }

    public void setAmouunt(String amouunt) {
        this.amouunt = amouunt;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
