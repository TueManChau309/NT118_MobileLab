package com.example.lab04_01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver broadcastReceiver;
    private IntentFilter filter;

    public void processReceive(Context context, Intent intent) {
        Toast.makeText(context, getString(R.string.you_have_a_new_message), Toast.LENGTH_LONG).show();

        TextView tvContent = findViewById(R.id.tv_content);
        //Use "pdus" as key to get message
        final String SMS_EXTRA = "pdus";
        Bundle bundle = intent.getExtras();
        //Get array of messages which were received at the same time
        Object[] messages = (Object[]) bundle.get(SMS_EXTRA);
        String sms = "";

        SmsMessage smsMsg;
        for (int i = 0; i < messages.length; i++) {
            sms += "Message " + (i + 1) + ":\n";
            smsMsg = SmsMessage.createFromPdu((byte[]) messages[i]);
            //Get message body
            sms += smsMsg.getMessageBody() + "\n";
            //Get source address of message
            sms += "From: " + smsMsg.getOriginatingAddress() + "\n";
        }
        //Show messages in textview
        tvContent.setText(sms);
    }

    private void initBroadcastReceiver() {
        //Create filter to listen to incoming message
        filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        //Create broadcastReceiver
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            //Process when a message comes
            public void onReceive(Context context, Intent intent) {
                processReceive(context, intent);
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Make sure broadcastReceiver was created
        if (broadcastReceiver == null) {
            initBroadcastReceiver();
        }
        //Register Receiver
        registerReceiver(broadcastReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Unregister when app is destroyed
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBroadcastReceiver();
    }
}