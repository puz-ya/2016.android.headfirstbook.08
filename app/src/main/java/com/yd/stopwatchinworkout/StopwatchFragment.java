package com.yd.stopwatchinworkout;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;

public class StopwatchFragment extends Fragment {

    //seconds left
    private int seconds = 0;
    //currently running?
    private boolean running = false;
    //was working before stop?
    private boolean wasRunning;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_stopwatch);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }

        //start our Handler
        //runTimmer(); // no View yet !
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);
        runTimmer();
        // Inflate the layout for this fragment
        return layout;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running",running);
        savedInstanceState.putBoolean("wasRunning",wasRunning);
    }

    //start stopwatch
    public void onClickStart(View view){
        running = true;
    }

    //stop stopwatch
    public void onClickStop(View view){
        running = false;
    }

    //reset stopwatch
    public void onClickReset(View view){
        running = false;
        seconds = 0;
    }

    private void runTimmer(){
        View view = getView();
        if(view != null) {
            final TextView textView = (TextView) view.findViewById(R.id.time_view);

            //planning code execution
            final Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    int hours = seconds / 3600;
                    int minutes = (seconds % 3600) / 60;
                    int secs = seconds % 60;

                    String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);
                    textView.setText(time);

                    if (running) {
                        seconds++;
                    }
                    //it will last again and again
                    handler.postDelayed(this, 1000);
                }
            };
            handler.post(runnable);
        }
    }

    @Override
    public void onStop(){
        super.onStop();
        wasRunning = running;   //was it working?
        //stop counting time
        running = false;

    }

    @Override
    public void onStart(){
        super.onStart();
        if(wasRunning){
          running = true;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    public void onResume(){
        super.onResume();
        if(wasRunning){
            running = true;
        }
    }

}
