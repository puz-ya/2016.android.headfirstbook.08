package com.yd.stopwatchinworkout;


import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link ListFragment} subclass.
 */
public class WorkOutListFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //creating list of names
        int arrLength = WorkOutData.workOutDatas.length;
        String[] names = new String[arrLength];
        for(int i=0; i<arrLength; i++){
            names[i] = WorkOutData.workOutDatas[i].getName();
        }

        //create String List adapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                inflater.getContext(),
                android.R.layout.simple_list_item_1,
                names);
        setListAdapter(arrayAdapter);

        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    static interface WorkOutListener{
        void itemClicked(long id);
    }

    private WorkOutListener mWorkOutListener;

    @Override   //new version, NO (Activity activity) :\
    public void onAttach(Context context){
        super.onAttach(context);

        Activity activity;
        if(getActivity() != null){
            activity = getActivity();

            //WTF?
            this.mWorkOutListener = (WorkOutListener) activity;
        }
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id){
        if(mWorkOutListener != null){
            //listener will hear the CLICK
            mWorkOutListener.itemClicked(id);
        }
    }

}
