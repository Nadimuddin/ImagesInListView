package com.nexteducation.imagesinlistview;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.nexteducation.imagesinlistview.adapter.Adapter;
import com.nexteducation.imagesinlistview.async_task.WebConnect;
import com.nexteducation.imagesinlistview.model.DataModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener
{
    ArrayList<DataModel> mArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.list_view);

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching data...");
        progressDialog.show();
        progressDialog.setCancelable(false);

        WebConnect webConnect = new WebConnect(){

            @Override
            protected void onProgressUpdate(String ... message)
            {
                super.onProgressUpdate(message);
                progressDialog.setMessage(message[0]);
            }

            @Override
            protected void onPostExecute(ArrayList<DataModel> arrayList) {
                super.onPostExecute(arrayList);

                Adapter adapter = new Adapter(arrayList, getBaseContext());
                listView.setAdapter(adapter);
                mArrayList = arrayList;
                progressDialog.dismiss();
            }
        };

        webConnect.execute("http://www.androidbegin.com/tutorial/jsonparsetutorial.txt");

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Toast.makeText(this, mArrayList.get(position).getCountry()+" List item: "+(position+1), Toast.LENGTH_SHORT)
                .show();
    }
}
