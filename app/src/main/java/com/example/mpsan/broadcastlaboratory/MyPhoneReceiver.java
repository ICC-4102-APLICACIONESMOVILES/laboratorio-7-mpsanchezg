package com.example.mpsan.broadcastlaboratory;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by mpsan on 22-05-2018.
 */

public class MyPhoneReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Don't panik but your time is up!!!!.",
                Toast.LENGTH_LONG).show();

        Log.i("Autostart", "started");
        Intent intent1 = new Intent(context, MainActivity.class);
        context.startActivity(intent1);
    }
}
