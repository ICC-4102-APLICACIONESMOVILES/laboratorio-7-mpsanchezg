package com.example.mpsan.broadcastlaboratory;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.channels.NetworkChannel;

public class MainActivity extends AppCompatActivity {

    int UPLOAD_NOTIFICATION_ID = 77;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void startAlert(View view){
        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + AlarmManager.INTERVAL_HALF_HOUR/180000,
                AlarmManager.INTERVAL_HALF_HOUR/180000, pendingIntent);
        Toast.makeText(this, "Alarm set in 10 seconds, " + AlarmManager.INTERVAL_HALF_HOUR/180000,
                Toast.LENGTH_LONG).show();
    }

    private void generateNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channelID")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Subida de Archivo")
                .setContentText("El archivo esta siendo subido al servidor...");
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(UPLOAD_NOTIFICATION_ID, builder.build());

    }

    private void updateNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channelID")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("")
                .setContentText("");
    }
}
