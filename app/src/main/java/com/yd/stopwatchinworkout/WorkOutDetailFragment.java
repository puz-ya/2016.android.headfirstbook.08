package com.yd.stopwatchinworkout;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkOutDetailFragment extends Fragment {

    private long mDetailID;

    public WorkOutDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState != null){
            mDetailID = savedInstanceState.getLong("workoutID");
        }else{
            StopwatchFragment stopwatchFragment = new StopwatchFragment();
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            ft.replace(R.id.stopwatch_container, stopwatchFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work_out_detail, container, false);
    }

    public void setWorkout(long id){
        mDetailID = id;
    }

    @Override
    public void onStart(){
        super.onStart();

        View view = getView();
        if(view != null){
            WorkOutData workOutData = WorkOutData.workOutDatas[(int) mDetailID];

            TextView title = (TextView) view.findViewById(R.id.detail_title);
            title.setText(workOutData.getName());

            TextView description = (TextView) view.findViewById(R.id.detail_descr);
            description.setText(workOutData.getDescr());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putLong("workoutID",mDetailID);
    }
}
