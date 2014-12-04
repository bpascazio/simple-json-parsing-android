package edu.pace.pclc.simplejsonparsing;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class DownloadPostTask extends AsyncTask<String, Void, JSONObject> {

    View rootView;

    public DownloadPostTask(View rootView) {
        super();
        this.rootView = rootView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);

        try {

            String postId = jsonObject.getString("_id");
            Log.d("DownloadPostTask", "postId is "+postId);

            String posterNameString = jsonObject.getString("posterName");
            Log.d("DownloadPostTask", "posterNameString is "+posterNameString);

            TextView posterName = (TextView)rootView.findViewById(R.id.posterName);
            posterName.setText(posterNameString);

        } catch (Exception e) {

            Log.d("DownloadPostTask", "yikes! "+e.getMessage());

        }

    }

    @Override
    protected JSONObject doInBackground(String... urls) {

        HttpClient httpclient = new DefaultHttpClient();

        HttpGet httpget = new HttpGet(urls[0]);

        HttpResponse response;

        JSONObject json_object = null;

        try {

            response = httpclient.execute(httpget);

            Log.d("DownloadPostTask", response.getStatusLine().toString());

            String json_string = EntityUtils.toString(response.getEntity());

            Log.d("DownloadPostTask", json_string);

            json_object = new JSONObject(json_string);

        } catch (Exception e) {

            Log.d("DownloadPostTask", e.getMessage());

        }

        return json_object;
    }
}
