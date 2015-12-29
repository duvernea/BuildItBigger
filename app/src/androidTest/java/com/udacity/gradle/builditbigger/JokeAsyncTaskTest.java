package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;
import android.util.Pair;

import com.example.duvernea.myapplication.backend.myApi.model.MyBean;

import junit.framework.TestResult;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by duvernea on 12/19/15.
 */
public class JokeAsyncTaskTest extends AndroidTestCase {

    private static final String TAG = JokeAsyncTaskTest.class.getSimpleName();

    Exception mError = null;
    CountDownLatch signal = null;
    String jokeSetupString = null;
    String jokePunchlineString = null;

    @Test
    public void testRetrieveJokeStringFromGCE() {
        signal = new CountDownLatch(1);
        Context context = getContext();
        GetEndpointsAsyncTask task = new GetEndpointsAsyncTask();
        task.setListener(new GetEndpointsAsyncTask.GetEndpointsTaskListener() {
            @Override
            public void onComplete(MyBean joke, Exception e) {
                jokeSetupString = joke.getSetup();
                jokePunchlineString = joke.getPunchline();
                mError = e;
                signal.countDown();
            }
        });
        task.execute(new Pair<Context, String>(mContext, "fallback joke?"));
        try {
            signal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertNull(mError);
        assertNotNull(jokeSetupString);
        assertNotNull(jokePunchlineString);
    }
}
