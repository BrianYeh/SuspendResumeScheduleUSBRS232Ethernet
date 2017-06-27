package reboot.com.firich.rebootschedule;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by brianyeh on 2017/6/27.
 */
public class AlarmReceiver extends BroadcastReceiver
{
    String strTagUtil = "Reboot.";
    private boolean bDebugOn = true;
    private static final String ALARM_RECEIVE_TURN_ON="android.intent.action.ALARM_RECEIVE_TURN_ON";
    private void dump_trace( String bytTrace)
    {
        if (bDebugOn)
            Log.d(strTagUtil, bytTrace);
    }
    @Override
    public void onReceive(Context context, Intent intent)
    {

        // Your code to execute when the alarm triggers
        // and the broadcast is received.
        /*
        dump_trace("TurnOnScreenThread:run:to turn on screen by start new activity:");
        Intent intentTimeout = new Intent(MainActivity.this,MainActivity.class);
        finish();
        intentTimeout.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intentTimeout.putExtra("from_sleep_schedule", true);
        startActivity(intentTimeout);
        dump_trace("startActivity:from_sleep_schedule");
        */
        dump_trace("AlarmReceiver:onReceive: start");
        Bundle bData = intent.getExtras();
        if(bData.get("msg").equals(ALARM_RECEIVE_TURN_ON)) {
        //if ("fec.intent.action.AlarmReceiver".equals(intent.getAction())) {
            dump_trace("AlarmReceiver: ALARM_RECEIVE_TURN_ON");
            Intent testIntent = new Intent(context, MainActivity.class);
            testIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            testIntent.putExtra("from_sleep_schedule", true);
            context.startActivity(testIntent);
        }
    }
}
