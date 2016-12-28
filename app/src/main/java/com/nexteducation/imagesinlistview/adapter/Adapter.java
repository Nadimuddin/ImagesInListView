package com.nexteducation.imagesinlistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nexteducation.imagesinlistview.R;
import com.nexteducation.imagesinlistview.model.DataModel;

import java.util.ArrayList;

/**
 * Created by next on 22/12/16.
 */
public class Adapter extends BaseAdapter
{
    ArrayList<DataModel> mArrayList;
    LayoutInflater mInflater;
    public Adapter(ArrayList<DataModel> arrayList, Context context)
    {
        mArrayList = arrayList;
        mInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        ImageView flag;
        TextView country, rank, population;

        if(view == null)
            view = mInflater.inflate(R.layout.view, parent, false);

        flag = (ImageView)view.findViewById(R.id.flag);
        country = (TextView)view.findViewById(R.id.country);
        rank = (TextView)view.findViewById(R.id.rank);
        population = (TextView)view.findViewById(R.id.population);

        DataModel dataModel = mArrayList.get(position);

        flag.setImageBitmap(dataModel.getFlag());
        country.setText("Country: "+dataModel.getCountry());
        rank.setText("Rank #"+Integer.toString(dataModel.getRank()));
        population.setText("Population: "+dataModel.getPopulation());

        return view;
    }

}
