package com.yd.stopwatchinworkout;

import android.app.Activity;
import android.os.Bundle;

public class DetailActivity extends Activity {

    public static final String mEXTRA_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        WorkOutDetailFragment workOutDetailFragment = (WorkOutDetailFragment) getFragmentManager().findFragmentById(R.id.detail_fragment);
        long workoutID = (long) getIntent().getExtras().get(mEXTRA_ID);
        workOutDetailFragment.setWorkout(workoutID);
    }
}
