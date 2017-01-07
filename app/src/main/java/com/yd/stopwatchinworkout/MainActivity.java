package com.yd.stopwatchinworkout;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity
        extends Activity
        implements WorkOutListFragment.WorkOutListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void itemClicked(long id){

        View fragmentContainer = findViewById(R.id.fragment_container);

        //large screen (tablet)
        if(fragmentContainer != null){
            WorkOutDetailFragment detailFragment = new WorkOutDetailFragment();
            detailFragment.setWorkout(id);

            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, detailFragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }else{
            //small screen (phones) - new Activity
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.mEXTRA_ID, id);
            startActivity(intent);
        }


    }
}
