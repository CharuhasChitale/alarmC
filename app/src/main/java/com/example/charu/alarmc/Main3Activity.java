package com.example.charu.alarmc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class Main3Activity extends AppCompatActivity {

    private Tracker mTracker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();

        mTracker.send(new HitBuilders.EventBuilder().setCategory("Action").setAction("created").build());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTracker.setScreenName("EndScreen");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }
}
