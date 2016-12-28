package com.nexteducation.imagesinlistview.async_task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by next on 22/12/16.
 */
public class DownloadImage
{
    public Bitmap downloadImage(String url)
    {
        Bitmap bitmap = null;
        HttpURLConnection urlConnection;
        try {
            URL url1 = new URL(url);

            urlConnection = (HttpURLConnection) url1.openConnection();

            InputStream in = urlConnection.getInputStream();

            bitmap = BitmapFactory.decodeStream(new BufferedInputStream(in));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
