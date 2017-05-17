package com.example.shrav.expensemanagerandreminder;

/**
 * Created by shrav on 11/27/2016.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmManagerBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context arg0, Intent arg1) {
        Toast.makeText(arg0, "Alarm is set!", Toast.LENGTH_LONG).show();

    }

}
