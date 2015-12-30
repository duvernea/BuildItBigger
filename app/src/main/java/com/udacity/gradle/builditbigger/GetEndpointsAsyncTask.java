package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

import com.example.duvernea.jokedisplay.JokeDisplayActivity;
import com.example.duvernea.myapplication.backend.myApi.MyApi;
import com.example.duvernea.myapplication.backend.myApi.model.MyBean;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by duvernea on 12/19/15.
 */
public class GetEndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, MyBean> {

    private static final String TAG = GetEndpointsAsyncTask.class.getSimpleName();

    private MyApi myApiService = null;
    private Context context;

    private GetEndpointsTaskListener mListener = null;
    private Exception mError = null;

    public interface GetEndpointsTaskListener {
        public void onComplete(MyBean joke, Exception e);
    }
    public GetEndpointsAsyncTask setListener(GetEndpointsTaskListener listener) {
        this.mListener = listener;
        return this;
    }
    @Override
    protected MyBean doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-1155.appspot.com/_ah/api/");
            // end options for devappserver
            myApiService = builder.build();
        }
        context = params[0].first;
        // String name = params[0].second;

        try {
            MyBean jokeBean = myApiService.getJoke().execute();
            return jokeBean;
        } catch (IOException e) {
            Log.d(TAG, "IOException caught");
            mError = e;
            return null;
        }
    }
    @Override
    protected void onPostExecute(MyBean result) {
        if (this.mListener != null) {
            this.mListener.onComplete(result, mError);
        }
    }
}