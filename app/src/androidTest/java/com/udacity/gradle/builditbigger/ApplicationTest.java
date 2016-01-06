package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;
import android.test.mock.MockContext;
import android.util.Pair;

import junit.framework.Assert;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    Exception mError = null;
    CountDownLatch signal = null;
    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    public void tearDown() throws Exception {
        signal.countDown();
    }

    @Override
    public void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    public void testSuccessfulFetch() {
        Context context = new MockContext();
        JokesEndpointsAsyncTask jokesTask = new JokesEndpointsAsyncTask();
        jokesTask.execute(new Pair<Context, String>(context, "Manfred"));
        String joke = null;
        try {
            joke = jokesTask.get(30, TimeUnit.SECONDS);
            Assert.assertFalse(joke.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}