package com.example.stress;

import android.app.ActivityManager;
import android.content.Context;

import static android.content.Context.ACTIVITY_SERVICE;

/**
 * Created by QuangCV on 26-Sep-2019
 **/

public class Utils {

    private static Utils instance;

    public static Utils getInstance() {
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }

    public String text = "EMPTY";
    public int count = 0;

    // https://stackoverflow.com/questions/2298208/how-do-i-discover-memory-usage-of-my-application-in-android#answer-13656833
    public String getUsedSize(Context c) {
        ActivityManager activityManager = (ActivityManager) c.getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo m = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(m);
        return String.format("%.2f mb", (double) (m.totalMem - m.availMem) / 1024 / 1024);
    }

}