package com.moctis.helloworld.app;

import android.app.Activity;
import android.util.Log;

/**
 * Created by moctis on 28/6/2557.
 * Copyright
 */
public class LogHelper {
    private static final String LOG_TAG = "ACTIVITY_EVENT";

    public static void LogCallback(Activity activity, String callbackName) {
        String logMsg = String.format("Activity:%s | Callback:%s", activity.getClass(), callbackName);
        Log.d(LOG_TAG, logMsg);
    }
}
