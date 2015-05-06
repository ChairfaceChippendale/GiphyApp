package com.example.lessonAndr09;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.text.SimpleDateFormat;
import java.util.*;


public class DownloadActivity extends Activity {

    MyTask downloadGifs;
    TextView downloadProg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download);

        Intent intent = getIntent();
        String tags = intent.getStringExtra("tags");
        downloadProg = (TextView) findViewById(R.id.download_progress);

        downloadGifs = new MyTask();
        downloadGifs.execute(tags);

    }



    class MyTask extends AsyncTask<String, Integer, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(String... params)
        {

            GifsByTags giphy = new GifsByTags();
            ArrayList<String> gifsUrls = new ArrayList<String>();

            try {

                String giphyURL = Const.GIPHY_URL_START + params[0] + Const.GIPHY_URL_END;
                Log.d("myLog", giphyURL);
/*

                HttpClient client = new DefaultHttpClient();
                HttpPost post = new HttpPost(giphyURL);
                HttpResponse response = client.execute(post);
                HttpEntity entity = response.getEntity();

                String responseString = EntityUtils.toString(entity, "UTF-8");
                */

                int timeoutConnection = 3000;
                HttpParams httpParameters = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);

                int timeoutSocket = 5000;
                HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

                DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
                HttpGet httpGet = new HttpGet(giphyURL);
                HttpResponse httpResponse = httpClient.execute(httpGet);
                if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                    throw new Exception("Request resulted with other than HTTP OK 200");
                }
                HttpEntity httpEntity = httpResponse.getEntity();
                String responseString = EntityUtils.toString(httpEntity, "UTF-8");



                Log.d("myTag", "" + responseString);

                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                giphy = gson.fromJson(responseString, GifsByTags.class);

                Log.d("myLog", "" + giphy.getData().size());

                for (GiphyData i: giphy.getData())
                {
                    Log.d("myLog",i.getImeges().getOriginal().getUrl());
                    gifsUrls.add(i.getImeges().getOriginal().getUrl());
                }



            } catch (Exception e) {
                e.printStackTrace();
            }

            return gifsUrls;

        }

        @Override
        protected void onPostExecute(ArrayList<String> gifsUrls) {
            super.onPostExecute(gifsUrls);

            Intent intent = new Intent(DownloadActivity.this, GifsActivity.class);
            intent.putStringArrayListExtra("gifs", gifsUrls);

            startActivity(intent);
            finish();

        }
    }



}