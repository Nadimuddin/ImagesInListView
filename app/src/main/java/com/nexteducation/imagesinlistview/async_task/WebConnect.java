package com.nexteducation.imagesinlistview.async_task;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.nexteducation.imagesinlistview.model.DataModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by next on 22/12/16.
 */
public class WebConnect extends AsyncTask<String, String , ArrayList<DataModel>>
{

    @Override
    protected ArrayList doInBackground(String... urls)
    {
        String content = new String();
        ArrayList<DataModel> arrayList = null;
        try {
            URL url = new URL(urls[0]);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

            InputStream in = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String str;
            while ((str = br.readLine()) != null)
            {
                content = content+str;
            }

            arrayList = getData(content);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return arrayList;
    }

    ArrayList<DataModel> getData(String content) throws JSONException {

        int rank;
        String country, population, flagUrl;
        Bitmap bitmap;
        ArrayList<DataModel> arrayList = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(content);
        JSONArray jsonArray = jsonObject.optJSONArray("worldpopulation");


        for (int i=0; i<jsonArray.length(); i++)
        {
            JSONObject object = (JSONObject) jsonArray.get(i);

            rank = object.getInt("rank");
            country = object.getString("country");
            population = object.getString("population");
            flagUrl = object.getString("flag");
            DownloadImage download = new DownloadImage();
            //onProgressUpdate("downloading...("+rank+"/10)");
            publishProgress("downloading...("+rank+"/10)");
            bitmap = download.downloadImage(flagUrl);

            arrayList.add(new DataModel(rank, country, population, bitmap));
        }

        return arrayList;
    }
}
