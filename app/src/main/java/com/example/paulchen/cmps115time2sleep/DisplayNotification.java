package com.example.paulchen.cmps115time2sleep; /**
 * Created by Travis on 8/21/2015.
 */


import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class DisplayNotification extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_layout);
    }
    public void make(View view){
        Intent intent = new Intent(this, DisplayNotification.class);
        PendingIntent pending = PendingIntent.getActivity(this,0,intent,0);

        Notification notifications = new Notification.Builder(this)
                .setContentTitle("New notification like message from")
                .setContentText("Hii").setSmallIcon(R.drawable.notification)
                .setContentIntent(pending)
                .addAction(R.drawable.reply, "Reply", pending)
                .addAction(R.drawable.cancel, "cancel", pending)
                .addAction(R.drawable.settings, "settings", pending).build();

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notifications.flags |= Notification.FLAG_AUTO_CANCEL;
        manager.notify(0, notifications);

    }

}
