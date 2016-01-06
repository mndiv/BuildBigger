package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.myapplication.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.jokedisplay.JokeDisplayActivitiy;

import java.io.IOException;

/**
 * Created by DivyaM on 1/4/2016.
 */
public class JokesEndpointsAsyncTask extends AsyncTask<Pair<Context, String>, String, String> {
    private static MyApi myApiService = null;
    private Context context;
    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, JokeDisplayActivitiy.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(JokeDisplayActivitiy.JOKE_KEY, result);
        context.startActivity(intent);

    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://gcebackendproject.appspot.com/_ah/api/");
            // end options for devappserver

                    myApiService = builder.build();
        }
        context = params[0].first;
        String name = params[0].second;

        try {
            return myApiService.sayHi(name).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }

    }
}
