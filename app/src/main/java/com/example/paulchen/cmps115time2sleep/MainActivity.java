package com.example.paulchen.cmps115time2sleep;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button setTime = (Button) findViewById(R.id.buttonTest);
        setTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                // Change to the Alarm Setup Activity
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
