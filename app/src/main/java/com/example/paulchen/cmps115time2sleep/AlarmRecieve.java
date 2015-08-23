package com.example.paulchen.cmps115time2sleep;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

/**
 * Created by Paul Chen on 8/19/2015.
 */
public class AlarmRecieve extends BroadcastReceiver {


    /**
     * Created by Paul Chen on 8/19/2015.
     */

        @Override
        public void onReceive(Context context, Intent intent)
        {
            // TODO Auto-generated method stub


            // here you can start an activity or service depending on your need
            // for ex you can start an activity to vibrate phone or to ring the phone

            String phoneNumberReciever="14087722017";// phone number to which SMS to be send
            String message="test run";// message to send
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNumberReciever, null, message, null, null);
            // Show the toast  like in above screen shot
            Toast.makeText(context, "Alarm Triggered and SMS Sent", Toast.LENGTH_LONG).show();


        }
    }


