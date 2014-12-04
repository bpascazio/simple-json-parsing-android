package edu.pace.pclc.simplejsonparsing;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class DownloadPostTask extends AsyncTask<String, Void, JSONObject> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);
    }

    @Override
    protected JSONObject doInBackground(String... urls) {

        HttpClient httpclient = new DefaultHttpClient();

        HttpGet httpget = new HttpGet(urls[0]);

        HttpResponse response;

        try {

            response = httpclient.execute(httpget);

            Log.d("DownloadPostTask", response.getStatusLine().toString());

            String json_string = EntityUtils.toString(response.getEntity());

            Log.d("DownloadPostTask", json_string);

        } catch (Exception e) {

        }

        return null;
    }
}
