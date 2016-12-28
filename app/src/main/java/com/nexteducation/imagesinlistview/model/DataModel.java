package com.nexteducation.imagesinlistview.model;

import android.graphics.Bitmap;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.StrictMode;

/**
 * Created by next on 22/12/16.
 */
public class DataModel
{
    int mRank;
    String mCountry;
    String mPopulation;
    Bitmap mFlag;
    public DataModel(int rank, String country, String population, Bitmap flag)
    {
        mRank = rank;
        mCountry = country;
        mPopulation = population;
        mFlag = flag;
    }

    public int getRank() {
        return mRank;
    }

    public String getCountry() {
        return mCountry;
    }

    public String getPopulation() {
        return mPopulation;
    }

    public Bitmap getFlag() {
        return mFlag;
    }
}
