package com.yd.stopwatchinworkout;

/**
 * Created by YD on 06.01.2017.
 */

public class WorkOutData {

    private String mName;
    private String mDescr;

    public static final WorkOutData[] workOutDatas = {
            new WorkOutData("The Limb Loosener",
                    "5 Handstand push-ups\n10 1-legged squats\n15 Pull-ups"),
            new WorkOutData("Core Agony",
                    "100 Pull-ups\n100 Push-ups\n100 Sit-ups\n100 Squats"),
            new WorkOutData("The Wimp Special",
                    "5 Pull-ups\n10 Push-ups\n15 Squats"),
            new WorkOutData("Strength and Length",
                    "500 meter run\n21 x 1.5 pood kettleball swing\n21 x pull-ups")
    };

    private WorkOutData(String name, String descr){
        mName = name;
        mDescr = descr;
    }

    public String getName(){
        return mName;
    }

    public String getDescr(){
        return mDescr;
    }

    //string view of this object
    public String toString(){
        return mName;
    }
}
